package com.qaprosoft.carina.automation.gui.pages;

import com.qaprosoft.carina.automation.gui.components.GoToCheckoutPopUp;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[@id='layer_cart']")
    private GoToCheckoutPopUp itemAddedToCard;

    @FindBy(xpath = "//*[@id='quantity_wanted']")
    private ExtendedWebElement quantity;

    @FindBy(xpath = "//*[@id='group_1']/option[@title='M']")
    private ExtendedWebElement size;

    @FindBy(xpath = "//ul[@id='color_to_pick_list']/li")
    private List<ExtendedWebElement> colorList;

    @FindBy(xpath = "//button[@name='Submit']")
    private ExtendedWebElement clickToCheckout;


    public ProductPage(WebDriver driver) {
        super(driver);
    }


    public GoToCheckoutPopUp getCheckoutMenu() {
        return itemAddedToCard;
    }

    public GoToCheckoutPopUp chooseOfClothesParameters(int quantityOfClothes) {
        Random random = new Random();
        int randomItem = random.nextInt(colorList.size());
        quantity.type(String.valueOf(quantityOfClothes));
        size.click();
        colorList.get(randomItem).click();
        clickToCheckout.click();
        return itemAddedToCard;
    }
}
