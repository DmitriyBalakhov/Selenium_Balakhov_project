package test;

import org.example.helpers.HomePageHelper;
import org.example.pages.HomePage;
import org.example.utils.PropertyFactory;
import org.example.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.Properties;

import static org.example.utils.PropertyFactory.getBrowserProperty;

/**
 Class BaseTest implements general functionality for all classes.
**/

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    private Properties testConfig;
    HomePage homePage;
    HomePageHelper homePageHelper;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        this.testConfig = PropertyFactory.loadProperties(System.getProperty("user.dir")+"/src/main/resources/test.properties");
        driver = WebDriverFactory.valueOf(testConfig.getProperty("browser")).getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        homePage = new HomePage(driver);
        homePageHelper = new HomePageHelper(driver);

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
       WebDriverFactory.valueOf(getBrowserProperty()).closeDriver();
      }
    }

