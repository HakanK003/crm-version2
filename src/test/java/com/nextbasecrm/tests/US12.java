package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.DP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US12 extends TestBase{


    @Test(dataProvider = "User Credentials", dataProviderClass = DP.class)

    public void positiveTest(String userName, String password)  {


        CRM_Utilities.crm_login(driver, userName, password);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement moreButton = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        moreButton.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement Announcement = driver.findElement(By.xpath("//span[text()='Announcement']"));
        Announcement.click();


        driver.switchTo().frame(1);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement announcementBox = driver.findElement(By.xpath("/html/body"));
        String annoucementMessage = " Announcement Test";
        announcementBox.sendKeys(annoucementMessage);
        driver.switchTo().parentFrame();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);




        WebElement submitSend = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        submitSend.click();






        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement AnnouncementSubmission= driver.findElement(By.className("feed-post-text-block-inner-inner"));
        Assert.assertTrue(AnnouncementSubmission.isDisplayed());
        System.out.println("Announcement Test Successful");
    }


    @Test(dataProvider = "User Credentials", dataProviderClass = DP.class)
    public void negativeTest(String userName, String password){

        CRM_Utilities.crm_login(driver, userName, password);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement moreButton = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        moreButton.click();


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement Announcement = driver.findElement(By.xpath("//span[text()='Announcement']"));
        Announcement.click();


        driver.switchTo().frame(1);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement announcementBox = driver.findElement(By.xpath("/html/body"));
        String annoucementMessage = "";
        announcementBox.sendKeys(annoucementMessage);


        driver.switchTo().parentFrame();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        WebElement submitSend = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        submitSend.click();

        WebElement errorMessage= driver.findElement(By.xpath("//span[@class='feed-add-info-text']"));
        Assert.assertTrue(errorMessage.isDisplayed());
        System.out.println(errorMessage.getText());


    }


}

/*
Story 12:
As a user, I should be able to Make Announcements using the Announcements tab.
Acceptance Criteria:
1. Users should be able to write messages in and send announcements by clicking
the SEND button.
2. When users attempt to make announcements without a message, there should be
a working message “The message title is not specified”.
scenarios :
1. Verify users (HR, marketing, Helpdesk) send announcements successfully
2. Verify users get working a message without a message body.
 */