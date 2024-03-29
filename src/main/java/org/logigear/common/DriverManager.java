package org.logigear.common;
import org.logigear.constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class DriverManager {
    public static void openBrowser(String browserType){
        switch (browserType) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver",Constant.FIREFOX_DRIVER_PATH);
                Constant.WEBDRIVER = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_PATH);
                Constant.WEBDRIVER = new ChromeDriver();
                break;
            default:
                break;
        }
    }

    public static void maximizePage(){
        Constant.WEBDRIVER.manage().window().maximize();
    }

    public static void openPageByUrl(String baseUrl)
    {
        Constant.WEBDRIVER.navigate().to(baseUrl);
    }

}
