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

public class US9_VerifyBookOptions extends TestBase {
    @Test
    public void testBookOptions(){
        /**
         * AC #1:
         * Given user is on the homePage
         * When user click Books module
         * And user click book category dropdown
         * Then verify there are 21 options
         */

        driver.get("http://library2.cybertekschool.com/login.html");

        WebElement emailBox = driver.findElement(By.id("inputEmail"));
        emailBox.sendKeys("librarian22@library");
        driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);

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

        int countOfOption = dropDownNum.getOptions().size();
        if(countOfOption==21){
            System.out.println("Test passed");
            System.out.println("There are 21 book category options");
        }else {
            System.out.println("Test failed");
        }


        driver.quit();














    }
    }

