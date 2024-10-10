package Pages;

import Utilities.RandomGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static Utilities.RandomGenerator.generateRandomNumberInFirstThreeCategory;

public class P04_Dashboard {
    WebDriver driver;

    public P04_Dashboard(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@name='search']")
    WebElement searchBar;
    @FindBy(xpath = "//button[@class=\"btn btn-default btn-lg\"]")
    WebElement searchBtn;
    @FindBy(xpath = "(//button)[1]")
    WebElement currencyDropList;
    @FindBy(css = "[class^=\"currency-select\"]")
    List<WebElement> currencyList;
    @FindBy(xpath = "//*[@id='menu']/div[2]/ul/li")
    List<WebElement> categoriesList;
    @FindBy(xpath = "//*[@class=\"dropdown open\"]//li//a")
    List<WebElement> subCategoriesList;
    @FindBy(xpath = "//*[@onclick=\"cart.add('43');\"]")
    WebElement macBookCartBtn;
    @FindBy(xpath = "//*[@onclick=\"cart.add('40');\"]")
    WebElement iPhoneCartBtn;
    @FindBy(css = "[data-loading-text=\"Loading...\"]")
    WebElement addCartBtn;
    @FindBy(xpath = "//button[@onclick=\"wishlist.add('43');\"]")
    WebElement macBookWishListBtn;
    @FindBy(xpath = "//button[@onclick=\"wishlist.add('40');\"]")
    WebElement iPhoneWishListBtn;
    @FindBy(css = "[id=\"logo\"]")
    WebElement dashboardBtn;
    @FindBy(xpath = "//button[@onclick=\"compare.add('43');\"]")
    WebElement macBookCompareListBtn;
    @FindBy(xpath = "//button[@onclick=\"compare.add('40');\"]")
    WebElement iPhoneCompareListBtn;
    @FindBy(xpath = "//*[text()='product comparison']")
    WebElement compareListBtn;
    @FindBy(xpath = "//*[@id=\"common-home\"]/div[1]/a[2]")
    WebElement shoppingCartBtn;

    public void dashboardPage() {
        this.dashboardBtn.click();
    }

    public void searchProducts(String productName) throws InterruptedException {
        Thread.sleep(3000);
        this.searchBar.sendKeys(productName);
        Thread.sleep(3000);
        this.searchBtn.click();
    }

    public void selectCurrency() throws InterruptedException {
        Thread.sleep(3000);
        this.currencyDropList.click();
        Thread.sleep(2000);
        RandomGenerator.hoverAndClickRandomCategory(currencyList);
    }

    public void hoverAndClickRandomCategory() throws InterruptedException {
        Thread.sleep(4000);
        RandomGenerator.hoverAndClickRandomCategory(categoriesList);
    }

    public void clickRandomFirstThreeCategories() throws InterruptedException {
        String categories = "(//li)[" + generateRandomNumberInFirstThreeCategory() + "]";
        Thread.sleep(8000);
        driver.findElement(By.xpath(categories)).click();
        Thread.sleep(3000);
        RandomGenerator.hoverAndClickRandomCategory(subCategoriesList);
    }

    public void addProductsToCart() throws InterruptedException {
        Thread.sleep(3000);
        this.macBookCartBtn.click();
        this.iPhoneCartBtn.click();
        Thread.sleep(3000);
        this.addCartBtn.click();
    }

    public void addProductsToWishList() throws InterruptedException {
        this.macBookWishListBtn.click();
        Thread.sleep(3000);
        this.iPhoneWishListBtn.click();
    }

    public void addProductsToCompareList() throws InterruptedException {
        this.macBookCompareListBtn.click();
        Thread.sleep(3000);
        this.iPhoneCompareListBtn.click();
        Thread.sleep(5000);
        this.compareListBtn.click();
    }

    public boolean productPage() {
        return driver.findElement(By.xpath("(//h1)")).getText().equals("Product Comparison");
    }

    public void shoppingCartButton() throws InterruptedException {
        Thread.sleep(2000);
        this.shoppingCartBtn.click();
    }
}