package com.qaprosoft.carina.automation.gui.pages;

import com.qaprosoft.carina.automation.gui.components.OrderMenu;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BasePage{

    @FindBy(xpath = "//p[@class='cheque-indent']/strong")
    private ExtendedWebElement finalMessage;

    @FindBy(xpath = "//div[@id='center_column']")
    private OrderMenu orderMenu;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private ExtendedWebElement message;

    public OrderPage(WebDriver driver) {
        super(driver);
        setPageURL("index.php?controller=order");
    }

    public OrderMenu getOrderMenu(){
        return orderMenu;
    }

    public String getFinalMessage() {
        return finalMessage.getText();
    }

    public String getEmptinessMessageBox() {
        return message.getText();
    }

}
