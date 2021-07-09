package com.qaprosoft.carina.automation.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(xpath = "//div[@id='center_column']/div[@class='alert alert-danger']")
    private ExtendedWebElement alertErrorWindow;

    public AccountPage(WebDriver driver) {
        super(driver);
        setPageURL("index.php?controller=my-account");
    }

    private final static String TEXT = "Invalid email address.";



}
