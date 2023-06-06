package com.fidelity.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private Driver(){}

    private static WebDriver driver;

    public static WebDriver getDriver(){

        if (driver==null){
            String browser = ConfigReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    driver = new ChromeDriver();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver = null;
        }
    }
}
