package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public enum WebDriverFactory {

    CHROME{
        @Override
        protected WebDriver createDriver(){
            return new ChromeDriver();
        }
    },
    FIREFOX{
        @Override
        protected WebDriver createDriver(){
            return new FirefoxDriver();
        }
    };

    private WebDriver driver;

    public synchronized WebDriver getDriver() {

        if (driver == null) {
            driver = createDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public synchronized void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
    protected abstract WebDriver createDriver();

}
