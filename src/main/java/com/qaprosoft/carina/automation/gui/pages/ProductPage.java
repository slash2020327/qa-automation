package com.qaprosoft.carina.automation.gui.pages;

import com.qaprosoft.carina.automation.gui.components.GoToCheckoutPopUp;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ProductPage extends BasePage {

    private Random random = new Random();

    @FindBy(xpath = "//div[@id='layer_cart']")
    private GoToCheckoutPopUp itemAddedToCard;

    @FindBy(xpath = "//*[@id='quantity_wanted']")
    private ExtendedWebElement quantity;

    @FindBy(xpath = "//*[@id='group_1']/option[@title='M']")
    private ExtendedWebElement size;

    @FindBy(xpath = "//ul[@id='color_to_pick_list']/li")
    private List<ExtendedWebElement> colorList;

    @FindBy(xpath = "//select[@id='group_1']/option")
    private List<ExtendedWebElement> sizeList;

    @FindBy(xpath = "//button[@name='Submit']")
    private ExtendedWebElement clickToCheckout;


    public ProductPage(WebDriver driver) {
        super(driver);
    }


    public GoToCheckoutPopUp getCheckoutMenu() {
        return itemAddedToCard;
    }


    public void inputQuantityOfProduct(){
        int randomItem = random.nextInt(colorList.size());
        quantity.type(String.valueOf(5));
    }

    public void selectRandomSize() {
        int randomItem = random.nextInt(sizeList.size());
        sizeList.get(randomItem).click();
    }

    public void selectRandomColor() {
        int randomItem = random.nextInt(colorList.size());
        colorList.get(randomItem).click();
    }

    public GoToCheckoutPopUp clickCheckoutButton(){
        clickToCheckout.click();
        return getCheckoutMenu();
    }
}
