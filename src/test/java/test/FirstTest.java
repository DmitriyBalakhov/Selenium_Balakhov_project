package test;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;
import static org.example.pages.HomePage.*;
import static org.example.pages.SearchInventoryPage.*;

@Owner("Dmitriy Balakhov")
@Epic("Prod test")
public class FirstTest extends BaseTest{

    @Link("Jira-lxs001")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void homePageLoadTest() {
        homePageHelper.openHomePage();
        assertTrue(wait.until(ExpectedConditions.titleContains("Lexus")));
    }

    @Severity(SeverityLevel.NORMAL)
    @Link("Jira-lxs002")
    @Test
    public void searchFunctionalityTest(){
        homePageHelper.openHomePage();
        WebElement searchIcon=driver.findElement(SEARCH_BUTTON);
        searchIcon.click();
        WebElement searchField=driver.findElement(SEARCH_FIELD);
        searchField.click();
        searchField.sendKeys("ES");
        searchField.submit();
        WebElement firstResultLink=driver.findElement(By.xpath("//*[@href=\"/models/ES\"]"));
        firstResultLink.click();
        assertTrue(wait.until(ExpectedConditions.titleContains("2024 Lexus ES")));

    }

    @Severity(SeverityLevel.NORMAL)
    @Link("Jira-lxs003")
    @Test
    public void carouselFunctionalityTest() {
        homePageHelper.openHomePage();
        WebElement nextSlideButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(NEXT_SLIDE_BUTTON)));
        nextSlideButton.click();
        assertTrue(wait.until(ExpectedConditions.textToBe(By.xpath("(//*[text()=\"THE ALL-ELECTRIC RZ\"])[2]"), "THE ALL-ELECTRIC RZ")));
        WebElement previousSlideButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(PREVIOUS_SLIDE_BUTTON)));
        previousSlideButton.click();
        assertTrue(wait.until(ExpectedConditions.textToBe(By.xpath("//*[text()=\"THE ALL-NEW 2024 GX\"]"), "THE ALL-NEW 2024 GX")));

    }


@Severity(SeverityLevel.NORMAL)
@Link("Jira-lxs004")
@Flaky
@Description("This test fails only in allure reports")
@Test
    public void anchorFunctionalityTest() {
        homePageHelper.openSearchInventoryPage();
        homePageHelper.fillZipCodeAndSubmit(wait);
        WebElement sedanAnchor = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(SEDAN_ANCHOR)));
        sedanAnchor.click();
        assertTrue(driver.findElement(MODEL_ES).isDisplayed());
        WebElement HybridAnchor = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(HYBRID_ANCHOR)));
        HybridAnchor.click();
        assertTrue(driver.findElement(MODEL_NX_HYBRID).isDisplayed());
        WebElement PerformanceAnchor = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(PERFORMANCE_ANCHOR)));
        PerformanceAnchor.click();
        assertTrue(driver.findElement(MODEL_RC).isDisplayed());

    }

    @Severity(SeverityLevel.NORMAL)
    @Link("Jira-lxs005")
    @Test
    public void addingToFavoritesTest() {
        homePageHelper.openModelNXPage();
        homePageHelper.fillZipCodeAndSubmit(wait);
        WebElement addToFavoriteButton = driver.findElement(By.xpath("//*[@class='dg-heart-lexus dg-inline-saves-container' and @id='dg-inline-saves-inv-JTJADCAZ3S2015040undefined']"));
        addToFavoriteButton.click();
        assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dg-tooltip-text']"))).isDisplayed());
        WebElement mySavedCars = driver.findElement(SAVED_CARS_BUTTON);
        mySavedCars.click();
        assertTrue(driver.findElement(By.xpath("//*[text()='2025 NX 250']")).isDisplayed());

    }

    @Severity(SeverityLevel.NORMAL)
    @Link("Jira-lxs006")
    @Test
    public void iFrameTest() {
        homePageHelper.openHomePage();
        WebElement brochureButton = driver.findElement(By.xpath("//*[text()=\"REQUEST BROCHURE\"]"));
        action.moveToElement(brochureButton).click().perform();
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@src='/request-brochure']")));
        WebElement viewDigitalBrochures = driver.findElement(By.xpath("//*[@aria-label=\"VIEW DIGITAL BROCHURES\"]"));
        assertTrue(driver.findElement(By.xpath("//*[text()='VIEW DIGITAL BROCHURES']")).isDisplayed());

    }

}

