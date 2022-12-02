package org.logigear.pageObjects.dashBoardTA;

import org.logigear.common.WebElementManager;
import org.logigear.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    String ddpNav = "//a[contains(@href, '%s')]";

    private By ddpGlobalSetting =  By.xpath("//li[contains(@class,'mn-setting')]");

    String btnOption = "//a[contains(text(), '%s')]";

    WebElement getDdpNav(String nameDropdown){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(ddpNav, nameDropdown)));
    }
    WebElement getBtnOption(String nameOption){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnOption, nameOption)));
    }
    WebElement getDdpGlobalSetting(){
        return Constant.WEBDRIVER.findElement(ddpGlobalSetting);
    }

    public void clickOption(String nameOption){
        WebElementManager.clickToElement(getBtnOption(nameOption));
    }

    public void hoverDdpNav(String nameDropdown){
        WebElementManager.hoverToElement(getDdpNav(nameDropdown));
    }
    public void hoverDdpGlobalSetting(){
        WebElementManager.hoverToElement(getDdpGlobalSetting());
    }

}
