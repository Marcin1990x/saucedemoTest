package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        LoginPage loginPage = new LoginPage(driver)
                .loginWithValidData("standard_user", "secret_sauce")
                .logout();

        Assert.assertTrue(loginPage.getMainHeading().isDisplayed());
        Assert.assertEquals(loginPage.getMainHeading().getText(), "Swag Labs");
    }
}
