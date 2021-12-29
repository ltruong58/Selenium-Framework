package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import pages.utils.SeleniumDriver;

import java.net.MalformedURLException;

public class AfterActions {

    @After
    public static void tearDown(Scenario scenario) throws MalformedURLException, InterruptedException {
        try {
            WebDriver driver = SeleniumDriver.getDriver();
            if (scenario.isFailed()) {
              //  byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
           //     scenario.embed(screenshotBytes, "image/png");
            }
            SeleniumDriver.tearDown(scenario);
        }
        catch (NoSuchSessionException e){
            SeleniumDriver.tearDown(scenario);
        }
        catch (UnsupportedCommandException e){
            SeleniumDriver.setUpDriver(scenario);
        }
        catch (WebDriverException e){
            SeleniumDriver.tearDown(scenario);
        }
    }
}


