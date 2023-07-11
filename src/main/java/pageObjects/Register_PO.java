package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.GlobalVars;

public class Register_PO extends Base_PO {

    // Web elements
    //@FindBy(xpath = "//input[@name='id_gender'][@value='1']")
    @FindBy(xpath = "//label[@class='radio-inline'][1]/span")
    WebElement mr_radiobutton;

    @FindBy(xpath = "//label[@class='radio-inline'][2]/span")
    WebElement mrs_radiobutton;

    @FindBy(name = "firstname")
    WebElement firstname_textField;

    @FindBy(xpath = "//input[@name='lastname'][@class='form-control']")
    WebElement lastname_textField;

    @FindBy(xpath = "//input[@name='email'][@class='form-control']")
    WebElement email_textField;

    @FindBy(name = "password")
    WebElement password_textField;

    @FindBy(xpath = "//button[@class='btn']")
    WebElement show_hide_button;

    @FindBy(name = "birthday")
    WebElement birthday_textField;

    @FindBy(xpath = "//input[@name='optin'][@type='checkbox']")
    WebElement offers_checkbox;

    @FindBy(xpath = "//input[@name='newsletter'][@type='checkbox']")
    WebElement newsletter_checkbox;

    //@FindBy(xpath = "//input[@name='psgdpr'][@type='checkbox']")
    @FindBy(xpath = "//*[@id='customer-form']/section/div[9]/div[1]/span/label")
    WebElement terms_conditions_checkbox;

    @FindBy(xpath = "//footer/button[@type='submit']")
    WebElement save_button;

    @FindBy(xpath = "//a[@class='account']/span")
    WebElement username_logged;


    // Constructor
    public Register_PO() {
        super();
    }

    // Methods
    public void navigateToRegisterPage() {
        navigateToUrl(GlobalVars.STORE_HOMEPAGE + "/login?create_account=1");
    }

    public void clickOnMrRadioButton() {
        clickOnElement(mr_radiobutton);
    }

    public void clickOnMrsRadioButton() {
        clickOnElement(mrs_radiobutton);
    }

    public void setRandomFirstname() {
        typeOnElement(firstname_textField, "FN_" + generateRandomString(5));
    }

    public void setRandomLastname() {
        typeOnElement(lastname_textField, "LN_" + generateRandomString(5));
    }

    public void setRandomEmail() {
        typeOnElement(email_textField, "test_" + generateRandomNumber(3) + "@mail.com");
    }

    public void setRandomPassword() {
        typeOnElement(password_textField, generateRandomNumber(5) + generateRandomString(10));
    }

    public void setRandomBirthdate() {
        typeOnElement(birthday_textField, "10/10/1970");
    }

    // Specific parameters

    public void setSpecificFirstname(String firstname) {
        typeOnElement(firstname_textField, firstname);
    }

    public void setSpecificLastname(String lastname) {
        typeOnElement(lastname_textField, lastname);
    }

    public void setSpecificEmail(String email) {
        typeOnElement(email_textField, email);
    }

    public void setSpecificPassword(String password) {
        typeOnElement(password_textField, password);
    }

    public void setSpecificBirthdate(String date) {
        typeOnElement(birthday_textField, date);
    }

    //

    public void clickOnOffersCheckbox() {
        clickOnElement(offers_checkbox);
    }

    public void clickOnNewsletterCheckbox() {
        clickOnElement(newsletter_checkbox);
    }

    public void clickTermsAndConditionsCHeckbox() {
        clickOnElement(terms_conditions_checkbox);
    }

    public void clickOnSaveButton() {
        clickOnElement(save_button);
    }

    public String getUsernameLogged() {

        return getTextFromElement(username_logged);

    }


}
