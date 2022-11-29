package org.logigear.pageObjects.dashBoardTA;

import org.logigear.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {
    private By ddlGlobalSetting = By.xpath("//li[contains(@class,'mn-setting')]");
    private By ddlAddPage = By.xpath("//a[contains(text(),'Add Page')]");

    private WebElement getDdlGlobalSetting(){return Constant.WEBDRIVER.findElement(ddlGlobalSetting);}
    private WebElement getDdlAddPage(){return Constant.WEBDRIVER.findElement(ddlAddPage);}


}
