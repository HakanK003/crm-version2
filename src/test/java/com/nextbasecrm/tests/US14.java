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

public class US14  extends TestBase {


    @Test(dataProvider = "User Credentials", dataProviderClass = DP.class)


    public void check_3_desktop_options(String userName, String password) {

        CRM_Utilities.crm_login(driver, userName, password);

        List<WebElement> actualButtons = driver.findElements(By.xpath("//div[@class='b24-app-block b24-app-desktop']//div[@class='b24-app-block-content']//a"));
        List<String> actualButtonsText = new ArrayList<>();
        List<String> expectedButtonsText = new ArrayList<>(Arrays.asList("MAC OS", "WINDOWS", "LINUX"));

        for (WebElement each : actualButtons) {
            actualButtonsText.add(each.getText());
            System.out.println(each.getText());
        }


        Assert.assertEquals(actualButtonsText, expectedButtonsText);


    }


}

/*
Story 14:
As a user, I should be able to see 3 desktop options in the homepage.
Acceptance Criteria:
1. There should be 3 options for the desktop version:
 - MAC OS
 - WINDOWS
 - LINUS
scenarios :
1. Verify users (HR, marketing, Helpdesk) view 3 desktop clients
 */