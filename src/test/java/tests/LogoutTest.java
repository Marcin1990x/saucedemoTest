package tests;

import com.aventstack.extentreports.ExtentTest;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class LogoutTest extends BaseTest {

    private User user = new User("standard_user", "secret_sauce");

    @Test
    public void logoutTest() throws IOException {

        ExtentTest test = extentReports.createTest("Logout test.");

        LoginPage loginPage = new LoginPage(driver)
                .loginWithValidData(user.getUsername(), user.getPassword(), test)
                .logout();

        Assert.assertTrue(loginPage.getMainHeading().isDisplayed());
        Assert.assertEquals(loginPage.getMainHeading().getText(), "Swag Labs");
    }
}
