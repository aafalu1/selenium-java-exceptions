package com.aafalu.interview.solutions.seleniumexceptions;

import com.aafalu.interview.solutions.Base.TestBase;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumElementNotInteractableException extends TestBase {

    /*
   This exception occurs when the WebDriver instance is unable to interact with an element.
   This can happen when the element is disabled, read-only, or
   not in a state that can be interacted with
     */

    @BeforeMethod
    public void setUpMethod() {
        launchBrowser("https://www.letskodeit.com/courses");
    }

    @Test
    public void testElementNotInteractableException() {

        String error = "";
        try {
            /*
            element has two matching node
             */
            driver.findElement(By.xpath("//*[@id='search']")).sendKeys("selenium");

        } catch (ElementNotInteractableException ex) {
            System.out.println("Exception name:  " + ex.getMessage());
            error = ex.getMessage();
        }
        Assert.assertTrue(error.contains("element not interactable"),  "error is "+ error);

    }

    @AfterTest
    public void tearDown() {
        closeDriver();
    }

}
