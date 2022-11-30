package org.logigear.pageObjects.dashBoardTA;

import org.logigear.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage {
    private By ddlGlobalSetting = By.xpath("//li[contains(@class,'mn-setting')]");
    private WebElement getDdlGlobalSetting(){return Constant.WEBDRIVER.findElement(ddlGlobalSetting);}


}
