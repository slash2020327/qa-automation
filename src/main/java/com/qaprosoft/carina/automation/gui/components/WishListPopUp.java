package com.qaprosoft.carina.automation.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WishListPopUp extends AbstractUIObject {

    @FindBy(xpath = "//a[@class='fancybox-item fancybox-close']")
    private ExtendedWebElement closeButton;

    public WishListPopUp(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickButtonClose(){
        closeButton.click();
    }

}
