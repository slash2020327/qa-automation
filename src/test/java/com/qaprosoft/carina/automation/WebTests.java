package com.qaprosoft.carina.automation;

import com.qaprosoft.carina.automation.domain.Clothes;
import com.qaprosoft.carina.automation.gui.components.CreateAccountMenu;
import com.qaprosoft.carina.automation.gui.components.LoginMenu;
import com.qaprosoft.carina.automation.gui.pages.*;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;


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
        Random random = new Random();
        int randomGenerator = random.nextInt(100);
        accountMenu.inputEmail(String.valueOf(randomGenerator) + R.TESTDATA.get("email"));

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

        Random random = new Random();
        int randomize = random.nextInt(10);
        productPage.inputQuantityOfProduct(randomize);
        productPage.selectRandomSize();
        productPage.selectRandomColor();
        productPage.clickCheckoutButton();
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
    public void availabilityElementsTest() {
        AuthenticationPage page = new AuthenticationPage(getDriver());
        page.open();
        Assert.assertTrue(page.isPageOpened(), "Page isn't opened");

        page.getHeader().inputSearchField("Dress");
        SearchPage searchPage = page.getHeader().clickSearchButton();
        Assert.assertTrue(page.isPageOpened(), "Search page isn't opened");
        Assert.assertTrue(searchPage.getProductAmount() > 0);

    }

    @Test
    public void negativeAvailabilityElementTest() {
        AuthenticationPage page = new AuthenticationPage(getDriver());
        page.open();
        Assert.assertTrue(page.isPageOpened(), "Page isn't opened");

        Random random = new Random();
        int randomize = random.nextInt(100);
        page.getHeader().inputSearchField(String.valueOf(randomize));
        SearchPage searchPage = page.getHeader().clickSearchButton();
        Assert.assertTrue(page.isPageOpened(), "Search page isn't opened");
        searchPage.validateSearchAlertWindow();
        Assert.assertEquals(searchPage.getProductAmount(), 0, "Product list isn't empty");

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

        Random random = new Random();
        int randomize = random.nextInt(10);
        productPage.inputQuantityOfProduct(randomize);
        productPage.selectRandomSize();
        productPage.selectRandomColor();
        productPage.clickCheckoutButton();
        OrderPage orderPage = productPage.getCheckoutMenu().clickToCheckout();
        Assert.assertTrue(orderPage.isPageOpened(), "Order page isn't opened");
        orderPage.getOrderMenu().clickIconTrash();
        Assert.assertTrue(orderPage.isTextPresent("Your shopping cart is empty."));

    }

    @DataProvider(name = "loginTest")
    public Object [][] dataProviderMethod(){
        return new Object[][]{{"#abc@","23"},{"$ooo@by.com","$ds"},{"misdadas@by.com","@@@"}};
    }

    @Test(dataProvider = "loginTest")
    public void negativeLoginTest(String login, String pass){
        AuthenticationPage page = new AuthenticationPage(getDriver());
        page.open();
        Assert.assertTrue(page.isPageOpened(), "Page isn't opened");

        page.getHeader().clickOnSignInButton();
        LoginMenu menu = page.getLoginMenu();
        menu.inputEmail(login);
        menu.inputPassword(pass);
        Assert.assertTrue(page.isInputDataValid(login,pass),"Negative input isn't correct");

    }

}
