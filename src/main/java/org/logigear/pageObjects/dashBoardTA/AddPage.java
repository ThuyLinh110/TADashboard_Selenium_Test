package org.logigear.pageObjects.dashBoardTA;

import org.logigear.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddPage extends MainPage {

    private By ddlAddPage = By.xpath("//a[contains(text(),'Add Page')]");
    private By txtPageName = By.xpath("//td//input[@id='name']");
    private By ddlParentPage = By.xpath("//td//select[@id='parent']");
    private By ddlNumberOfColum = By.xpath("//td//select[@id='columnnumber']");
    private By ddlDisplayAfter = By.xpath("//td//select[@id='afterpage']");
    private By chkPublic = By.xpath("//td//input[@id='ispublic']");
    private String btnInForm = "//td//input[@id='%s']";
    
    private WebElement getDdlAddPage() {
        return Constant.WEBDRIVER.findElement(ddlAddPage);
    }

    private WebElement getTxtPageName() {
        return Constant.WEBDRIVER.findElement(txtPageName);
    }

    private WebElement getDdlParentPage() {
        return Constant.WEBDRIVER.findElement(ddlParentPage);
    }

    private WebElement getDdlNumberOfColum() {
        return Constant.WEBDRIVER.findElement(ddlNumberOfColum);
    }

    private WebElement getDdlDisplayAfter() {
        return Constant.WEBDRIVER.findElement(ddlDisplayAfter);
    }

    private WebElement getChkPublic() {
        return Constant.WEBDRIVER.findElement(chkPublic);
    }
    WebElement getBtnOptionInForm(String btnOption){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnInForm, btnOption)));
    }
    public void fillDataAddPage(String pageName, String parentPage, String numberOfColum, String displayAfter) {
        Select sltParentPage = new Select(getDdlParentPage());
        Select sltNumberOfColum = new Select(getDdlNumberOfColum());
        Select sltDisplayAfter = new Select(getDdlDisplayAfter());
        getTxtPageName().sendKeys(pageName);
        sltParentPage.deselectByVisibleText(parentPage);
        sltNumberOfColum.selectByVisibleText(numberOfColum);
        sltDisplayAfter.selectByVisibleText(displayAfter);
    }

    public void checkPublic() {
        Boolean isSelected = getChkPublic().isSelected();
        if (isSelected == false) {
            getChkPublic().click();
        }
    }

    public void clickBtnInForm(String btnOption) {
        getBtnOptionInForm(btnOption).click();
    }

}
