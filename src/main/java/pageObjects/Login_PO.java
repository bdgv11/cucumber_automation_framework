package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.GlobalVars;

public class Login_PO extends Base_PO {

    // Web Elements
    @FindBy(xpath = "//input[@class='form-control'][@name='email']")
    WebElement email_TextField;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password_TextField;

    @FindBy(id = "submit-login")
    WebElement submit_button;

    @FindBy(xpath = "//div[@class='help-block']/ul/li[@class='alert alert-danger']")
    WebElement authFailed_alert;

    @FindBy(xpath = "//div[@class='user-info']/a[1]")
    WebElement signOut_button;

    @FindBy(xpath = "//input[@class='form-control'][@name='email']")
    WebElement form_control_emailErrorMsg;

    @FindBy(xpath = "//input[@name='password']")
    WebElement form_control_passwordErrorMsg;


    // Constructor
    /*
    This code allow us to inherit the elements created in Base_PO class
    to interact here in an easier way
    * */
    public Login_PO() {
        super();
    }

    // Methods

    public void navigateToLoginPage() {
        navigateToUrl(GlobalVars.STORE_HOMEPAGE + "/login?back=my-account");
    }

    public void setEmail(String email) {
        typeOnElement(email_TextField, email);
    }

    public void setPassword(String pass) {
        typeOnElement(password_TextField, pass);
    }

    public void clickSignInButton() {
        clickOnElement(submit_button);
    }

    public void authenticationFailedMessage(String expectedMessage) {
        waitForElement(authFailed_alert);
        Assert.assertEquals(authFailed_alert.getText(), expectedMessage);
    }
    public String getEmailErrorMsg() {
        return getTextFromDefaultPopUpErrorMsg(form_control_emailErrorMsg, "validationMessage");
    }

    public String getPasswordErrorMsg() {
        return getTextFromDefaultPopUpErrorMsg(form_control_passwordErrorMsg, "validationMessage");
    }
}