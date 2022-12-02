package testcases.dashBoardTA;

import org.apache.log4j.xml.DOMConfigurator;
import org.logigear.common.DriverManager;
import org.logigear.common.Log;
import org.logigear.common.Utilities;
import org.logigear.constant.Constant;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    @Parameters("browser")

    @BeforeMethod
    public void beforeMethod(String browserType) {
        Log.info("Pre-condition");
        DriverManager.openBrowser(browserType);
        DriverManager.maximizePage();
        DriverManager.openPageByUrl(Constant.TA_URL);
        DOMConfigurator.configure(Constant.LOG4J_PATH);

    }
    @AfterMethod
    public void afterMethod() {
        Log.info("Post-condition");
        Constant.WEBDRIVER.quit();
    }
}