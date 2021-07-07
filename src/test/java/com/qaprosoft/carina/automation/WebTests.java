package com.qaprosoft.carina.automation;

import com.qaprosoft.carina.automation.domain.Clothes;
import com.qaprosoft.carina.automation.gui.components.CreateAccountMenu;
import com.qaprosoft.carina.automation.gui.components.LoginMenu;
import com.qaprosoft.carina.automation.gui.pages.*;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WebTests implements IAbstractTest {

    @Test
    public void signInTest() {
        AuthenticationPage page = new AuthenticationPage(getDriver());
        page.open();
        Assert.assertTrue(page.isPageOpened(), "Page isn't opened");

        page.getHeader().clickOnSignInButton();
        LoginMenu menu = page.getLoginMenu();
        menu.inputEmail(R.TESTDATA.get("email"));
        menu.inputPassword(R.TESTDATA.get("pass"));
        AccountPage accountPage = menu.clickSignInButton();
        Assert.assertTrue(accountPage.isPageOpened(), "Account page is not opened");

    }

    @Test
    public void creationAccTest() {
        AuthenticationPage page = new AuthenticationPage(getDriver());
        page.open();
        Assert.assertTrue(page.isPageOpened(), "Main page isn't opened");

        CreateAccountMenu accountMenu = page.getNewAccountMenu();
        accountMenu.inputEmailAdd();

        PersonalInfoPage infoPage = accountMenu.clickButtonCreateAcc();
        Assert.assertTrue(infoPage.isPageOpened(), " Personal information input page isn't opened");

        PersonalInfoPage registrationPage = new PersonalInfoPage(getDriver());
        registrationPage.getAccountForm().inputOfAllData(R.TESTDATA.get("firstName"),
                R.TESTDATA.get("lastName"),
                R.TESTDATA.get("pass"),
                R.TESTDATA.get("city"),
                R.TESTDATA.get("street"),
                R.TESTDATA.get("zip"),
                R.TESTDATA.get("phone"));

        AccountPage accountPage = registrationPage.getAccountForm().clickRegisterButton();
        Assert.assertTrue(accountPage.isPageOpened(), "Account page is not opened");

    }

    @Test
    public void purchaseTest() {
        AuthenticationPage page = new AuthenticationPage(getDriver());
        page.open();
        Assert.assertTrue(page.isPageOpened(), "Page isn't opened");

        page.getHeader().clickOnSignInButton();
        LoginMenu menu = page.getLoginMenu();
        menu.inputEmail(R.TESTDATA.get("email"));
        menu.inputPassword(R.TESTDATA.get("pass"));
        AccountPage accountPage = menu.clickSignInButton();
        Assert.assertTrue(accountPage.isPageOpened(), "Account page isn't opened");

        accountPage.getHeader().clickOnClothesTag(Clothes.WOMEN);
        GridPage gridPage = new GridPage(getDriver());
        Assert.assertTrue(gridPage.isPageOpened(), "Product page isn't opened");
        ProductPage productPage = gridPage.openRandomProduct();

        productPage.chooseOfClothesParameters(2);
        OrderPage orderPage = productPage.getCheckoutMenu().clickToCheckout();
        Assert.assertTrue(orderPage.isPageOpened(), "Order page isn't opened");

        orderPage.getOrderMenu().clickCheckoutButton();
        orderPage.getOrderMenu().clickCheckoutAddress();
        orderPage.getOrderMenu().clickTermsOfServiceAndCheckoutButton();
        orderPage.getOrderMenu().clickPaymentButton();
        orderPage.getOrderMenu().clickConfirmOrder();
        Assert.assertEquals(orderPage.getFinalMessage(), "Your order on My Store is complete.");

    }

    @Test
    public void availabilityElementsTest() throws NoSuchFieldException {
        AuthenticationPage page = new AuthenticationPage(getDriver());
        page.open();
        Assert.assertTrue(page.isPageOpened(), "Page isn't opened");

        page.getHeader().inputSearchField("Dress");
        SearchPage searchPage = page.getHeader().clickSearchButton();
        Assert.assertTrue(page.isPageOpened(),"Search page isn't opened");
        searchPage.checkAvailabilityProductItems();

    }

    @Test
    public void negativeAvailabilityElementTest() {
        AuthenticationPage page = new AuthenticationPage(getDriver());
        page.open();
        Assert.assertTrue(page.isPageOpened(), "Page isn't opened");

        page.getHeader().randomInput();
        SearchPage searchPage = page.getHeader().clickSearchButton();
        Assert.assertTrue(page.isPageOpened(),"Search page isn't opened");
        searchPage.getAlertWindow();
    }

    @Test
    public void availabilityToClearBin() {
        AuthenticationPage page = new AuthenticationPage(getDriver());
        page.open();
        Assert.assertTrue(page.isPageOpened(), "Page isn't opened");

        page.getHeader().clickOnClothesTag(Clothes.WOMEN);
        GridPage gridPage = new GridPage(getDriver());
        Assert.assertTrue(gridPage.isPageOpened(), "Product page isn't opened");
        ProductPage productPage = gridPage.openRandomProduct();

        productPage.chooseOfClothesParameters(1);
        OrderPage orderPage = productPage.getCheckoutMenu().clickToCheckout();
        Assert.assertTrue(orderPage.isPageOpened(), "Order page isn't opened");
        orderPage.getOrderMenu().clickIconTrash();
        orderPage.getOrderMenu().getAlertWindow();
        Assert.assertEquals(orderPage.getEmptinessMessageBox(),"Your shopping cart is empty.");


    }
}
