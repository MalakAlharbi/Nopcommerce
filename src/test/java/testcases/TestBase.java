package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class TestBase {

    static WebDriver driver;
    SoftAssert softAssert=new SoftAssert();

    @BeforeTest
    public void setUpWebDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://awesomeqa.com/ui/");

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}