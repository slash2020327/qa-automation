package com.qaprosoft.carina.automation.gui.components;

import com.qaprosoft.carina.automation.gui.pages.AccountPage;
import com.qaprosoft.carina.automation.gui.pages.AuthenticationPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginMenu extends AbstractUIObject {

    @FindBy(xpath = "//input[@id='email']")
    private ExtendedWebElement emailAddress;

    @FindBy(xpath = "//input[@id='passwd']")
    private ExtendedWebElement password;

    @FindBy(xpath = "//*[@id='SubmitLogin']")
    private ExtendedWebElement signing;

    public LoginMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public AuthenticationPage inputEmail(String email) {
        emailAddress.type(email);
        return new AuthenticationPage(driver);
    }

    public AuthenticationPage inputPassword(String pass) {
        password.type(pass);
        return new AuthenticationPage(driver);
    }

    public AccountPage clickSignInButton() {
        signing.click();
        return new AccountPage(driver);
    }


}
