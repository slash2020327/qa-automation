package com.qaprosoft.carina.automation.gui.pages;

import com.qaprosoft.carina.automation.gui.components.ProductItem;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//div[@class='product-container']")
    private List<ProductItem> productItems;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private ExtendedWebElement alertWindow;

    public SearchPage(WebDriver driver) {
        super(driver);
    }


    public int getProductAmount(){
        return productItems.size();
    }

    private final static String TEXT = "No results were found for your search";

    public void validateSearchAlertWindow() {
        Assert.assertTrue(isSearchAlertPresent(),"Search alert window is not present");
        Assert.assertTrue(getSearchAlertText().contains(TEXT),"Text in search alert isn't the same");

    }

    public boolean isSearchAlertPresent() {
        return alertWindow.isElementPresent();
    }

    public String getSearchAlertText() {
        return alertWindow.getText();
    }


}
