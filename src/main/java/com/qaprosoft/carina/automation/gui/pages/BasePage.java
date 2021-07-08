package com.qaprosoft.carina.automation.gui.pages;

import com.qaprosoft.carina.automation.gui.components.Header;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage extends AbstractPage {

    @FindBy(xpath = "//header[@id='header']")
    private Header header;

    @FindBy(xpath = "//*[text()='%s']")
    private ExtendedWebElement anyText;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return header;
    }

    public boolean isTextPresent(String text) {
       ExtendedWebElement textElement = anyText.format(text);
       return textElement.isElementPresent();

    }

    public boolean isAlertPresent(ExtendedWebElement alert) {
        return alert.isElementPresent();
    }

    public String getAlertText(ExtendedWebElement alert) {
        return alert.getText();
    }

}
