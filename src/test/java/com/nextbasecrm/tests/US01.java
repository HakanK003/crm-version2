package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.DP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US01 extends TestBase{

    @Test(dataProvider = "User Credentials", dataProviderClass = DP.class)
    public void homePageAfterLogin(String userName, String password){

        driver.get("https://login2.nextbasecrm.com/");
        String expectedTitle = "Authorization";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement userNameBox = driver.findElement(By.xpath("//input[@type='text']"));
        userNameBox.sendKeys(userName);

        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordBox.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();

        String expectedHomePageTitle = "Portal";
        String actualHomePageTitle = driver.getTitle();

        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);

    }

    @Test
    public void incorrectUsernameOrPassword(){

        driver.get("https://login2.nextbasecrm.com/");
        String expectedTitle = "Authorization";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement userName = driver.findElement(By.xpath("//input[@class='login-inp']"));
        userName.sendKeys("marketing666@cydeo.com");
        //incorrect username so I can create a negative testing

        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();

        String expectedIncorrectLoginMessage = "Incorrect username or password";

        String actualIncorrectLoginMessage = driver.findElement(By.xpath("//div[@class='errortext']")).getText();

        //System.out.println("actualIncorrectLoginMessage = " + actualIncorrectLoginMessage);

        Assert.assertEquals(actualIncorrectLoginMessage, expectedIncorrectLoginMessage);
    }


}

/*
Story 1:
As a user, I should be able to log in to the NextBaseCRM.

Acceptance Criteria:
1. The login page title should be “Authorization”.
2. Checkbox label should be displayed on the left side of “Remember me on this computer”.
3. “Incorrect username or password” should be displayed under the “Authorization” header when a user enters the wrong
username or password.
scenarios :
1. Verify the tile
2. Verify Users (HR, marketing, Helpdesk) login successfully
3. Verify Users see “Incorrect username or password” for the invalid login attempt
 */