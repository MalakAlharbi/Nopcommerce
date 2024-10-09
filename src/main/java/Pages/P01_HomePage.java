package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_HomePage {
    //define page factory using constructor
    //page factory is designed pattern his job is make the inserted driver is the default driver in this page
    public P01_HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    //step1: define locators
    //my account locator
    @FindBy(xpath = "//a[@title='My Account']")
    WebElement myAccountDropDown;
    //register locator
    @FindBy(xpath = "//a[text()='Register']")
    WebElement registerButton;
    //login locator
    @FindBy(xpath = "//a[text()='Login']")
    WebElement loginButton;
    @FindBy(xpath = "(//a)[7]")
    WebElement logoutButton;

    //step2: define action methods
    public void clickRegisterButton() throws InterruptedException {
        this.myAccountDropDown.click();
        Thread.sleep(4000);
        this.registerButton.click();
    }
    public void clickLoginButton(){
        this.myAccountDropDown.click();
        this.loginButton.click();
    }
    public void clickLogoutButton(){
        this.myAccountDropDown.click();
        this.logoutButton.click();
    }
}