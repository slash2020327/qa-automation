package com.qaprosoft.carina.automation.gui.components;

import com.qaprosoft.carina.automation.gui.pages.OrderPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OrderMenu extends AbstractUIObject {

    @FindBy(xpath = "//*[@id='center_column']/p[2]/a[1]")
    private ExtendedWebElement clickButtonCheckout;

    @FindBy(xpath = "//button[@name='processAddress']")
    private ExtendedWebElement clickButtonAddress;

    @FindBy(xpath = "//input[@type='checkbox']")
    private ExtendedWebElement termsOfService;

    @FindBy(xpath = "//button[@name='processCarrier']")
    private ExtendedWebElement clickCheckoutService;

    @FindBy(xpath = "//a[@title='Pay by bank wire']")
    private ExtendedWebElement paymentButton;

    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
    private ExtendedWebElement cofirmationOrderButton;

    @FindBy(xpath = "//i[@class='icon-trash']")
    private ExtendedWebElement iconTrash;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private ExtendedWebElement alertWindow;

    public OrderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public OrderPage clickCheckoutButton() {
        clickButtonCheckout.click();
        return new OrderPage(driver);
    }

    public OrderPage clickCheckoutAddress() {
        clickButtonAddress.click();
        return new OrderPage(driver);
    }

    public OrderPage clickTermsOfServiceAndCheckoutButton() {
        termsOfService.click();
        clickCheckoutService.click();
        return new OrderPage(driver);
    }

    public OrderPage clickPaymentButton() {
        paymentButton.click();
        return new OrderPage(driver);
    }

    public OrderPage clickConfirmOrder() {
        cofirmationOrderButton.click();
        return new OrderPage(driver);
    }

    public OrderPage clickIconTrash() {
        iconTrash.click();
        return new OrderPage(driver);
    }

    public void getAlertWindow() {
        assertElementPresent(alertWindow);
    }

}
