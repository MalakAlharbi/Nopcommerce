package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P05_BillingDetailsPage {

    WebDriver driver;

    public P05_BillingDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@class=\"btn btn-primary\"]")
    WebElement checkOutBtn;
    @FindBy(xpath = "(//input)[4]")
    WebElement firstName;
    @FindBy(xpath = "(//input)[5]")
    WebElement lastName;
    @FindBy(xpath = "(//input)[7]")
    WebElement address;
    @FindBy(xpath = "(//input)[9]")
    WebElement city;
    @FindBy(xpath = "(//input)[10]")
    WebElement postCode;
    @FindBy(xpath = "//select[@id=\"input-payment-zone\"]")
    WebElement regionDropList;
    @FindBy(xpath = "//option[@value=\"3516\"]")
    WebElement selectRegion;
    @FindBy(xpath = "//*[@id=\"button-payment-address\"]")
    WebElement continueBtn;

    public boolean checkOutPage() {
        return driver.findElement(By.xpath("(//h1)")).getText().equals("Checkout");
    }

    public void billingDetails(String firstName, String lastName, String address, String city, String postCode) throws InterruptedException {
        Thread.sleep(5000);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.address.sendKeys(address);
        this.city.sendKeys(city);
        this.postCode.sendKeys(postCode);
        Thread.sleep(2000);
        this.regionDropList.click();
        this.selectRegion.click();
        this.continueBtn.click();
        this.continueBtn.click();
    }

    public void checkOutButton(){
        this.checkOutBtn.click();
    }
}