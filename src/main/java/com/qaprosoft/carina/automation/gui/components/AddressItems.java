package com.qaprosoft.carina.automation.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddressItems extends AbstractUIObject {

    @FindBy(xpath = "./li[@class='address_firstname address_lastname']")
    private ExtendedWebElement nameAddress;

    @FindBy(xpath = "./li[@class='address_address1 address_address2']")
    private ExtendedWebElement streetAddress;

    @FindBy(xpath = "./li[@class='address_city address_state_name address_postcode']")
    private ExtendedWebElement state;

    @FindBy(xpath = "./li[@class='address_country_name']")
    private ExtendedWebElement country;

    @FindBy(xpath = "./li[@class='address_phone_mobile']")
    private ExtendedWebElement mobilePhone;

    public AddressItems(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getName() {
        return nameAddress.getText();
    }

    public String getStreet() {
        return streetAddress.getText();
    }

    public String getState() {
        return state.getText();
    }

    public String getCountry() {
        return country.getText();
    }

    public String getPhone() {
        return mobilePhone.getText();
    }

}
