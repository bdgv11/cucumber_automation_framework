package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.Home_PO;
import pageObjects.Login_PO;

public class Login_steps {

    // Instance of LOGIN page object
    private final Login_PO login_po;
    private final Home_PO homePo;

    // Constructor
    public Login_steps(Login_PO login_po, Home_PO homePo) {
        this.login_po = login_po;
        this.homePo = homePo;
    }

    // First test
    @Given("I can access to test store login page")
    public void i_can_access_to_test_store_login_page() {
        login_po.navigateToLoginPage();
    }

    @And("I type a email {string}")
    public void i_type_a_email(String email) {
        login_po.setEmail(email);
    }

    @And("I type a password {string}")
    public void i_type_a_password(String pass) {
        login_po.setPassword(pass);
    }

    @And("I click on sign in button")
    public void i_click_on_sign_in_button() {
        login_po.clickSignInButton();
    }

    @Then("I should be able to log in and see the name logged {string}")
    public void i_should_be_able_to_log_in_and_see_the_name_logged(String name) {
        Assert.assertEquals(homePo.getUsernameLogged(), name);
    }

    // Second test

    @Then("I should be able to see the {string} error message")
    public void i_should_be_able_to_see_the_error_message(String expectedMessage) {
        login_po.authenticationFailedMessage(expectedMessage);
    }

    // Multiple scenarios
    @And("I enter a email {}")
    public void i_enter_a_email(String email) {
        login_po.setEmail(email);
    }

    @And("I enter a password {}")
    public void i_enter_a_password(String password) {
        login_po.setPassword(password);
    }

    @Then("I should be presented with the following email validation messages {}")
    public void i_should_be_presented_with_the_following_email_validation_messages(String message) {
        Assert.assertEquals(message, login_po.getEmailErrorMsg());
    }

    @Then("I should be presented with the following password validation messages {}")
    public void i_should_be_presented_with_the_following_password_validation_messages(String message) {
        Assert.assertEquals(message, login_po.getPasswordErrorMsg());

    }

}