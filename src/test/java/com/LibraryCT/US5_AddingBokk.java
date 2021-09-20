package com.LibraryCT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class US5_AddingBokk {
    public static void main(String[] args) {
        /**
         * AC #1:
         * Given librarian is on the homePage
         * When librarian click Books module
         * And librarian click “+Add Book” button
         * When librarian enter BookName, ISBN, Year, Author, and Description
         * And librarian click save changes
         * Then verify a new book is added
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
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

        WebElement listOfTheBooksBeforeAdding = driver.findElement(By.xpath("//div/table[@id='tbl_books']"));
        String beforeAdding = listOfTheBooksBeforeAdding.getText();

        WebElement bookModule = driver.findElement(By.xpath("//*[@id=\"menu_item\"]/li[3]/a/span[1]"));
        bookModule.click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement addBookBtn = driver.findElement(By.xpath("//*[@id=\"books\"]/div[1]/div[1]/span/a"));
        addBookBtn.click();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement bookName = driver.findElement(By.name("name"));
        bookName.sendKeys("Alice in Wonderland");

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        WebElement isbnBtn = driver.findElement(By.name("isbn"));
        isbnBtn.sendKeys("123");

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        WebElement yearBtn = driver.findElement(By.name("year"));
        yearBtn.sendKeys("1865");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement authorBtn = driver.findElement(By.xpath("//*[@id=\"add_book_form\"]/div[1]/div/div[2]/div[1]/div/input"));
        authorBtn.sendKeys("Lewis Carol");

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement bookCategory = driver.findElement(By.id("book_group_id"));
        Select obj = new Select(bookCategory);
        obj.selectByValue("13");

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement saveChangeBtn = driver.findElement(By.xpath("//*[@id=\"add_book_form\"]/div[2]/button[2]"));
        saveChangeBtn.click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);


        WebElement listOgTheBooksAfterAdding =driver.findElement(By.xpath("//div[@class='dataTables_info']"));
        String afterAdding=listOgTheBooksAfterAdding.getText();

        if (!listOfTheBooksBeforeAdding.equals(listOgTheBooksAfterAdding)){
            System.out.println("Test passed: New Book successfully was added " );

        }else {
            System.out.println("Test failed: New book was not added");
            System.out.println(beforeAdding);
            System.out.println(afterAdding);
        }








    }
}
