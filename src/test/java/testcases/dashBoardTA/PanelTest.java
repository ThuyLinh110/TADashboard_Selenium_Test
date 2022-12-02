package testcases.dashBoardTA;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.logigear.common.JsonUtils;
import org.logigear.common.Log;
import org.logigear.common.WebElementManager;
import org.logigear.constant.Constant;
import org.logigear.pageObjects.dashBoardTA.LoginPage;
import org.logigear.pageObjects.dashBoardTA.PanelsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PanelTest extends BaseTest{
    @Test
    public void TC31(){
//      Load data
        JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        String validUserName = account.get("User Name").toString();
        String validPassword = account.get("Password").toString();

//      PageObject
        LoginPage loginPage = new LoginPage();
        PanelsPage panelsPage = new PanelsPage();

//      Excute Testcase
        Log.info("TC01- Verify that user can login specific repository successfully via Dashboard login page with correct credentials ");
        Log.info("Step 1 : Open DA  ");
        loginPage.login(validUserName, validPassword);
        Log.info("Step 2 : Login with valid Email and Password");
        WebElementManager.waitToDisplayElement();
        panelsPage.hoverDdpNav("Administer");
        panelsPage.clickOption("Panels");
        Log.info("Step 3 : Click on Administer/Panels link");
        panelsPage.openAddNewPanelForm();
        Log.info("Step 4 : Click on Add new link");
        Assert.assertEquals(panelsPage.getLabelSetting(), "Chart Settings");
        Log.info("Step 5 : Verify that chart panel setting form is displayed with corresponding panel type selected ");
        panelsPage.clickRbnType(" Indicator");
        Log.info("Step 6 : Select Indicator type");
        Assert.assertEquals(panelsPage.getLabelSetting(), "Indicator Settings");
        Log.info("Step 7 : Verify that indicator panel setting form is displayed with corresponding panel type selected ");
        panelsPage.clickRbnType(" Report");
        Log.info("Step 8 : Select Report type");
        panelsPage.clickRbnType(" Heat Map");
        Log.info("Step 10 : Select Heat Map type");
        Assert.assertEquals(panelsPage.getLabelSetting(), "Heat Map Settings");
        Log.info("Step 11 : Verify that heat map panel setting form is displayed with corresponding panel type selected ");
    }
}
