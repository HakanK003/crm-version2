package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.DP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US10  extends TestBase {


    @DataProvider(name = "User Credentials1")
    public static Object[][] provideData() {
        return new Object[][]{
                {"hr64@cydeo.com", "UserUser","title","text"},
                {"hr65@cydeo.com", "UserUser","title","text"},
                {"hr66@cydeo.com", "UserUser","title","text"},
                {"helpdesk64@cydeo.com", "UserUser","title","text"},
                {"helpdesk65@cydeo.com", "UserUser","title","text"},
                {"helpdesk66@cydeo.com", "UserUser","title","text"},
                {"marketing64@cydeo.com", "UserUser","title","text"},
                {"marketing65@cydeo.com", "UserUser","title","text"},
                {"marketing66@cydeo.com", "UserUser","title","text"}
        };
    }


    //AC :
    //  Once a task is created successfully, there should be a confirmation message dimply in a popup.
    // “Task has been created”
    @Test (dataProvider = "User Credentials1")
    public void positive_task_creation_test(String username, String password,String titleText, String contentText){

        // getting to the homepage
        CRM_Utilities.crm_login(driver, username,password);

        // locating and clicking on the Task button
        WebElement taskTabBtn = driver.findElement(By.cssSelector("span#feed-add-post-form-tab-tasks"));
        taskTabBtn.click();

        // locating title input box and providing some test data
        WebElement titleInputBox = driver.findElement(By.xpath("//input[@placeholder='Things to do']"));
        titleInputBox.sendKeys(titleText);

        // locating and switching to the iframe with task content field
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='task-info-editor']//iframe")));


        // locating the task content field
        WebElement contentField = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        contentField.sendKeys(contentText);

        // switching to the parent frame
        driver.switchTo().parentFrame();

        // locating Send button and clicking on it
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

        // verifying that “Task has been created” message is being displayed
        String expectedPopUpMessage = "Task has been created";
        String actualPopUpMessage ;
        try {
            // locating pop-up window
            WebElement taskWindowPopUp = driver.findElement(By.xpath("//div[@id='blogPostEditCreateTaskPopup']"));

            // locating web element with message needed
            WebElement message = driver.findElement(By.xpath("//div[@class='feed-create-task-popup-title']"));


            actualPopUpMessage = message.getText();
        }catch (RuntimeException e){
            System.out.println("Could not Locate pop-up window");
            actualPopUpMessage = "";
        }


        Assert.assertEquals(actualPopUpMessage,expectedPopUpMessage);

    }


    // AC:
    // “The task name is not specified.”
    // The message should display when the user did not write the task title.
    @Test(dataProvider = "User Credentials", dataProviderClass = DP.class)
    public void negative_task_creation_test(String username, String password)  {

        // getting to the homepage
        CRM_Utilities.crm_login(driver, username,password);

        // locating and clicking on the Task button
        WebElement taskTabBtn = driver.findElement(By.cssSelector("span#feed-add-post-form-tab-tasks"));
        taskTabBtn.click();

        // locating Send button and clicking on it
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

        // locating error message element
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='task-message-label error']"));

        // verifying that “The task name is not specified.”
        // message is displayed when the user did not write the task title
        String expectedErrorMessageText = "The task name is not specified.";
        String actualErrorMessageText = errorMessage.getText();

        Assert.assertEquals(actualErrorMessageText,expectedErrorMessageText);


    }


}

/*
Story 10:
As a user, I want to create a task with just task content from the TASK tab.
Acceptance Criteria:
1. Once a task is created successfully, there should be a confirmation message
dimply in a popup. “Task has been created”
2. “The task name is not specified.” The message should display when the user did
not write the task title.
scenarios :
1. Verify users (HR, marketing, Helpdesk) create a task successfully
2. Verify users get a warning message for creating a task without a title.
 */