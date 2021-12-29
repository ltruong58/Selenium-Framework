package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginLocators {


    @FindBy(how = How.XPATH, using = "//input[@id='loginUsername']")
    public WebElement enterUsername;

    @FindBy(how = How.XPATH, using = "//input[@id='loginPassword']")
    public WebElement enterPassword;

    @FindBy(how = How.XPATH, using = "//button[text()='Login']")
    public WebElement loginButton;




}



// write ff -> create steps-> find locators-> take actions (coding) -> calling object of the page (method name of actions) in the steps