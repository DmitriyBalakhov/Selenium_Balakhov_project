package org.example.pages;

import org.openqa.selenium.WebDriver;

public class Links {
    WebDriver driver;

    public Links(WebDriver driver) {
        this.driver = driver;

    }

    public static final String HOME_PAGE = "https://www.lexus.com/";
    public static final String SEARCH_INVENTORY_PAGE = "https://www.lexus.com/search-inventory";
    public static final String MODEL_NX_PAGE = "https://www.lexus.com/search-inventory/model/NX";

}