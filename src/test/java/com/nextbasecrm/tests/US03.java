package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.DP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US03  extends TestBase {


    @Test(dataProvider = "User Credentials", dataProviderClass = DP.class)


    public void log_out(String userName, String password) {

        CRM_Utilities.crm_login(driver, userName, password);

        WebElement userProfileButton = driver.findElement(By.xpath("//span[@id='user-name']"));
        userProfileButton.click();

        WebElement logOutButton = driver.findElement(By.xpath("//a[@href='/auth/?logout=yes&backurl=%2Fstream%2F']"));
        logOutButton.click();

        String expectedTitle = "Authorization";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Test is failed!");




    }



}

/*
Story 3:
As a user, I should log out from the NextBaseCRM app.
Acceptance Criteria:
1. The “Log out” option should be displayed when the user clicks the user profile from the homepage.
2. After clicking the logout button, the user should navigate back to the login page.
Scenarios :
1. Verify Users (HR, marketing, Helpdesk) logout successfully
 */