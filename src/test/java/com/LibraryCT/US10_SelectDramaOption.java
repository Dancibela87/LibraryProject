package com.LibraryCT;

import com.LibraryCT.utility.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class US10_SelectDramaOption extends TestBase {
   @Test
   public void testDramaOption(){

        /**
         AC #2:
         Given user is on the homePage
         When user click Books module
         And user click book category dropdown
         Then verify user is able to selected the “Drama” option
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

        WebElement bookModule = driver.findElement(By.xpath("//*[@id=\"menu_item\"]/li[3]/a/span[1]"));
        bookModule.click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement bookDropDown = driver.findElement(By.id("book_categories"));
        bookDropDown.click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        Select dropDownNum = new Select(bookDropDown);

        dropDownNum.selectByVisibleText("Drama");

        WebElement optionDrama = driver.findElement(By.xpath("//option[@value='6']"));


          assertTrue(optionDrama.isSelected());

    }
}
