package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Product_PO;

public class Product_steps extends Base_PO {

    private final Product_PO productPo;

    public Product_steps(Product_PO productPo) {
        this.productPo = productPo;
    }

    @Given("I can access to store home page")
    public void i_can_access_to_store_home_page() {
        productPo.navigateToHomePage();
    }

    @When("I click to women clothes sub category")
    public void i_click_to_women_clothes_sub_category() {
        productPo.hoverOnClothesCategory();
        productPo.clickOnWomenClotheSubCategory();
    }

    @Then("I should be presented with at least one available listed product")
    public void i_should_be_presented_with_at_least_one_available_listed_product() {
        Assert.assertTrue(productPo.areThereWomenProductsAvailable(), "There are not listed products");
    }


}
