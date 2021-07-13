package com.qaprosoft.carina.automation.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SiteMapBox extends AbstractUIObject {

    @FindBy(xpath = "//a[@title='Authentication']")
    private ExtendedWebElement authentication;

    @FindBy(xpath = "//a[@title='Create new account']")
    private ExtendedWebElement createAccount;

    @FindBy(xpath = "//a[@title='Manage your customer account']")
    private ExtendedWebElement tagYourAcc;

    @FindBy(xpath = "//a[@title='Manage your personal information']")
    private ExtendedWebElement tagPersonalInf;

    @FindBy(xpath = "//a[@title='View a list of my addresses']")
    private ExtendedWebElement tagAddresses;

    @FindBy(xpath = "//*[contains(text(),'Order history')]")
    private ExtendedWebElement tagHistory;

    @FindBy(xpath = "//div[@class='sitemap_block box']//a[@title='Sign out']")
    private ExtendedWebElement buttonOut;

    public SiteMapBox(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isAccInformationPresent(){
        authentication.isElementPresent();
        createAccount.isElementPresent();
        return true;
    }

    public boolean isPersonalInfPresent(){
        tagAddresses.isElementPresent();
        tagHistory.isElementPresent();
        tagPersonalInf.isElementPresent();
        tagHistory.isElementPresent();
        buttonOut.isElementPresent();
        return true;
    }

    public void clickSignOut() {
        buttonOut.click();
    }
}
