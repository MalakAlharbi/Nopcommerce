package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P08_PaymentMethodPage {
    WebDriver driver;

    public P08_PaymentMethodPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@name=\"agree\"]")
    WebElement agreeCheckBox;
    @FindBy(xpath = "//*[@id=\"button-payment-method\"]")
    WebElement paymentMethodBtn;

    public void paymentMethod() throws InterruptedException {
        Thread.sleep(4000);
        this.agreeCheckBox.click();
        this.paymentMethodBtn.click();
    }
}