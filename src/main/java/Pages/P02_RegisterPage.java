package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static Utilities.RandomGenerator.generateRandomInt;

public class P02_RegisterPage {

    WebDriver driver;
    public P02_RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        //we want object from the driver to call it for the find element not for FindBy
        this.driver = driver;
    }

    //step1: define locators
    @FindBy(xpath = "(//input)[5]")
    WebElement firstName;
    @FindBy(xpath = "(//input)[6]")
    WebElement lastName;
    @FindBy(xpath = "//*[@name='email']")
    WebElement email;
    @FindBy(xpath = "(//input)[9]")
    WebElement password;
    @FindBy(xpath = "(//input)[10]")
    WebElement confirmPassword;
    @FindBy(xpath = "//*[@id=\"input-telephone\"]")
    WebElement phoneNumber;
    @FindBy(xpath = "(//input)[13]")
    WebElement agreeCheckBox;
    @FindBy(xpath = "(//input)[14]")
    WebElement submitButton;
    @FindBy(xpath = "(//h1)")
    WebElement successMsg;

    public void registerSteps(String firstName, String lastName, String email, String telephoneNumber, String password) throws InterruptedException {
        Thread.sleep(4000);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.phoneNumber.sendKeys(telephoneNumber);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(password);
        //random select newsletter
        String newsLetterxpath = "(//input)[" + generateRandomInt() + "]";
        driver.findElement(By.xpath(newsLetterxpath)).click();
        this.agreeCheckBox.click();
        Thread.sleep(4000);
        this.submitButton.click();
    }

    public String getSuccessMessage() throws InterruptedException {
        Thread.sleep(4000);
        return successMsg.getText();
    }
}