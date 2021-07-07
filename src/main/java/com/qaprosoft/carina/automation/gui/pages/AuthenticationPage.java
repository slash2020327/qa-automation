package com.qaprosoft.carina.automation.gui.pages;

import com.qaprosoft.carina.automation.gui.components.CreateAccountMenu;
import com.qaprosoft.carina.automation.gui.components.LoginMenu;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends BasePage {

    @FindBy(xpath = "//form[@id='login_form']")
    private LoginMenu loginForm;

    @FindBy(xpath = "//form[@id='create-account_form']")
    private CreateAccountMenu accountForm;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
        setPageURL("index.php?controller=authentication&back=my-account");
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    public LoginMenu getLoginMenu() {
        return loginForm;
    }

    public CreateAccountMenu getNewAccountMenu() {
        return accountForm;
    }
}
