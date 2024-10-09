package testcases;

import Pages.P04_Dashboard;
import org.testng.annotations.Test;

public class TC05_SwitchCurrency extends TestBase{
    P04_Dashboard dashboard;

    @Test(priority = 1, description = "select random currency")
    public void validateSearchingRandomProducts() throws InterruptedException {
        dashboard=new P04_Dashboard(driver);
       dashboard.selectCurrency();
    }
}