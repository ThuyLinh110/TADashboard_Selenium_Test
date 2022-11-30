package org.logigear.constant;

import org.logigear.common.Utilities;
import org.openqa.selenium.WebDriver;

public class Constant {
    public static WebDriver WEBDRIVER ;
    public static final String TA_URL = "http://localhost/TADashboard/login.jsp";
    public static final String EXISTED_ACC_DATA_PATH  =  Utilities.getPathProject()+"/src/main/java/org/logigear/dataObjects/ExistedAccountData.json";

    public static final String LOG4J_PATH = Utilities.getPathProject()+"/src/main/resources/log4j.xml";

    public static final String CHROME_DRIVER_PATH = Utilities.getPathProject()+"/src/main/java/org/logigear/excutables/chromedriver.exe";

    public static final String FIREFOX_DRIVER_PATH = Utilities.getPathProject()+"/src/main/java/org/logigear/excutables/geckodriver.exe";

}

