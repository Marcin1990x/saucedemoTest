package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    private User user = new User("standard_user", "secret_sauce");

    @Test
    public void logoutTest() {

        LoginPage loginPage = new LoginPage(driver)
                .loginWithValidData(user.getUsername(), user.getPassword())
                .logout();

        Assert.assertTrue(loginPage.getMainHeading().isDisplayed());
        Assert.assertEquals(loginPage.getMainHeading().getText(), "Swag Labs");
    }
}
