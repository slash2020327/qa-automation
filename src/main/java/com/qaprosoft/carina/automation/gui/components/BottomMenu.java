package com.qaprosoft.carina.automation.gui.components;

import com.qaprosoft.carina.automation.gui.pages.SiteMapPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BottomMenu extends AbstractUIObject {

   @FindBy(xpath = "//a[@title='Sitemap']")
   private ExtendedWebElement siteMap;

    public BottomMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SiteMapPage clickSiteMap() {
        siteMap.click();
        return new SiteMapPage(driver);
    }

}
