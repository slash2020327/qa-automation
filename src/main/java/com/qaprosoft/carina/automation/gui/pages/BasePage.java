package com.qaprosoft.carina.automation.gui.pages;

import com.qaprosoft.carina.automation.gui.components.Header;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage extends AbstractPage {

    @FindBy(xpath = "//header[@id='header']")
    private Header header;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return header;
    }

}
