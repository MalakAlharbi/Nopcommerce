package testcases;

import Pages.P01_HomePage;
import Pages.P03_LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static testcases.TC01_Register.email;

public class TC03_ResetPassword extends TestBase{
    P01_HomePage homePage;
    P03_LoginPage loginPage;

    @Test (priority = 1, description = "validate reset new password")
    public void validateResetPasswordForExistEmail() throws InterruptedException {
        homePage=new P01_HomePage(driver);
        homePage.clickLoginButton();
        loginPage=new P03_LoginPage(driver);
        System.out.println("Resetting password for email: " + email);
        loginPage.resetPassword(email);
        String message = loginPage.getSuccessAlert();
        System.out.println(message); // Print the success message
        Assert.assertEquals(message, "An email with a confirmation link has been sent your email address.");
    }
}