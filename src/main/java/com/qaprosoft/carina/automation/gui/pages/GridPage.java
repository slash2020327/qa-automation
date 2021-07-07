package com.qaprosoft.carina.automation.gui.pages;

import com.qaprosoft.carina.automation.gui.components.CatalogFilterItem;
import com.qaprosoft.carina.automation.gui.components.ProductItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class GridPage extends BasePage {

    @FindBy(xpath = "//div[@id='left_column']")
    private CatalogFilterItem catalogItem;

    @FindBy(xpath = "//div[@class='product-container']")
    private List<ProductItem> productItems;

    public GridPage(WebDriver driver) {
        super(driver);
        setPageURL("index.php?id_category=3&controller=category");
    }

    public ProductPage openRandomProduct() {
        Random random = new Random();
        int randomItem = random.nextInt(getProductItems().size());
        getProductItems().get(randomItem).clickLink();
        return new ProductPage(driver);
    }

    public List<ProductItem> getProductItems() {
        return productItems;
    }

    @Override
    public boolean isPageOpened() {
        return catalogItem.isUIObjectPresent();
    }

}
