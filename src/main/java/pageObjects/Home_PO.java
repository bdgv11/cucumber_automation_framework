package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_PO extends Base_PO{

    // Web Element
    @FindBy(xpath = "//a[@class='account']/span")
    WebElement username_logged;

    // Constructor
    public Home_PO(){
        super();
    }

    // Methods

    public String getUsernameLogged(){
        return getTextFromElement(username_logged);
    }




}
