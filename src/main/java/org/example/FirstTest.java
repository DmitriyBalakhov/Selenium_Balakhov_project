import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
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


    @Test
    public void SearchFunctionalityTest(){
        driver.get("https://www.lexus.com/");
        // WebElement courseButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@alt='Search']"))));
        // JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement element;
        WebElement searchIcon=driver.findElement(By.xpath("//*[@alt='Search']"));
        searchIcon.click();
        WebElement searchField=driver.findElement(By.xpath("//*[@name='q']"));
        searchField.click();
        searchField.sendKeys("ES");
        searchField.submit();
        WebElement firstResultLink=driver.findElement(By.xpath("//*[@href=\"/models/ES\"]"));
        firstResultLink.click();
        assertTrue(wait.until(ExpectedConditions.titleContains("2024 Lexus ES")));
    }



    @Test
    public void CarouselFunctionalityTest() {
        driver.get("https://www.lexus.com");
        WebElement nextSlideButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//*[@data-testid=\"Arrow\"])[2]"))));
        nextSlideButton.click();
        WebElement vechicleName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()=\"THE ALL-ELECTRIC RZ\"])[2]")));

    }



    @Test
    public void AnchorFunctionalityTest() {
        driver.get("https://www.lexus.com/search-inventory");
        WebElement EnterZipcodeField = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@aria-labelledby='zipcode']"))));
        EnterZipcodeField.sendKeys("90240");
        EnterZipcodeField.submit();
        WebElement sedanAnchor = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@href='#SEDAN_list']"))));
        sedanAnchor.click();
        assertTrue(driver.findElement(By.xpath("//*[text()=\"ES\"]")).isDisplayed());
        WebElement HybridAnchor = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@href='#HYBRIDELECTRIC_list']"))));
        HybridAnchor.click();
        assertTrue(driver.findElement(By.xpath("//*[text()=\"NX HYBRID\"]")).isDisplayed());
        WebElement PerfomanceAnchor = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@href='#PERFORMANCE_list']"))));
        PerfomanceAnchor.click();
        assertTrue(driver.findElement(By.xpath("//*[text()=\"RC\"]")).isDisplayed());

    }


    @Test
    public void addingToFavoritesTest() {
        driver.get("https://www.lexus.com/search-inventory/model/NX?zipcode=90240&dealerDistance%5B%5D=60445");
        WebElement addToFavoriteButton = driver.findElement(By.xpath("//*[@class='dg-heart-lexus dg-inline-saves-container' and @id='dg-inline-saves-inv-JTJADCAZ8S2015051undefined']"));
        addToFavoriteButton.click();
        //Adding thread.sleep in this part is necessary, because it gives time to complete saving action. If you can offer other solution please provide )
        try {
            Thread.sleep(3000);
        }
        catch(InterruptedException e) {
        }
        WebElement mySavedCars = driver.findElement(By.xpath("//*[@href='/saves']"));
        mySavedCars.click();
        WebElement vechicleName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='2025 NX 250']")));

    }
}

