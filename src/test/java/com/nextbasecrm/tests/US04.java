package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.DP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US04 extends TestBase {


    @Test(dataProvider = "User Credentials", dataProviderClass = DP.class)
    public void verifying_modules_userProfile(String userName, String password) {


        CRM_Utilities.crm_login(driver, userName,password);

        WebElement userProfileBtn = driver.findElement(By.xpath("//div[@id='user-block']"));
        userProfileBtn.click();

        List<String> allOptions = new ArrayList<>();

        for(WebElement each : driver.findElements(By.xpath("//*[@class='menu-popup-item-text']"))){
            allOptions.add(each.getText());
        }


        List<String> expectedModules = new ArrayList<>(Arrays.asList("My Profile", "Edit Profile Settings",
                "Themes", "Configure notifications", "Logout"));

        Assert.assertEquals(allOptions,expectedModules, "Modules are not matching with design document");


    }


}

/*
Story 4:
As a user, I want to see all the options under the user profile.
Acceptance Criteria:
1. Five options should be displayed under the user profile
1. My Profile
2. Edit Profile Settings
3. Themes
4. Configure notifications
5. Logout
Scenarios :
1. Verify users (HR, marketing, Helpdesk) access to 5 options under the user profile button
 */