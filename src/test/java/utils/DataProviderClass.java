package utils;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "login-data")
    public static Object[][] loginData() {

        String errorInvalidData = "Epic sadface: Username and password do not match any user in this service";
        String errorNoUsername = "Epic sadface: Username is required";
        String errorNoPassword = "Epic sadface: Password is required";
        String errorBlockedUser = "Epic sadface: Sorry, this user has been locked out.";

        String validUsername = "standard_user";
        String validPassword = "secret_sauce";

        return new Object[][]{{"random_user", "random_sauce", errorInvalidData},
                {"", validPassword, errorNoUsername},
                {validUsername, "", errorNoPassword},
                {"locked_out_user", validPassword, errorBlockedUser}};
    }
}
