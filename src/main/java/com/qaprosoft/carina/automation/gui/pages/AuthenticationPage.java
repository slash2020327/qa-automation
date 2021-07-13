package com.qaprosoft.carina.automation.gui.pages;

import com.qaprosoft.carina.automation.gui.components.BottomMenu;
import com.qaprosoft.carina.automation.gui.components.CreateAccountMenu;
import com.qaprosoft.carina.automation.gui.components.LoginMenu;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AuthenticationPage extends BasePage {

    @FindBy(xpath = "//div[@class='footer-container']")
    private BottomMenu bottomMenu;

    @FindBy(xpath = "//form[@id='login_form']")
    private LoginMenu loginForm;

    @FindBy(xpath = "//form[@id='create-account_form']")
    private CreateAccountMenu accountForm;

    @FindBy(xpath = "//div[@id='center_column']/div[@class='alert alert-danger']")
    private ExtendedWebElement alertErrorWindow;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
        setPageURL("index.php?controller=authentication&back=my-account");
    }

    public LoginMenu getLoginMenu() {
        return loginForm;
    }

    public CreateAccountMenu getNewAccountMenu() {
        return accountForm;
    }

    public BottomMenu getBottomMenu(){
        return bottomMenu;
    }

    public static final String TEXT = "Invalid email address.";

    public void validateErrorAlertWindow() {
        Assert.assertTrue(isAlertPresent(),"Error alert window is not present");
        Assert.assertTrue(getAlertText().contains(TEXT),"Text in error alert window isn't the same");
    }

    public boolean isAlertPresent() {
        return alertErrorWindow.isElementPresent();
    }

    public String getAlertText() {
        return alertErrorWindow.getText();
    }

}
