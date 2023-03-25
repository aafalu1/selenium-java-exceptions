package com.aafalu.interview.solutions.seleniumexceptions;

import com.aafalu.interview.solutions.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumStaleElementException extends TestBase {


    @BeforeMethod
    public void setUpMethod() {
        launchBrowser("https://www.google.com");
    }

    @Test
    public void testStaleElementReferenceException() {

       /*
       This exception occurs when the WebDriver instance tries to interact
       with an element that has been removed from the DOM or is no longer
       attached to the web page. This can happen when the page is
       refreshed, or the element is removed dynamically.
        */
        WebElement searchBox = null;
        try {
            searchBox = driver.findElement(By.name("q"));
            driver.navigate().refresh();
            searchBox.sendKeys("selenium");
        } catch (StaleElementReferenceException ex) {
            System.out.println("Exception name:  " + ex.getMessage());
            searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("selenium");
            driver.findElement(By.name("btnK")).click();

        }
        Assert.assertEquals(driver.getTitle(), "selenium - Google Search", "title did not match");
    }

    @AfterTest
    public void tearDown() {
        closeDriver();
    }

}
