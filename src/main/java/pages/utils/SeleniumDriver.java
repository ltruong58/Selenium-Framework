package pages.utils;

import cucumber.api.Scenario;
import org.json.JSONException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static pages.utils.Config.*;


public class SeleniumDriver {
    private static SeleniumDriver seleniumDriver;

    //initialize webdriver
    private static WebDriver driver;

    //initialize timeouts
    public final static int TIMEOUT = 30;
    public final static int PAGE_LOAD_TIMEOUT = 20;

    //SauceLabs Config
    public static final String USERNAME = "Max.Muerzati";
    public static final String ACCESS_KEY = "0483da9b-dc20-4a4d-9e54-808f3a5dc9a2";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    public static String sessionId = null;
    public static String jobName = null ;

    // constructor
    private SeleniumDriver(Scenario scenario) throws MalformedURLException {

        String window;
        DesiredCapabilities caps;
        RemoteWebDriver webDriver;
        ThreadLocal<WebDriver> remoteDriver = new ThreadLocal<>();
        switch(Config.host)
        {
            case "local":


                System.setProperty("webdriver.chrome.driver", "chromedriver");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                window=driver.getWindowHandle();
                System.out.println("Window ->"+window);
                driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
                driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
                break;

            // remote desktop web
            case "Remote":
                caps = new DesiredCapabilities();
                caps.setCapability("browserName", browserName);
                caps.setCapability("version", browserVersion);
                caps.setCapability("platform", platform);
                caps.setCapability("screenResolution", screenResolution);
                //caps.setCapability("TunnelName","");
                //caps.setCapability("tunnelIdentifier","");
                jobName = scenario.getName();
                caps.setCapability("name", jobName);
                webDriver = new RemoteWebDriver(new URL(URL),caps);
                remoteDriver.set(webDriver);
                driver = remoteDriver.get();
                sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
                driver.manage().window().maximize();
                window=driver.getWindowHandle();
                System.out.println("Window ->"+window);
                break;

            // remote desktop web
            case "RemoteAndroidWeb":
                caps = DesiredCapabilities.android();
                caps.setCapability("appiumVersion", appiumVersion);
                caps.setCapability("deviceName",deviceName);
                caps.setCapability("deviceOrientation", deviceOrientation);
                caps.setCapability("browserName", mobileBrowserName);
                caps.setCapability("platformVersion", platformVersion);
                caps.setCapability("platformName", platformName);
                caps.setCapability("recreateChromeDriverSessions", true);
                caps.setCapability("newCommandTimeout",timeout);
                jobName = scenario.getName();
                caps.setCapability("name", jobName);
                webDriver = new RemoteWebDriver(new URL(URL),caps);
                remoteDriver.set(webDriver);
                driver = remoteDriver.get();
                sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
                break;

            case "RemoteIOSWeb":
                caps = DesiredCapabilities.iphone();
                caps.setCapability("appiumVersion", appiumVersion);
                caps.setCapability("deviceName",iOSdeviceName);
                caps.setCapability("deviceOrientation", deviceOrientation);
                caps.setCapability("screenResolution", screenResolution);
                caps.setCapability("browserName", iOSmobileBrowserName);
                caps.setCapability("platformVersion",iOSplatformVersion);
                caps.setCapability("platformName", iOSplatformName);
                caps.setCapability("recreateChromeDriverSessions", true);
                caps.setCapability("newCommandTimeout",timeout);
                jobName = scenario.getName();
                caps.setCapability("name", jobName);
                driver = new RemoteWebDriver(new URL(URL), caps);
                sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
                break;

            case "RemoteIOSTablet":
                caps = DesiredCapabilities.iphone();
                caps.setCapability("appiumVersion", "1.19.1");
                caps.setCapability("deviceName","iPad (7th generation) Simulator");
                caps.setCapability("deviceOrientation", "portrait");
                caps.setCapability("platformVersion","14.0");
                caps.setCapability("platformName", "iOS");
                caps.setCapability("browserName", "Safari");
                caps.setCapability("recreateChromeDriverSessions", true);
                caps.setCapability("newCommandTimeout",timeout);
                jobName = scenario.getName();
                caps.setCapability("name", jobName);
                driver = new RemoteWebDriver(new URL(URL), caps);
                sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
                break;

        }
    }

    // method to set up the SeleniumDriver
    public static void setUpDriver(Scenario scenario) throws MalformedURLException {
        try {
            if (seleniumDriver == null)
                seleniumDriver = new SeleniumDriver( scenario);
        }
        catch (UnsupportedCommandException e){
            seleniumDriver = new SeleniumDriver( scenario);
        }
    }

    // method to tear down the SeleniumDriver
    public static void tearDown(Scenario scenario) {
        if (driver != null) {
            driver.quit();
            driver = null;
            try {
                SauceUtils.UpdateResults( USERNAME, ACCESS_KEY, !scenario.isFailed(), SeleniumDriver.sessionId);
            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }
            System.out.println("SauceOnDemandSessionID="+ SeleniumDriver.sessionId + "job-name="+ SeleniumDriver.jobName);
        }
        seleniumDriver = null;
    }

    // method to open a web page
    public static void openPage(String url) {
        System.out.println(url);
        System.out.println(driver);
        driver.get(url);
    }

    // method to get the SeleniumDriver
    public static WebDriver getDriver() {
        return driver;
    }
}