package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ShopMainPage;
import utils.DataProviderClass;

public class LoginTests extends BaseTest {

    private String invalidDataError = "Epic sadface: Username and password do not match any user in this service";

    private User user = new User("standard_user", "secret_sauce");

    @Test
    private void loginTestValidData() {

        ShopMainPage shopMainPage = new LoginPage(driver)
                .loginWithValidData(user.getUsername(), user.getPassword());

        Assert.assertEquals(shopMainPage.getShopMainPageHeading().getText(), "Products");
    }

    @Test(dataProvider = "login-data", dataProviderClass = DataProviderClass.class)
    private void loginTestInValidData() {

        User user1 = new User("random_user", "random_sauce");

        LoginPage loginPage = new LoginPage(driver)
                .loginWithInValidData(user1.getUsername(), user1.getPassword());

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), invalidDataError);
    }

    @Test
    private void loginTestWithoutUsername() {

        LoginPage loginPage = new LoginPage(driver)
                .loginWithoutUsername(user.getPassword());

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), "Epic sadface: Username is required");
    }

    @Test
    private void loginTestWithoutPassword() {

        LoginPage loginPage = new LoginPage(driver)
                .loginWithoutPassword(user.getUsername());

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), "Epic sadface: Password is required");
    }

    @Test
    private void loginTestBlockedUser() {

        User userBlocked = new User("locked_out_user", "secret_sauce");

        LoginPage loginPage = new LoginPage(driver)
                .loginWithInValidData(userBlocked.getUsername(), userBlocked.getPassword());

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
