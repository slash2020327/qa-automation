package com.qaprosoft.carina.automation.gui.pages;

import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
        setPageURL("index.php?controller=my-account");
    }
}
