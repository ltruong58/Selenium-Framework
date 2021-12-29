package pages.utils;

public interface Config {

    // Environment for remote
    String environment = System.getProperty("env","Int");
    String host = System.getProperty("host", "local");

    //SauceLabs Chrome Web Variables
    String browserName =System.getProperty("browserName","Chrome");
    String browserVersion = System.getProperty("version","latest");
    String platform = System.getProperty("platform","Windows 10");
    String screenResolution = System.getProperty("screenResolution", "1920x1080");

    //SauceLabs MobileAndroidWeb Variables
    String mobileBrowserName=System.getProperty("mobileBrowserName", "Chrome");
    String appiumVersion = System.getProperty("appiumVersion", "1.19.1");
    String deviceName = System.getProperty("deviceName","Samsung Galaxy Tab A 10 GoogleAPI Emulator");
    String deviceOrientation = System.getProperty("deviceOrientation", "portrait");
    String platformVersion=System.getProperty("platformVersion", "8.1");
    String platformName=System.getProperty("platformName","Android");
    String timeout=System.getProperty("timeout","1000");

    //SauceLabs Mobile iOSWeb Variables
    String iOSmobileBrowserName=System.getProperty("mobileBrowserName", "safari");
    String iOSdeviceName = System.getProperty("deviceName","iPhone XS Max Simulator");
    String iOSplatformName=System.getProperty("platformName","iOS");
    String iOSplatformVersion = System.getProperty("platformVersion","14.0");

    //SauceLabs tablet iOSWeb Variables

}