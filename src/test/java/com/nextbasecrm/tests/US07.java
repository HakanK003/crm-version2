package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.DP;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US07 extends TestBase {


    @Test(dataProvider = "User Credentials", dataProviderClass = DP.class)
    public void users_Vote_for_poll_with_one_answer(String username, String password) throws InterruptedException {

        CRM_Utilities.crm_login(driver, username, password);

        //type "vote" in search box near to Activity Stream, press Enter button
        driver.findElement(By.xpath("//input[@id='LIVEFEED_search']")).sendKeys("poll" + Keys.ENTER);

        Thread.sleep(1000);

        if (driver.findElement(By.xpath("//button[.='Vote again']")).isDisplayed()) {

            driver.findElement(By.xpath("//button[.='Vote again']")).click();

            Thread.sleep(1000);
        }


        //Select one of the options on poll and check if there an ability to select more than one option

        WebElement firstFoundRadioBtn = driver.findElement(By.xpath("//label[contains (@for, 'vote_radio')]"));

        firstFoundRadioBtn.click();

        Thread.sleep(1000);


        // Click "Vote" button
        WebElement firstFoundVoteBtn = driver.findElement(By.xpath("//button[contains (@class, 'btn-primary')]"));

        firstFoundVoteBtn.click();

        Thread.sleep(1000);

        //Poll should be successfully submitted with "Vote again" message under poll options.
        Assert.assertTrue(driver.findElement(By.xpath("//button[.='Vote again']")).isDisplayed());

    }


    @Test(dataProvider = "User Credentials", dataProviderClass = DP.class)
    public void users_vote_for_a_poll_without_any_answer(String username, String password) throws InterruptedException {

        CRM_Utilities.crm_login(driver, username, password);

        //Clicking poll button to be able to see poll creation option
        WebElement pollBtn = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-vote']/span"));

        pollBtn.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));

        Thread.sleep(1000);

        //Entering the theme message of our poll
        WebElement themeMessageOfPoll = driver.findElement(By.xpath("/html/body"));
        themeMessageOfPoll.sendKeys("Test poll functionality107");

        driver.switchTo().parentFrame();

        //Creating poll Question, and two available options(answers)
        driver.findElement(By.xpath("//*[@id='question_0']")).sendKeys("Front end or back end?1" + Keys.TAB + "Front end1" + Keys.TAB + "Back end1");

        //clicking "send" button
        WebElement sendButton = driver.findElement(By.xpath("//*[@id='blog-submit-button-save']"));
        sendButton.click();

        Thread.sleep(2000);

        //Click "vote'" button without selecting any option
        WebElement firstFoundVoteBtn = driver.findElement(By.xpath("//button[contains (@class, 'btn-primary')]"));

        firstFoundVoteBtn.click();

        //system should display error message on a top of the poll - "No poll data found."
        WebElement errorMessage = driver.findElement(By.xpath("//div[.='No poll data found.']"));
        Assert.assertTrue(errorMessage.isDisplayed());

    }


}

/*
Story 7:
As a user, I want to vote for a poll with one answer.
Acceptance Criteria:
1. Users can select one answer and click the “VOTE” button to vote for a poll.
scenarios :
1. Verify users (HR, marketing, Helpdesk) successfully vote for a poll.
 */