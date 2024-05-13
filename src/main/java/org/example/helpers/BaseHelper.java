package org.example.helpers;

import org.openqa.selenium.WebDriver;

public class BaseHelper {

    WebDriver driver;

    BaseHelper(WebDriver driver){
        this.driver = driver;
    }

}
