package testcases;

import Pages.P01_HomePage;
import Pages.P03_LoginPage;
import Pages.P04_Dashboard;
import org.testng.Assert;
import org.testng.annotations.Test;
import static testcases.TC01_Register.email;
import static testcases.TC01_Register.password;

public class TC07_Shopping extends TestBase{
    P01_HomePage homePage;
    P04_Dashboard dashboard;
    P03_LoginPage loginPage;

    @Test(priority = 1, description = "add different products to shopping cart")
    public void validateAddingDifferentProductsToShoppingCart() throws InterruptedException {
        dashboard=new P04_Dashboard(driver);
        dashboard.addProductsToCart();
    }

    @Test(priority = 2, description = "add different products to wishlist")
    public void validateAddingDifferentProductsToWishlist() throws InterruptedException {
        homePage=new P01_HomePage(driver);
        dashboard=new P04_Dashboard(driver);
        loginPage=new P03_LoginPage(driver);

        homePage.clickLoginButton();
        loginPage.login(email, password);
        dashboard.dashboardPage();
        dashboard.addProductsToWishList();
    }

    @Test(priority = 3, description = "add different products to compare list")
    public void validateAddingDifferentProductsToCompareList() throws InterruptedException {
        dashboard=new P04_Dashboard(driver);
        dashboard.addProductsToCompareList();
        Assert.assertTrue(dashboard.productPage());
    }
}