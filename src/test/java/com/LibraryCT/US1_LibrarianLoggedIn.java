package com.LibraryCT;

import com.LibraryCT.utility.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


import static org.junit.jupiter.api.Assertions.*;

public class US1_LibrarianLoggedIn extends TestBase {
    @Test
    public void testLogging() {
        /**
         * AC #1:
         * Given librarian is on the loginPage
         * Then verify that the title is “Login - Library”
         * When librarian enters valid email address and password
         * And librarian click sign in button
         * Then verify that there are 3 models on the pag
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

        List<String> expectedModules = new ArrayList<>(Arrays.asList("Dashboard", "Users", "Books"));
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        String dashboardModule = driver.findElement(By.linkText("Dashboard")).getText();
        String usersModule = driver.findElement(By.linkText("Users")).getText();
        String booksModule = driver.findElement(By.linkText("Books")).getText();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        List<String> actualModules = new ArrayList<>(Arrays.asList(dashboardModule, usersModule, booksModule));

        assertTrue(expectedModules.equals(actualModules));
    }


}