package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchInventoryPage {

    WebDriver driver;
    public SearchInventoryPage(WebDriver driver) {
        this.driver = driver;

    }

    public static final By ZIP_CODE_FIELD = By.xpath("//*[@aria-label='Zip code input']");
    public static final By SEDAN_ANCHOR = By.xpath("//*[@href='#SEDAN_list']");
    public static final By HYBRID_ANCHOR = By.xpath("//*[@href='#HYBRIDELECTRIC_list']");
    public static final By PERFORMANCE_ANCHOR = By.xpath("//*[@href='#PERFORMANCE_list']");
    public static final By MODEL_ES = By.xpath("//*[text()='ES']");
    public static final By MODEL_NX_HYBRID = By.xpath("(//*[text()='NX HYBRID'])[2]");
    public static final By MODEL_RC = By.xpath("//*[text()='RC']");


}