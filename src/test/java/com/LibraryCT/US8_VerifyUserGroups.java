package com.LibraryCT;

import com.LibraryCT.utility.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.lang.management.GarbageCollectorMXBean;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class US8_VerifyUserGroups extends TestBase {
   @Test
   public void testUserGroups(){
        /**
         * AC #1:
         * Given librarian is on the homePage
         * When librarian click Users module
         * And librarian click user group dropdown
         * Then verify librarian have 3 options
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

        WebElement userModule = driver.findElement(By.linkText("Users"));
        userModule.click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement userGroupDropDown = driver.findElement(By.xpath("//select[@id='user_groups']"));
        userGroupDropDown.click();
        Select userGroupObj = new Select(userGroupDropDown);

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        WebElement firstElm = driver.findElement(By.xpath("//select[@id='user_groups']/option[@value='null']"));
        String firstElement = firstElm.getText();

        WebElement secondElm = driver.findElement(By.xpath("//select[@id='user_groups']/option[@value='2']"));
        String secondElement = secondElm.getText();

        WebElement thirdElm = driver.findElement(By.xpath("//select[@id='user_groups']/option[@value='3']"));
        String thirdElement = thirdElm.getText();


        ArrayList<String> expectedResult = new ArrayList<>(Arrays.asList("ALL","Librarian","Students"));
        ArrayList<String> actualResult =  new ArrayList<>(Arrays.asList(firstElement,secondElement,thirdElement));


     assertTrue( expectedResult.equals(actualResult));
















    }
}
