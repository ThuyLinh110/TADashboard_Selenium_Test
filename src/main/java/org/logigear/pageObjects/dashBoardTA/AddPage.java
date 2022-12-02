package org.logigear.pageObjects.dashBoardTA;

import org.logigear.common.WebElementManager;
import org.logigear.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddPage extends GeneralPage {

    private By ddlAddPage = By.xpath("//a[contains(text(),'Add Page')]");
    private By txtPageName = By.xpath("//td/input[@id='name']");
    private  String ddlData ="//td[contains(text(),'%s')]/..//select";
    private By chkPublic = By.xpath("//td/input[@id='ispublic']");
    private String btnInForm = "//td//input[@id='%s']";
    private By btnScrollToTop = By.id("toTop");
    
    private WebElement getDdlAddPage() {
        return Constant.WEBDRIVER.findElement(ddlAddPage);
    }

    private WebElement getTxtPageName() {
        return Constant.WEBDRIVER.findElement(txtPageName);
    }

    private WebElement getDdlData(String ddlName) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(ddlData,ddlName)));
    }

    private WebElement getChkPublic() {
        return Constant.WEBDRIVER.findElement(chkPublic);
    }
    WebElement getBtnOptionInForm(String btnOption){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnInForm, btnOption)));
    }
    public WebElement getBtnScrollToTop(){return Constant.WEBDRIVER.findElement(btnScrollToTop);}

    public void fillDataAddPage(String pageName, String parentPage, String numberOfColum, String displayAfter) throws InterruptedException {
        WebElementManager.sleep();
        Select sltParentPage = new Select(getDdlData("Parent Page"));
        Select sltNumberOfColum = new Select(getDdlData("Number of Columns"));
        Select sltDisplayAfter = new Select(getDdlData("Display After"));
        getTxtPageName().sendKeys(pageName);
        sltParentPage.selectByVisibleText(parentPage);
        WebElementManager.sleep();
        sltNumberOfColum.selectByVisibleText(numberOfColum);
        sltDisplayAfter.selectByVisibleText(displayAfter);
    }
    public void fillDataWithTwoFields(String pageName, String parentPage){
        Select sltParentPage = new Select(getDdlData("Parent Page"));
        getTxtPageName().sendKeys(pageName);
        sltParentPage.selectByVisibleText(parentPage);
    }

    public void checkPublic() {
        Boolean isSelected = getChkPublic().isSelected();
        if (isSelected == false) {
            getChkPublic().click();
        }
    }

    public void checkAddPageIsDisplay(){
        Boolean checkAddPageDisplay = getDdlAddPage().isDisplayed();

    }

    public void clickBtnInForm(String btnOption) {
        getBtnOptionInForm(btnOption).click();
    }

}
