package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.GlobalVars;

import java.util.List;

public class Product_PO extends Base_PO {

    // Web Elements
    @FindBy(xpath = "//li[@id='category-5']//a[contains(text(),'Women')]")
    WebElement women_clothes_subcategory;

    @FindBy(xpath = "//li[@id='category-3']/a[@class='dropdown-item']")
    WebElement clothes_category;

    @FindBy(xpath = "//div[@id='js-product-list']/div/article/div/div[1]/h2/a")
    List<WebElement> products_list;


    // Constructor
    public Product_PO() {
        super();
    }

    // Methods
    public void navigateToHomePage() {
        navigateToUrl(GlobalVars.STORE_HOMEPAGE);
    }

    public void hoverOnClothesCategory() {
        hoverOnElement(clothes_category);
    }

    public void clickOnWomenClotheSubCategory() {
        clickOnElement(women_clothes_subcategory);
    }

    public boolean areThereWomenProductsAvailable() {

        int count = 0;

        for (WebElement element : products_list) {
            count++;
            System.out.println(element.getAttribute("text"));
        }

        return count > 0;
    }


}
