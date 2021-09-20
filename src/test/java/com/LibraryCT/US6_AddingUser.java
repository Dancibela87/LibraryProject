package com.LibraryCT;

import com.LibraryCT.utility.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class US6_AddingUser extends TestBase {

    @Test
    public void testUserAdding(){
        /**
         * AC #1:
         * Given librarian is on the homePage
         * When librarian click Users module
         * And librarian click “+Add User” button
         * When librarian enter full name, password, email and
         * address
         * And librarian click save changes
         * Then verify a new user is created
         */

        driver.get("https://library2.cybertekschool.com/login.html");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        //find email input box and enter email
        driver.findElement(By.id("inputEmail")).sendKeys("librarian21@library");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        //find password input box and enter password
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Sdet2022*");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        //find logg in button and click it
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        //find user module and get text to determine teh number of users before adding new one
        WebElement usersBefore =  driver.findElement(By.id("user_count"));
        String listBefore = usersBefore.getText();

        //find users module and click it
        driver.findElement(By.linkText("Users")).click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        //click add user
        driver.findElement(By.linkText("Add User")).click();

        //
        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Danka Pavlovic");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("danka26");

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        WebElement email =  driver.findElement(By.name("email"));
        email.sendKeys("dankapavlovic87@gmail.com");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement address = driver.findElement(By.xpath("//*[@id=\"address\"]"));
        address.sendKeys("2001 Columbia pike, Apt 405, VA, 22204");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement saveChangesBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        saveChangesBtn.click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        driver.get("https://library2.cybertekschool.com/#dashboard");

        WebElement usersAfter =  driver.findElement(By.id("user_count"));
        String listAfter = usersAfter.getText();

        assertFalse(usersBefore.equals(usersAfter));



        

    }

}
