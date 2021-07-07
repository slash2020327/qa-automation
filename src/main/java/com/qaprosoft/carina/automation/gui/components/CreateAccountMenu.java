package com.qaprosoft.carina.automation.gui.components;

import com.qaprosoft.carina.automation.gui.pages.AuthenticationPage;
import com.qaprosoft.carina.automation.gui.pages.PersonalInfoPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CreateAccountMenu extends AbstractUIObject {

    @FindBy(xpath = "//input[@id='email_create']")
    private ExtendedWebElement inputEmailAddress;

    @FindBy(id = "SubmitCreate")
    private ExtendedWebElement buttonToCreateAcc;

    public CreateAccountMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public AuthenticationPage inputEmail(String email ) {
        inputEmailAddress.type(email);
        return new AuthenticationPage(driver);
    }

    public PersonalInfoPage clickButtonCreateAcc() {
        buttonToCreateAcc.click();
        return new PersonalInfoPage(driver);
    }
}
