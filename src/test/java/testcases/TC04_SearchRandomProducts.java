package testcases;

import Utilities.RandomGenerator;
import Pages.P04_Dashboard;
import org.testng.annotations.Test;

public class TC04_SearchRandomProducts extends TestBase{
    P04_Dashboard dashboard;

    String productName;

    @Test(priority = 1, description = "search random products")
    public void validateSearchingRandomProducts() throws InterruptedException {
        dashboard=new P04_Dashboard(driver);
        productName = RandomGenerator.generateRandomProduct();
        dashboard.searchProducts(productName);
    }
}