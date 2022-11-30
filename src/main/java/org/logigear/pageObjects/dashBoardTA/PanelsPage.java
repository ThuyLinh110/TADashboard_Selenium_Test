package org.logigear.pageObjects.dashBoardTA;

import org.logigear.common.WebElementManager;
import org.logigear.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PanelsPage extends GeneralPage {
    private By lnkAddNew = By.xpath("//a[contains(text(), 'Add New')]");
    private By lblSettingForm = By.xpath("//fieldset[@id='fdSettings']/legend");

    private String rbnType = "//label[contains(text(), '%s')]/input";
    private WebElement getLnkAddNew(){
        return Constant.WEBDRIVER.findElement(lnkAddNew);
    }
    private WebElement getLblSetting(){
        return Constant.WEBDRIVER.findElement(lblSettingForm);
    }

    private WebElement getRbnType(String type){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(rbnType, type)));
    }

    public void openAddNewPanelForm(){
        WebElementManager.clickToElement(getLnkAddNew());
    }
    public void clickRbnType(String type){
        WebElementManager.clickToElement(getRbnType(type));
    }
    public String getLabelSetting(){
        return getLblSetting().getText();
    }

}
