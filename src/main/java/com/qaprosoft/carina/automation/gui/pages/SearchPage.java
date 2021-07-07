package com.qaprosoft.carina.automation.gui.pages;

import com.qaprosoft.carina.automation.gui.components.ProductItem;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//div[@class='product-container']")
    private List<ProductItem> productItems;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private ExtendedWebElement alertWindow;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<ProductItem> checkAvailabilityProductItems() throws NoSuchFieldException {
        if (productItems.size() >= 1) {
            return productItems;
        } else {
            throw new NoSuchFieldException();
        }
    }

    public void getAlertWindow() {
        assertElementPresent(alertWindow);
    }


}
