package com.LibraryCT.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;

    @BeforeEach
    public void setUpDrive(){

        WebDriverManager.chromedriver().setup();
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }

}
