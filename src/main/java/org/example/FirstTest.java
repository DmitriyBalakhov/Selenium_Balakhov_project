import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertTrue;


public class FirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void HomePageLoadTest() {
        driver.get("https://www.lexus.com/");
        assertTrue(wait.until(ExpectedConditions.titleContains("Lexus")));
    }
/*
    @Test
    public void SearchFunctionalityTest(){
        driver.get("https://www.lexus.com/");
        // WebElement courseButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@alt='Search']"))));
        // JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement element;
        element=driver.findElement(By.xpath("//*[@alt='Search']"));
        element.click();
        element=driver.findElement(By.xpath("//*[@name='q']"));
        element.click();
        element.sendKeys("ES");
        element.submit();
        element=driver.findElement(By.xpath("//*[@href=\"/models/ES\"]"));
        element.click();
        assertTrue(wait.until(ExpectedConditions.titleContains("2024 Lexus ES")));
    }
*/


    @Test
    public void VehicleComparisonTest() {
        driver.get("https://www.lexus.com/search-inventory/model/NX?zipcode=90240&dealerDistance%5B%5D=60445");
        WebElement favoriteButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//*[@fill-rule='evenodd'])[1]"))));
        WebElement element;
        element.click();
        element = driver.findElement(By.xpath("//*[@stroke='black']"));
        element.click();
        boolean isElementVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='2025 NX 250']"))).isDisplayed();
        assertTrue(isElementVisible);
    }
}
    /*
    @Test
    public void TestDriveRequestTest(){
        driver.get("https://www.lexus.com/");
        // WebElement courseButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@alt='Search']"))));
        // JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement element;
        element=driver.findElement(By.xpath("//*[@alt='Search']"));
        element.click();
    }

     */