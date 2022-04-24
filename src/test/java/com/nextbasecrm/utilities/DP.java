package com.nextbasecrm.utilities;

import org.testng.annotations.DataProvider;

public class DP {

    @DataProvider(name = "User Credentials")
    public static Object[][] provideData() {
        return new Object[][]{
                {"hr79@cydeo.com", "UserUser"},
                // {"hr80@cydeo.com", "UserUser"},
                // {"hr81@cydeo.com", "UserUser"},
                {"helpdesk79@cydeo.com", "UserUser"},
                // {"helpdesk80@cydeo.com", "UserUser"},
                //  {"helpdesk81@cydeo.com", "UserUser"},
                {"marketing79@cydeo.com", "UserUser"}//,
                //  {"marketing80@cydeo.com", "UserUser"},
                //  {"marketing81@cydeo.com", "UserUser"}
        };
    }


    @DataProvider(name = "User Credentials Login Functionality")
    public static Object[][] provideDataForLoginFunctionality() {
        return new Object[][]{
                {"hr79@cydeo.com", "UserUser"},
                {"hr80@cydeo.com", "UserUser"},
                {"hr81@cydeo.com", "UserUser"},
                {"helpdesk79@cydeo.com", "UserUser"},
                {"helpdesk80@cydeo.com", "UserUser"},
                {"helpdesk81@cydeo.com", "UserUser"},
                {"marketing79@cydeo.com", "UserUser"},
                {"marketing80@cydeo.com", "UserUser"},
                {"marketing81@cydeo.com", "UserUser"}
        };
    }


}
