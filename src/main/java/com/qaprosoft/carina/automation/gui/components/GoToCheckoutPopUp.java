package com.qaprosoft.carina.automation.gui.components;

import com.qaprosoft.carina.automation.gui.pages.OrderPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GoToCheckoutPopUp extends AbstractUIObject {

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private ExtendedWebElement clickProceedCheckout;

    public GoToCheckoutPopUp(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public OrderPage clickToCheckout() {
        clickProceedCheckout.click();
        return new OrderPage(driver);
    }
}
