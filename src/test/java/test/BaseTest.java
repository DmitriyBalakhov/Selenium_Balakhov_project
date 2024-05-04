package test;

import org.example.helpers.HomePageHelper;
import org.example.pages.HomePage;
import org.example.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    HomePageHelper homePageHelper;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        driver = WebDriverFactory.getDriver(browser);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        homePage = new HomePage(driver);
        homePageHelper = new HomePageHelper(driver);

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
      WebDriverFactory.closeDriver();
    }
}
