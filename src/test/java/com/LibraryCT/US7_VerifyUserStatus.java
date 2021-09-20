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

public class US7_VerifyUserStatus extends TestBase {
  @Test
  public void testUserStatus(){
        /**
         * AC #1:
         * Given librarian is on the homePage
         * When librarian click Users module
         * And librarian click Status dropdown
         * Then verify there are 2 status options
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

        WebElement dropDownStatus = driver.findElement(By.id("user_status"));
        dropDownStatus.click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        String firstElm = driver.findElement(By.xpath("//*[@id=\"user_status\"]/option[1]")).getText();
        String secondElm = driver.findElement(By.xpath("//*[@id=\"user_status\"]/option[2]")).getText();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        ArrayList<String> actualResult = new ArrayList<>(Arrays.asList(firstElm,secondElm));

        ArrayList<String> expectedResult = new ArrayList<>(Arrays.asList("ACTIVE","INACTIVE"));
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        assertTrue( expectedResult.equals(actualResult));










    }
}
