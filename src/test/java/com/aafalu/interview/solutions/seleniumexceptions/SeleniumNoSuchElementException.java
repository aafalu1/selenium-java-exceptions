package com.aafalu.interview.solutions.seleniumexceptions;

import com.aafalu.interview.solutions.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumNoSuchElementException extends TestBase {

    /*
    This exception is thrown when an element is not found on the web page.
     This can happen if the element is not present on the page
     or if the locator used to find the element is incorrect.
     */

    @BeforeMethod
    public void setUpMethod() {
        launchBrowser("https://www.google.com");
    }

    @Test
    public void testNoSuchElementException() {

        boolean elementFound = false;
        try {
            //intentionally invalid name locator is entered to produce NO Such Element Exception
            elementFound = driver.findElement(By.name("non-existent-element")).isDisplayed();
        } catch (NoSuchElementException ex) {
            System.out.println("Element not found: " + ex.getMessage());
        }
        Assert.assertFalse(elementFound);
    }

    @AfterTest
    public void tearDown() {
        closeDriver();
    }

}
