package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.actions.LoginActions;

public class LoginSteps {

    private LoginActions loginActions = new LoginActions();
    @When("^I enters email \"([^\"]*)\"$")
    public void iEnterUsername(String username) throws Throwable {

        loginActions.enterUsername(username);

        Thread.sleep(2000);
    }

    @And("^I click log in button$")
    public void iClickLogInButton() throws InterruptedException {

       loginActions.clickLoginButton();
        Thread.sleep(1000);
    }

    @And("^I enter password \"([^\"]*)\"$")
    public void iEnterPassword(String password) throws Throwable {

        loginActions.enterPassword(password);
        Thread.sleep(2000);
    }

    @Then("^I verify the home page$")
    public void iVerifyTheHomePage() {
    }

    @Then("^I verify the Invalid username or password\\.$")
    public void iVerifyTheInvalidUsernameOrPassword() {

    }

    @When("^I click forgot password$")
    public void iClickForgotPassword() {
    }

    @And("^I test if this work$")
    public void iTestIfThisWork() {
    }
}
