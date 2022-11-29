package org.logigear.pageObjects.dashBoardTA;

import org.logigear.common.WebElementManager;
import org.logigear.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private By txtUserName = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.className("btn-login");

    private String lblNameAccount = "//a[contains(text(),'%s')]";

    private WebElement getTxtUserName(){
        return Constant.WEBDRIVER.findElement(txtUserName);
    }
    private WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(txtPassword);
    }
    private WebElement getBtnLogin(){
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    private WebElement getLblAccountName(String account){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(lblNameAccount, account)));
    }

    public void FillData(String userName, String password) {
        getTxtUserName().clear();
        getTxtPassword().clear();
        getTxtUserName().sendKeys(userName);
        getTxtPassword().sendKeys(password);

    }

    public void clickBtnLogin(){
        WebElementManager.clickToElement(getBtnLogin());
    }

    public void login(String userName, String password){
        FillData(userName, password);
        clickBtnLogin();
    }

    public String getNameAccount(String account){
        return getLblAccountName(account).getText();
    }
}
