package com.aafalu.interview.solutions.seleniumexceptions;

import com.aafalu.interview.solutions.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumNoSuchFrameException extends TestBase {

  /*
   This exception occurs when the WebDriver instance
   is unable to switch to a frame that does not exist
   or is not currently available.
     */

    @BeforeMethod
    public void setUpMethod() {
        launchBrowser("https://www.letskodeit.com/courses");
    }

    @Test
    public void testNoSuchFrameException() {

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
        Assert.assertTrue(error.contains("element not interactable"), "error is " + error);

    }

    @AfterTest
    public void tearDown() {
        closeDriver();
    }

}