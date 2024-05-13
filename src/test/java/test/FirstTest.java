package test;
import org.example.helpers.HomePageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;
import static org.example.pages.HomePage.*;
import static org.example.pages.SearchInventoryPage.*;
import static org.example.pages.Links.*;



public class FirstTest extends BaseTest{


    @Test
    public void homePageLoadTest() {
        homePageHelper.openHomePage();
        assertTrue(wait.until(ExpectedConditions.titleContains("Lexus")));
    }


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

    @Test
    public void addingToFavoritesTest() {
        homePageHelper.openModelNXPage();
        homePageHelper.fillZipCodeAndSubmit(wait);
        WebElement addToFavoriteButton = driver.findElement(By.xpath("//*[@class='dg-heart-lexus dg-inline-saves-container' and @id='dg-inline-saves-inv-JTJADCAZ8S2015051undefined']"));
        addToFavoriteButton.click();
        assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dg-tooltip-text']"))).isDisplayed());
        WebElement mySavedCars = driver.findElement(SAVED_CARS_BUTTON);
        mySavedCars.click();
        assertTrue(driver.findElement(By.xpath("//*[text()='2025 NX 250']")).isDisplayed());

    }

}

