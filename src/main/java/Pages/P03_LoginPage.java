package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P03_LoginPage {

    WebDriver driver;

    public P03_LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    //step1: define locators
    @FindBy(id = "input-email")
    WebElement email;
    @FindBy(id = "input-password")
    WebElement password;
    @FindBy(css = "[type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "(//a)[52]")
    WebElement forgottenPasswordButton;
    @FindBy(xpath = "//*[@value='Continue']")
    WebElement continueButton;
    @FindBy(xpath = "(//div)[25]")
    WebElement successAlert;

    public void login(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.loginButton.click();
    }

    public void resetPassword(String email) throws InterruptedException {
        Thread.sleep(3000);
        this.forgottenPasswordButton.click();
        this.email.sendKeys(email);
        Thread.sleep(3000);
        this.continueButton.click();

    }
    public String getSuccessAlert() {
        return successAlert.getText();
    }

    public boolean loginSuccessfully(){
        return driver.findElement(By.xpath("(//h2)[1]")).getText().equals("My Account");
    }
}