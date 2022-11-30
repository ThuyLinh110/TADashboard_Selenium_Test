package org.logigear.pageObjects.dashBoardTA;

import org.logigear.common.WebElementManager;
import org.logigear.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GeneralPage {
    String ddpNav = "//a[contains(@href, '$s')]";
    private By  ddpGlobalSetting = By.className("mn-setting");
    String btnOption = "//a[contains(text(), '%s')]";

    WebElement getddpNav(String nameDropdown){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(ddpNav, nameDropdown)));
    }
    WebElement getBtnOption(String nameOption){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnOption, nameOption)));
    }
    WebElement getddpGlobalSetting(){
        return Constant.WEBDRIVER.findElement(ddpGlobalSetting);
    }

    public void clickOption(String nameOption){
        WebElementManager.clickToElement(getBtnOption(nameOption));
    }

    public void hoverDdpNav(String nameDropdown){
        WebElementManager.hoverToElement(getddpNav(nameDropdown));
    }
    public void hoverDdpGlobalSetting(){
        WebElementManager.hoverToElement(getddpGlobalSetting());
    }

}
