package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P07_DeliveryMethodPage {
    WebDriver driver;

    public P07_DeliveryMethodPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"button-shipping-method\"]")
    WebElement shippingMethodBtn;

    public void deliveryMethod() throws InterruptedException {
        Thread.sleep(4000);
        this.shippingMethodBtn.click();
    }
}