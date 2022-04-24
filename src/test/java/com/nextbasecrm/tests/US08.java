package com.nextbasecrm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US08 extends TestBase{


    @Test
    public void verify_access_to_chat_and_call_module(){

        // 2. login to the page
        WebElement username = driver.findElement(By.xpath("//input[@class='login-inp']"));
        username.sendKeys("helpdesk79@cydeo.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
        // 3. click to Chat and Call  module
        WebElement chatCallButton = driver.findElement(By.xpath("//*[@id='bx_left_menu_menu_im_messenger']/a/span[1]"));
        chatCallButton.click();

        // 4.Verify 4 modules are displayed: Message, Notifications,Settings,Active Stream

        WebElement messageButton = driver.findElement(By.xpath("//*[@id=\"bx-desktop-tab-im\"]/div"));
        Assert.assertTrue(messageButton.isDisplayed(),"Message button is not displayed");

        WebElement notificationsButton = driver.findElement(By.xpath("//*[@id=\"bx-desktop-tab-im-lf\"]/div"));
        Assert.assertTrue(notificationsButton.isDisplayed(),"Notification button is not displayed");

        WebElement settingButton = driver.findElement(By.xpath("//*[@id=\"bx-desktop-tab-im-lf\"]/div"));
        Assert.assertTrue(settingButton.isDisplayed(),"Setting button is not displayed");

        WebElement activeStreamButton = driver.findElement(By.xpath("//*[@id=\"bx-desktop-tab-im-lf\"]/div"));
        Assert.assertTrue(activeStreamButton.isDisplayed(),"Active Stream Button is not displayed");



    }


}

/*
Story 8:
As a user, I want to access the Chat and Calls module.
Acceptance Criteria:
1. There should be four sub-modules once the user click the Chat and Calls module:
1. Message
2. Notifications
3. Settings
4. Active Stream
scenarios :
1. Verify users (HR, marketing, Helpdesk) access to the Chat and Calls submodules.
 */