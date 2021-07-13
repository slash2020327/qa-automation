package com.qaprosoft.carina.automation.gui.components;

import com.qaprosoft.carina.automation.domain.Clothes;
import com.qaprosoft.carina.automation.gui.pages.AccountPage;
import com.qaprosoft.carina.automation.gui.pages.AuthenticationPage;
import com.qaprosoft.carina.automation.gui.pages.GridPage;
import com.qaprosoft.carina.automation.gui.pages.SearchPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(xpath = "//a[@class='login']")
    private ExtendedWebElement signButton;

    @FindBy(xpath = "//*[@id='block_top_menu']//*[@title='%s' and @href][last()]")
    private ExtendedWebElement categoryButton;

    @FindBy(xpath = "//button[@name='submit_search']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//a[@title='View my customer account']")
    private ExtendedWebElement customerAccount;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public AuthenticationPage clickOnSignInButton() {
        signButton.click();
        return new AuthenticationPage(driver);
    }

    public GridPage clickOnClothesTag(Clothes clothes) {
        categoryButton.format(clothes.getName()).click();
        return new GridPage(driver);
    }

    public SearchPage clickSearchButton() {
        searchButton.click();
        return new SearchPage(driver);
    }

    public void inputSearchField(String name) {
        searchField.type(name);
    }

    public AccountPage clickToCustomerAccount() {
        customerAccount.click();
        return new AccountPage(driver);
    }


}
