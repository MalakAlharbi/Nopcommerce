package testcases;

import Utilities.RandomGenerator;
import Pages.P01_HomePage;
import Pages.P02_RegisterPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TC01_Register extends TestBase {

    static  String email;
    static String password;
    String firstName;
    String lastName;
    String telephoneNumber;

    P01_HomePage homePage;
    P02_RegisterPage registerPage;

    @Test(priority = 1, description = "register with valid data ")
    public void registerWithValidData() throws InterruptedException {
        homePage=new P01_HomePage(driver);
        homePage.clickRegisterButton();
        registerPage=new P02_RegisterPage(driver);

        firstName = RandomGenerator.generateRandomFirstName();
        lastName = RandomGenerator.generateRandomLastName();
        email = RandomGenerator.generateRandomEmail();
        password= RandomGenerator.generateRandomPassword(6);
        telephoneNumber = RandomGenerator.generateRandomTelephoneNumber();

        // Log the email used for registration
        System.out.println("Registering with email: " + email);

        registerPage.registerSteps(firstName, lastName, email, telephoneNumber, password);
        String message = registerPage.getSuccessMessage();
        System.out.println(message); // Print the success message
        assertEquals(message, "Your Account Has Been Created!");
    }

    @Test(priority = 2, description = "register with invalid data ")
    public void registerWithInvalidData() throws InterruptedException {
        homePage=new P01_HomePage(driver);
        homePage.clickRegisterButton();
        registerPage=new P02_RegisterPage(driver);

        firstName = RandomGenerator.generateRandomFirstName();
        lastName = RandomGenerator.generateRandomLastName();
        email = RandomGenerator.generateInvalidEmail();
        telephoneNumber = RandomGenerator.generateInvalidTelephoneNumber();
        password = RandomGenerator.generateInvalidPassword();
        registerPage.registerSteps(firstName, lastName, email, telephoneNumber, password);
    }

}