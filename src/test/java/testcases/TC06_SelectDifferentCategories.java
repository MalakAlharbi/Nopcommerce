package testcases;

import Pages.P04_Dashboard;
import org.testng.annotations.Test;

public class TC06_SelectDifferentCategories extends TestBase{

    P04_Dashboard dashboard;

    @Test(priority = 1, description = "select different categories")
    public void validateSelectRandomCategor() throws InterruptedException {
        dashboard=new P04_Dashboard(driver);
        dashboard.hoverAndClickRandomCategory();
    }

    @Test(priority = 2, description = "select different categories then open sub-categories ")
    public void validateSelectRandomCategorAndOpenSubCategories() throws InterruptedException {
        dashboard = new P04_Dashboard(driver);
        dashboard.clickRandomFirstThreeCategories();
    }
}
