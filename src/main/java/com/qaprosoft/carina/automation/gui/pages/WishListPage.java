package com.qaprosoft.carina.automation.gui.pages;

import com.qaprosoft.carina.automation.gui.components.WishList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage{

    @FindBy(xpath = "//div[@id='mywishlist']")
    private WishList wishList;

    public WishListPage(WebDriver driver) {
        super(driver);
        setPageURL("?fc=module&module=blockwishlist&controller=mywishlist");
    }

    public WishList getWishList(){
        return wishList;
    }

}
