package testcases;

import Utilities.RandomGenerator;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static testcases.TC01_Register.email;
import static testcases.TC01_Register.password;

public class TC08_EndToEnd extends TestBase{
    P01_HomePage homePage;
    P04_Dashboard dashboard;
    P03_LoginPage loginPage;
    P05_BillingDetailsPage checkOutPage;
    P06_DeliveryDetailsPage deliveryDetails;
    P07_DeliveryMethodPage deliveryMethod;
    P08_PaymentMethodPage paymentMethod;
    P09_ConfirmOrderPage confirmOrder;

    String firstName;
    String lastName;
    String city;
    String address;
    String postCode;

    @Test(priority = 1, description = "add different products to cart and checkout")
    public void validateAddingDifferentProductsToCartAndCheckOut() throws InterruptedException {
        homePage=new P01_HomePage(driver);
        dashboard=new P04_Dashboard(driver);
        loginPage=new P03_LoginPage(driver);
        checkOutPage=new P05_BillingDetailsPage(driver);
        deliveryDetails=new P06_DeliveryDetailsPage(driver);
        deliveryMethod=new P07_DeliveryMethodPage(driver);
        paymentMethod=new P08_PaymentMethodPage(driver);
        confirmOrder=new P09_ConfirmOrderPage(driver);

        firstName = RandomGenerator.generateRandomFirstName();
        lastName = RandomGenerator.generateRandomLastName();
        address = RandomGenerator.generateAddress();
        city=RandomGenerator.generateRandomCity();
        postCode=RandomGenerator.generatePostalCode();

        homePage.clickLoginButton();
        loginPage.login(email, password);
        dashboard.dashboardPage();
        dashboard.addProductsToCart();
        dashboard.shoppingCartButton();
        checkOutPage.checkOutButton();
        Assert.assertTrue( checkOutPage.checkOutPage());
        checkOutPage.billingDetails(firstName,lastName,address,city,postCode);
        deliveryDetails.deliveryDetails();
        deliveryMethod.deliveryMethod();
        paymentMethod.paymentMethod();
        confirmOrder.confirmOrder();
        String message = confirmOrder.getSuccessMessage();
        System.out.println(message); // Print the success message
        assertEquals(message, "Your order has been placed!");

    }
}