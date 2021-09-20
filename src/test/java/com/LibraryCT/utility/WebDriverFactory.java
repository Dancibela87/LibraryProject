package com.LibraryCT.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserName) {

        WebDriver driver;

        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "fireFox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;


            default:
                driver = null;
                System.out.println("Unknown browser type" + browserName);
                break;

        }
        driver.manage().window().maximize();
        return driver;

    }








}
