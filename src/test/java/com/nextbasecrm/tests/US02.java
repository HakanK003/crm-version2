package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.DP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US02  extends TestBase {


    @Test(dataProvider = "User Credentials", dataProviderClass = DP.class)
    public void rememberMeCheckBox(String userName, String password) {
        driver.get("https://login1.nextbasecrm.com");

        WebElement userNameIB = driver.findElement(By.xpath("//input[@class='login-inp' and @placeholder='Login']"));

        WebElement passIB = driver.findElement(By.xpath("//input[@class='login-inp' and @placeholder='Password']"));

        WebElement rememberCheckBox = driver.findElement(By.xpath("//input[@id='USER_REMEMBER']"));

        userNameIB.sendKeys(userName);

        passIB.sendKeys(password);

        rememberCheckBox.click();

        WebElement logInBtn = driver.findElement(By.xpath("//input[@type='submit']"));

        logInBtn.click();

        WebElement userMenu = driver.findElement(By.xpath("//div[@id='user-block']"));

        userMenu.click();


        WebElement logOutBox = driver.findElement(By.xpath("//*[@id=\"popup-window-content-menu-popup-user-menu\"]/div/div/a[3]"));

        logOutBox.click();

        userNameIB = driver.findElement(By.xpath("//input[@class='login-inp' and @placeholder='Login']"));


        Assert.assertEquals(userName,userNameIB.getAttribute("value"));


    }


}

/*
Story 2:
As a user, I should be able to save my user credential on a computer.

Acceptance Criteria:
1. There should be a Checkbox label displayed
2. “Remember me on this computer” should be displayed on the left side of the checkbox label.
scenarios :
1. Verify Users are able to check the checkbox
 */