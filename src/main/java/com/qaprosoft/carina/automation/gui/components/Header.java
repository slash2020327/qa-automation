package com.qaprosoft.carina.automation.gui.components;

import com.qaprosoft.carina.automation.domain.Clothes;
import com.qaprosoft.carina.automation.gui.pages.AuthenticationPage;
import com.qaprosoft.carina.automation.gui.pages.GridPage;
import com.qaprosoft.carina.automation.gui.pages.SearchPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class Header extends AbstractUIObject {

    @FindBy(xpath = "//a[@class='login']")
    private ExtendedWebElement signButton;

    @FindBy(xpath = "//a[@title='Women']")
    private ExtendedWebElement womenButton;

    @FindBy(xpath = "//*[@id='block_top_menu']//*[@title='%s' and @href][last()]")
    private ExtendedWebElement categoryButton;

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a")
    private ExtendedWebElement t_shirtButton;

    @FindBy(xpath = "//button[@name='submit_search']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private ExtendedWebElement searchField;

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

    public void randomInput() {
        int leftLimit = 97; // numeral 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        searchField.type(generatedString);
    }
}
