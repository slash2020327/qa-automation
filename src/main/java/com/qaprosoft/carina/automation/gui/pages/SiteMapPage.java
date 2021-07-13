package com.qaprosoft.carina.automation.gui.pages;

import com.qaprosoft.carina.automation.gui.components.SiteMapBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SiteMapPage extends BasePage{

    @FindBy(xpath = "//*[contains(text(),'Your Account')]/..")
    private SiteMapBox siteBlock;


    public SiteMapPage(WebDriver driver) {
        super(driver);
        setPageURL("?controller=sitemap");
    }

    public SiteMapBox getSiteBlock() {
        return siteBlock;
    }

}
