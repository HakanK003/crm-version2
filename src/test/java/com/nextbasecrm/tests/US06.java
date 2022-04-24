package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.DP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class US06 extends TestBase{


    @Test(dataProvider = "User Credentials", dataProviderClass = DP.class)
    public void testingMoreTab(String s1, String s2){

        CRM_Utilities.crm_login(driver, s1, s2);

        WebElement moreTab = driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-link-more\"]/span[2]"));

        assertTrue(moreTab.isDisplayed());

        moreTab.click();

        WebElement moreTabMenuAfterClick = driver.findElement(By.xpath("//div[@id='popup-window-content-menu-popup-feed-add-post-form-popup']"));

        assertEquals(moreTabMenuAfterClick.getText(), "File\n" +
                "Appreciation\n" +
                "Announcement\n" +
                "Workflow");
    }

}

/*
Story 6:
As a user, I want to see all the options under the MORE tab in the
homepage.
Acceptance Criteria:
1. Four options should be displayed under the MORE tab:
1. File
2. Appreciation
3. Announcement
4. Workflow
Scenarios :
1. Verify users (HR, marketing, Helpdesk) access more tabs
 */