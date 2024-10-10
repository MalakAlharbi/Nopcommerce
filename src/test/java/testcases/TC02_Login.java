package testcases;

import Utilities.RandomGenerator;
import Pages.P01_HomePage;
import Pages.P03_LoginPage;
import org.testng.annotations.Test;
import static testcases.TC01_Register.email;
import static testcases.TC01_Register.password;

public class TC02_Login extends TestBase {

    //define object from page classes
    P01_HomePage homePage;
    P03_LoginPage loginPage;

    @Test(priority = 1, description = "login to the website with valid credientials")
    public void validateLoginWithValidEmailAndPassword() throws InterruptedException {
        homePage=new P01_HomePage(driver);
        homePage.clickLoginButton();
        loginPage=new P03_LoginPage(driver);

        // Log the email used for registration
        System.out.println("login with email: " + email);
        loginPage.login(email, password);
        Thread.sleep(5000);

        // use soft assertion
        softAssert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=account/account");
        softAssert.assertTrue(loginPage.loginSuccessfully());
        softAssert.assertAll();
    }

    @Test(priority = 2, description = "login to website with randomly invalid credentials")
    public void validateLoginWithInvalidEmailAndPassword() throws InterruptedException {
        homePage=new P01_HomePage(driver);
        homePage.clickLoginButton();
        loginPage=new P03_LoginPage(driver);
        // Generate random invalid email and password
        String email = RandomGenerator.generateInvalidEmail();
        String password = RandomGenerator.generateInvalidPassword();
        // Login steps
        loginPage.login(email, password);
    }

    @Test(priority = 3, description = "login to website with invalid email and valid password")
    public void validateLoginWithInvalidEmailAndValidPassword() throws InterruptedException {
        homePage=new P01_HomePage(driver);
        homePage.clickLoginButton();
        loginPage=new P03_LoginPage(driver);
        // Generate random invalid email
        String email = RandomGenerator.generateInvalidEmail();
        String password = RandomGenerator.generateRandomPassword(8); // or any valid length
        // Login steps
        loginPage.login(email, password);
    }

    @Test(priority = 4, description = "login to website with valid email and invalid password")
    public void validateLoginWithValidEmailAndInvalidPassword() throws InterruptedException {
        homePage=new P01_HomePage(driver);
        homePage.clickLoginButton();
        loginPage=new P03_LoginPage(driver);
        // Generate random valid email and invalid password
        String email = RandomGenerator.generateRandomEmail();
        String password = RandomGenerator.generateInvalidPassword();
        // Login steps
        loginPage.login(email, password);
    }
}