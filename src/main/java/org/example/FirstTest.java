import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
*/


    @Test
    public void CarouselFunctionalityTest() {
        driver.get("https://www.lexus.com");
        WebElement nextSlideButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//*[@data-testid=\"Arrow\"])[2]"))));
        nextSlideButton.click();
        WebElement vechicleName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()=\"THE ALL-ELECTRIC RZ\"])[2]")));

    }





    /* This test is till in development process
    @Test
    public void SavedCarsTest() {
        driver.get("https://www.lexus.com/search-inventory/model/NX?zipcode=90240&dealerDistance%5B%5D=60445");
        WebElement addToFavoriteButtonIsNotActive = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//*[@class='dg-heart-lexus dg-inline-saves-container'])[1]"))));
        Actions hover = new Actions(driver);
        addToFavoriteButtonIsNotActive.click();
        //hover.moveToElement(addToFavoriteButtonIsNotActive).perform();
        //WebElement addToFavoriteButtonActive = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@class='v-popper--has-tooltip']"))));
        //addToFavoriteButtonActive.click();
        WebElement mySavedCars = driver.findElement(By.xpath("//*[@href='/saves']"));
        mySavedCars.click();
        WebElement vechicleName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='2025 NX 250']")));
    }

 */
}