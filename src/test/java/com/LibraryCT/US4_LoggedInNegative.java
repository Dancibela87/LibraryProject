package com.LibraryCT;

import com.LibraryCT.utility.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class US4_LoggedInNegative extends TestBase {
    @Test
    public void testLoggedWithInvalidCredentials(){
        /**
         * AC #3 [negative]:
         * Given user is on the loginPage
         * When user enters invalid email address or password
         * And student click sign in button
         * Then verify the error message “Sorry, Wrong Email or Password”
         */

        driver.get("http://library2.cybertekschool.com/login.html");

        WebElement emailBox = driver.findElement(By.id("inputEmail"));
        emailBox.sendKeys("dankapavlovic@gmail.com");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement passwordBox = driver.findElement(By.id("inputPassword"));
        passwordBox.sendKeys("somepassword");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement signInBtn = driver.findElement(new By.ByCssSelector("button"));
        signInBtn.submit();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);


        WebElement actualResult = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));


        if(actualResult.getText().equals("Sorry, Wrong Email or Password")){
            System.out.println("Test passed, actual result matches with expected result");
        }else{
            System.out.println("Test failed actual result does not matches with expected result");

        }

        driver.quit();



    }
}
