package com.LibraryCT;

import com.LibraryCT.utility.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class US2_LibrarianLoggedOut extends TestBase {
    @Test
    public void testLoggingOut(){
        /**
         * AC #1:
         * Given user is on the homePage
         * When user click username on the right top corner
         * And user click Log Out
         * Then verify user navigate back to login page.
         */

        driver.get("http://library2.cybertekschool.com/login.html");

        WebElement emailBox = driver.findElement(By.id("inputEmail"));
        emailBox.sendKeys("librarian22@library");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement passwordBox = driver.findElement(By.id("inputPassword"));
        passwordBox.sendKeys("Sdet2022*");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement signInBtn = driver.findElement(new By.ByCssSelector("button"));
        signInBtn.submit();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement userName = driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]/span"));
        userName.click();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement loggedOutBtn = driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul[2]/li/div/a"));
        loggedOutBtn.click();

        String expectedUrl = "https://library2.cybertekschool.com/login.html";
        String actualUrl = driver.getCurrentUrl();

       assertTrue(expectedUrl.equals(actualUrl));


    }
}
