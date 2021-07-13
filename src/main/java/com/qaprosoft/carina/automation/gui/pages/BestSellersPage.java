package com.qaprosoft.carina.automation.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BestSellersPage extends BasePage{

    @FindBy(xpath = "//h5[@itemprop='name']/a[@class='product-name']")
    private List<ExtendedWebElement> productsList;


    public BestSellersPage(WebDriver driver) {
        super(driver);
        setPageURL("?controller=best-sales");
    }

    public ProductPage getRandomProduct(int random) {
        productsList.get(random).click();
        return new ProductPage(driver);
    }

    public int setProductsSize(){
        return productsList.size();
    }
}
