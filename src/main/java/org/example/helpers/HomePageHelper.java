package org.example.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.pages.Links.*;
import static org.example.pages.SearchInventoryPage.ZIP_CODE_FIELD;

public class HomePageHelper extends BaseHelper {

    WebDriver driver;

    public HomePageHelper(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void openHomePage(){
        driver.get(HOME_PAGE);
    }

    public void openSearchInventoryPage(){
        driver.get(SEARCH_INVENTORY_PAGE);
    }

    public void openModelNXPage(){
        driver.get(MODEL_NX_PAGE);
    }


    public void fillZipCodeAndSubmit(WebDriverWait wait) {
        WebElement ZipcodeField = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(ZIP_CODE_FIELD)));
        ZipcodeField.sendKeys("90240");
        ZipcodeField.submit();
    }

}
