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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class US3_StudentLoggedIn extends TestBase {
    @Test
    public void testStudentLogging(){
        /**
         * AC#2:
         * Given student is on the loginPage
         * Then verify that the URL is
         *  “https://library2.cybertekschool.com/login.html”
         * When student enters valid email address and password
         * And student click sign in button
         * Then verify that there are 2 models on the pag
         */

        driver.get("http://library2.cybertekschool.com/login.html");

        WebElement emailBox = driver.findElement(By.id("inputEmail"));
        emailBox.sendKeys("student92@library");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement passwordBox = driver.findElement(By.id("inputPassword"));
        passwordBox.sendKeys("Sdet2022*");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement signInBtn = driver.findElement(new By.ByCssSelector("button"));
        signInBtn.submit();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        String expectedUrl = "https://library2.cybertekschool.com/login.html";
        String actualUrl = driver.getCurrentUrl();
        if(expectedUrl.equals(actualUrl)){
            System.out.println("Passed");
            System.out.println("Expected URL and Actual URL is the same");
        }else{
            System.out.println("Failed");
            System.out.println("expectedUrl = " + expectedUrl);
            System.out.println("actualUrl = " + actualUrl);
        }
        System.out.println("-----------------------------------------");


        List<String> expectedResult = new ArrayList<>(Arrays.asList("Books", "Borrowing Books"));
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        String booksElement = driver.findElement(By.linkText("Books")).getText();///////
        String borrowingBooksElement = driver.findElement(By.linkText("Borrowing Books")).getText();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        List<String> actualResult =  new ArrayList<>(Arrays.asList(booksElement,borrowingBooksElement));
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

     assertTrue( expectedResult.equals(actualResult));
}


}