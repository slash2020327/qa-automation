package com.qaprosoft.carina.automation.gui.components;

import com.qaprosoft.carina.automation.gui.pages.AccountPage;
import com.qaprosoft.carina.automation.gui.pages.PersonalInfoPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PersonalDataMenu extends AbstractUIObject {

    @FindBy(xpath = "//input[@id='customer_firstname']")
    private ExtendedWebElement firstName;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    private ExtendedWebElement lastName;

    @FindBy(xpath = "//input[@id='passwd']")
    private ExtendedWebElement passwd;

    @FindBy(xpath = "//input[@id='address1']")
    private ExtendedWebElement street;

    @FindBy(xpath = "//input[@id='city']")
    private ExtendedWebElement city;

    @FindBy(xpath = "//select[@id='id_state']//option[@value=1]")
    private ExtendedWebElement state;

    @FindBy(xpath = "//input[@id='postcode']")
    private ExtendedWebElement zipcode;

    @FindBy(xpath = "//select[@name='id_country']/option[@value=21]")
    private ExtendedWebElement country;

    @FindBy(xpath = "//input[@name='phone_mobile']")
    private ExtendedWebElement mobilePhone;

    @FindBy(xpath = "//div[@id='center_column']")
    private ExtendedWebElement centerColumn;

    @FindBy(xpath = "//button[@name='submit_search']")
    private ExtendedWebElement buttonSubmit;

    public PersonalDataMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public PersonalInfoPage inputOfAllData(String name, String lastname, String pass, String city1, String street1, String zip, String phone) {
        firstName.type(name);
        lastName.type(lastname);
        passwd.type(pass);
        city.type(city1);
        street.type(street1);
        state.click();
        zipcode.type(zip);
        country.click();
        mobilePhone.type(phone);
        return new PersonalInfoPage(driver);
    }

    public AccountPage clickRegisterButton() {
        buttonSubmit.click();
        return new AccountPage(driver);
    }

}
