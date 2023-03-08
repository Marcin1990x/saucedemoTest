package utils;

public class DataProviderClass {

    private String invalidDataError = "Epic sadface: Username and password do not match any user in this service";
    @org.testng.annotations.DataProvider(name = "login-data")
    public static Object[][] loginData(){
        return new Object[][]{{"standard_user", "secret_sauce", "Products"},
                {}
        };
    }
}
