package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P06_DeliveryDetailsPage {
    WebDriver driver;

    public P06_DeliveryDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"button-shipping-address\"]")
    WebElement shippingAddressBtn;

    public void deliveryDetails() {
        this.shippingAddressBtn.click();
    }
}