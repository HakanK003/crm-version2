package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;

    @BeforeSuite
    public void initialBrowserDriver(){
        System.out.println("Before suit run once");
    }

    @AfterSuite
    public void tearDown(){
        System.out.println("After suit run once");


    }


    @BeforeMethod
    public void setUpBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://login1.nextbasecrm.com");

    }



    @AfterMethod
    public void closeBrowser(){
        driver.close();

    }

}
