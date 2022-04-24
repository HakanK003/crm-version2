package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US05 extends TestBase {


    @DataProvider(name = "User Credentials 1")
    public Object[][] provideUserData1() {
        return new Object[][]{
                {"hr64@cydeo.com", "UserUser", "CY22-5"},
                {"helpdesk64@cydeo.com", "UserUser", "CY22-5"},
                {"marketing65@cydeo.com", "UserUser", "CY22-5"},
        };
    }


    @Test(dataProvider = "User Credentials 1")
    public void sendingText(String userName, String password, String text) throws InterruptedException {

        CRM_Utilities.crm_login(driver, userName, password);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement messageBtn = driver.findElement(By.xpath("//*[.='Message'] "));
        messageBtn.click();


        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        WebElement BodyFrame = driver.findElement(By.xpath("/html/body"));
        BodyFrame.sendKeys(text);

        driver.switchTo().parentFrame();

        WebElement SendBox = driver.findElement(By.xpath("//*[@id='blog-submit-button-save'] "));
        SendBox.click();

        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='" + text + "']")).isDisplayed());

    }


    @Test(dataProvider = "User Credentials 1")
    public void sendingEmptyText(String userName, String password, String text) throws InterruptedException {

        CRM_Utilities.crm_login(driver, userName, password);

        WebElement messageBtn = driver.findElement(By.xpath("//*[.='Message'] "));
        messageBtn.click();


        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        WebElement BodyFrame = driver.findElement(By.xpath("/html/body"));
        BodyFrame.sendKeys("");

        driver.switchTo().parentFrame();

        WebElement SendBox = driver.findElement(By.xpath("//*[@id='blog-submit-button-save'] "));
        SendBox.click();
        Thread.sleep(2000);
        WebElement errorText = driver.findElement(By.xpath("//span[@class='feed-add-info-text']"));


        String actual = errorText.getText();
        String expected = "The message title is not specified";
        Assert.assertEquals(expected, actual);


    }


}

/*
Story 5:
As a user, I should be able to send simple text messages using the message tab.
Acceptance Criteria:
1. When users click the MASSAGE tab, they should be able to write the message body and
send a message successfully to the feed.
2. “The message title is not specified”. Should be displayed when users send a message
without a content.
scenarios :
1. Verify users (HR, marketing, Helpdesk) Send messages successfully
2. Verify Users get working a message without a message body.
 */