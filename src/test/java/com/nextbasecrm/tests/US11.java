package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.DP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class US11 extends TestBase {

    public final int TIME_OUT_SECONDS = 5;

    @Test(dataProvider = "User Credentials",dataProviderClass = DP.class)
    public void testCase_US_11 (String userName, String password){
        CRM_Utilities.crm_login(driver,userName,password);
        driver.manage().timeouts().implicitlyWait(TIME_OUT_SECONDS, TimeUnit.SECONDS);
        WebElement profile = driver.findElement(By.xpath("//div[@id='user-block']"));
        profile.click();
        WebElement myProfile = driver.findElement(By.xpath("//span[@class='menu-popup-item-text']"));
        myProfile.click();

        List<WebElement> tabs = driver.findElements(By.xpath("//div[@id='profile-menu-filter']//a"));
        List<String> actualTabs = new ArrayList<>();
        for(WebElement eachTab : tabs) {
            actualTabs.add(eachTab.getText());
        }
        List<String> expectedTabs = new ArrayList<>(Arrays.asList("General","Drive","Tasks","Calendar","Conversations"));
        int index = 0;
        for (String eachTab: actualTabs) {
            assertEquals(eachTab, expectedTabs.get(index++)," Tab is not matching with expected result ");
        }
    }


}

/*
Story 11:
As a user, I want to access my profile page.
Acceptance Criteria:
1. “My Profile” option should be displayed when the user clicks the user profile from the homepage.
2. There should be five tabs in my profile page:
 “General “Drive” “Tasks” “Calendar ” “conversations”
scenarios :
1. Verify user (HR, marketing, Helpdesk) checks user profile info
 */