package testcases.dashBoardTA;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.logigear.common.JsonUtils;
import org.logigear.common.Log;
import org.logigear.common.WebElementManager;
import org.logigear.constant.Constant;
import org.logigear.pageObjects.dashBoardTA.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void TC01() {
//      Load data
        JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        String validUserName = account.get("User Name").toString();
        String validPassword = account.get("Password").toString();

//      PageObject
        LoginPage loginPage = new LoginPage();

//      Excute Testcase
        Log.info("TC01- Verify that user can login specific repository successfully via Dashboard login page with correct credentials ");
        Log.info("Step 1 : Open DA  ");
        loginPage.login(validUserName, validPassword);
        Log.info("Step 2 : Login with valid Email and Password");
        WebElementManager.waitToDisplayElement();
        String acc = loginPage.getNameAccount(validUserName);
        System.out.println(Constant.EXISTED_ACC_DATA_PATH);

    }
}
