package com.aafalu.interview.solutions.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected static WebDriver driver = null;

    /*
    Helper Method to create the instance of chrome driver
     */
    private ChromeDriver getDriver() {
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        // remote -allow-origins required to solve the driver not entering url issue
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        // options.addArguments("--start-fullscreen");
        return new ChromeDriver(options);
    }

    protected void launchBrowser(String url) {
        driver = getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);

    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
