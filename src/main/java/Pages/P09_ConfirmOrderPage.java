package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P09_ConfirmOrderPage {
    WebDriver driver;

    public P09_ConfirmOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"button-confirm\"]")
    WebElement confirmOrderBtn;
    @FindBy(xpath = "(//h1)")
    WebElement successMsg;

    public void confirmOrder() throws InterruptedException {
        Thread.sleep(3000);
        this.confirmOrderBtn.click();
    }

    public String getSuccessMessage() throws InterruptedException {
        Thread.sleep(5000);
        return successMsg.getText();
    }
}