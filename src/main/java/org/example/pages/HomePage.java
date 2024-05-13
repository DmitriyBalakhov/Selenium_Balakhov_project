package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
         super(driver);
         this.driver = driver;
    }

    public static final By SEARCH_BUTTON = By.xpath("//*[@alt='Search']") ;
    public static final By SEARCH_FIELD = By.xpath("//*[@name='q']");
    public static final By SAVED_CARS_BUTTON = By.xpath("//*[@href='/saves']");
    public static final By NEXT_SLIDE_BUTTON = By.xpath("(//*[@data-testid=\"Arrow\"])[2]");
    public static final By PREVIOUS_SLIDE_BUTTON = By.xpath("(//*[@data-testid=\"Arrow\"])[1]");




}
