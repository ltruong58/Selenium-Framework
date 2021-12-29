package pages.actions;

import org.openqa.selenium.support.PageFactory;
import pages.locators.LoginLocators;
import pages.utils.SeleniumDriver;

public class LoginActions {
    private LoginLocators loginLocators;
    // Actions actions = new Actions(SeleniumDriver.getDriver());

    public LoginActions() {
        this.loginLocators = new LoginLocators();
        PageFactory.initElements(SeleniumDriver.getDriver(), loginLocators);
    }

    public void enterUsername(String username) {
        loginLocators.enterUsername.sendKeys(username + "\t");
    }

    public void clickLoginButton() throws InterruptedException {
        loginLocators.loginButton.click();
    }

    public void enterPassword(String password) {
        loginLocators.enterPassword.sendKeys(password + "\t");
    }
}
