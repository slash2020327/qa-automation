package com.qaprosoft.carina.automation.gui.components;

import com.qaprosoft.carina.automation.gui.pages.BestSellersPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WishList extends AbstractUIObject {

    @FindBy(css = "i.icon-remove")
    private ExtendedWebElement iconRemove;

    @FindBy(xpath = "//div[@id='block-history']")
    private ExtendedWebElement historyWishList;

    @FindBy(xpath = "//span[text()='All best sellers']")
    private ExtendedWebElement clickAllBestSellers;

    @FindBy(xpath = "//input[@class='inputTxt form-control']")
    private ExtendedWebElement nameField;

    @FindBy(xpath = "//button[@name='submitWishlist']")
    private ExtendedWebElement buttonSave;

    @FindBy(xpath = "//td[@class='bold align_center']")
    private ExtendedWebElement quantityOfCheckList;


    public WishList(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void scriptContent()  {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("document.querySelector('i.icon-remove',':before').click();");
        driver.switchTo().alert().accept();
    }


    public boolean getHistoryWishList(){
        return historyWishList.isElementPresent();
    }

    public BestSellersPage clickBestSellers(){
        clickAllBestSellers.click();
        return new BestSellersPage(driver);
    }

    public void inputNameWishList(String name){
        nameField.type(name);
    }

    public void clickSaveButton(){
        buttonSave.click();
    }

    public String getWishListProducts() {
        return quantityOfCheckList.getText();
    }


}
