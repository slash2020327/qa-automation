package com.qaprosoft.carina.automation.gui.pages;

import com.qaprosoft.carina.automation.gui.components.AddressItems;
import com.qaprosoft.carina.automation.gui.components.OrderMenu;
import com.qaprosoft.carina.automation.models.UserAddress;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Comparator;

public class OrderPage extends BasePage {

    @FindBy(xpath = "//p[@class='cheque-indent']/strong")
    private ExtendedWebElement finalMessage;

    @FindBy(xpath = "//div[@id='center_column']")
    private OrderMenu orderMenu;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private ExtendedWebElement message;

    @FindBy(xpath = "//ul[@id='address_delivery']")
    private AddressItems deliveryAddress;

    @FindBy(xpath = "//ul[@id='address_invoice']")
    private AddressItems billingAddress;


    public OrderPage(WebDriver driver) {
        super(driver);
        setPageURL("index.php?controller=order");
    }

    public OrderMenu getOrderMenu() {
        return orderMenu;
    }


    public UserAddress getBillAddress() {
        UserAddress BillAddress = new UserAddress();
        BillAddress.setFullName(billingAddress.readName());
        BillAddress.setCountry(billingAddress.readCountry());
        BillAddress.setState(billingAddress.readState());
        BillAddress.setStreet(billingAddress.readStreet());
        BillAddress.setNumber(billingAddress.readPhone());

        return BillAddress;
    }

    public UserAddress getDeliveryAddress() {
        UserAddress DeliveryAddress = new UserAddress();
        DeliveryAddress.setFullName(deliveryAddress.readName());
        DeliveryAddress.setCountry(deliveryAddress.readCountry());
        DeliveryAddress.setState(deliveryAddress.readState());
        DeliveryAddress.setStreet(deliveryAddress.readStreet());
        DeliveryAddress.setNumber(deliveryAddress.readPhone());

        return DeliveryAddress;
    }

    public int compareTo() {
        return Comparator.comparing(UserAddress::getFullName)
                .thenComparing(UserAddress::getStreet)
                .thenComparing(UserAddress::getCountry)
                .thenComparing(UserAddress::getNumber)
                .thenComparing(UserAddress::getState)
                .compare(getDeliveryAddress(), getBillAddress());
    }


}
