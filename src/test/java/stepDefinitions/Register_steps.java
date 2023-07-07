package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Home_PO;
import pageObjects.Register_PO;

public class Register_steps extends Base_PO {

    Register_PO registerPo;
    Home_PO homePo;

    public Register_steps(Register_PO registerPo, Home_PO homePo) {
        this.registerPo = registerPo;
        this.homePo = homePo;
    }

    @Given("I can access to test store register page")
    public void i_can_access_to_test_store_register_page() {
        registerPo.navigateToRegisterPage();
    }

    @And("I click on Mr radio option")
    public void i_click_on_mr_radio_option() {
        registerPo.clickOnMrRadioButton();
    }

    @And("I enter a specific firstname {string}")
    public void i_enter_a_specific_firstname(String firstname) {
        registerPo.setSpecificFirstname(firstname);
    }

    @And("I enter a specific lastname {string}")
    public void i_enter_a_specific_lastname(String lastname) {
        registerPo.setSpecificLastname(lastname);
    }

    @And("I enter a random email")
    public void i_enter_a_random_email() {
        registerPo.setRandomEmail();
    }

    @And("I enter a specific password {string}")
    public void i_enter_a_specific_password(String password) {
        registerPo.setSpecificPassword(password);
    }

    @And("I enter a specific birthday {string}")
    public void i_enter_a_specific_birthday(String date) {
        registerPo.setSpecificBirthdate(date);
    }

    @And("I left offers and newsletter empty")
    public void i_left_offers_and_newsletter_empty() {
    }

    @And("I click on terms and conditions checkbox")
    public void i_click_on_terms_and_conditions_checkbox() {
        registerPo.clickTermsAndConditionsCHeckbox();
    }

    @And("I click on the save button")
    public void i_click_on_the_save_button() {
        registerPo.clickOnSaveButton();
    }


    @Then("I should be able to see the name {string} logged")
    public void i_should_be_able_to_see_the_name_logged(String nameLogged) {
        Assert.assertEquals(homePo.getUsernameLogged(), nameLogged);
    }
}
