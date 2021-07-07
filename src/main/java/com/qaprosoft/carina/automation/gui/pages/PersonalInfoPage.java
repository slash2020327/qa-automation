package com.qaprosoft.carina.automation.gui.pages;

import com.qaprosoft.carina.automation.gui.components.PersonalDataMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PersonalInfoPage extends BasePage {

    @FindBy(xpath = "//form[@id='account-creation_form']")
    private PersonalDataMenu accountForm;


    public PersonalInfoPage(WebDriver driver) {
        super(driver);
        setPageURL("index.php?controller=authentication&back=my-account#account-creation");
    }

    public PersonalDataMenu getAccountForm() {
        return accountForm;
    }


}
