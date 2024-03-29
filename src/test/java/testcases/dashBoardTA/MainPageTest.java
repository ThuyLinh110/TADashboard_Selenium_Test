package testcases.dashBoardTA;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.logigear.common.JsonUtils;
import org.logigear.common.Log;
import org.logigear.common.WebElementManager;
import org.logigear.constant.Constant;
import org.logigear.pageObjects.dashBoardTA.AddPage;
import org.logigear.pageObjects.dashBoardTA.LoginPage;
import org.logigear.pageObjects.dashBoardTA.MainPage;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest{
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    AddPage addPage = new AddPage();

    //Load data
    JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
    JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
    String validUserName = account.get("User Name").toString();
    String validPassword = account.get("Password").toString();

    @Test
    public void TC11(){
        Log.info("Verify that user is unable open more than 1 'New Page' dialog");
        Log.info("Step1: Navigate to Dashboard login page");
        Log.info("Step2: Login with valid account");
        loginPage.login(validUserName, validPassword);
        WebElementManager.waitToDisplayElement();
        Log.info("Step3: Go to Global Setting -> Add page");
        mainPage.hoverDdpGlobalSetting();
        mainPage.clickOption("Add Page");
        Log.info("User cannot go to Global Setting -> Add page while 'New Page' dialog appears.");

    }

    @Test
    public void TC21() throws InterruptedException {
        Log.info("Verify that user is able to edit the name of the page (Parent/Sibbling) successfully");
        Log.info("Step1: Navigate to Dashboard login page");
        Log.info("Step2: Login with valid account");
        loginPage.login(validUserName, validPassword);
        Log.info("Step3: Go to Global Setting -> Add page");
        mainPage.hoverDdpGlobalSetting();
        mainPage.clickOption("Add Page");
        Log.info("Step4: Enter info into all required fields on New Page dialog");
        addPage.fillDataWithTwoFields("Page 1","Overview");
        addPage.clickBtnInForm("OK");
        Log.info("Step5: Go to Global Setting -> Add page");
        mainPage.hoverDdpGlobalSetting();
        mainPage.clickOption("Add Page");
        Log.info("Step6: Enter info into all required fields on New Page dialog");
        addPage.fillDataWithTwoFields("Page 2","Page 1");
        addPage.clickBtnInForm("OK");
        Log.info("Step7: Go to the first created page");
        mainPage.hoverDdpNav("/TADashboard/coooav44rqyi.page");
        Log.info("Step8: Click Edit link ");
        mainPage.hoverDdpGlobalSetting();
        mainPage.clickOption("Edit");
        Log.info("Step9: Step Enter another name into Page Name field Page name: Page 3");
        addPage.fillDataWithTwoFields("Page 3","Page 1");
        addPage.clickBtnInForm("OK");
        Log.info("User is able to edit the name of parent page successfully");

    }

}
