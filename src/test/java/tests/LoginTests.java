package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ShopMainPage;

public class LoginTests extends BaseTest {

    private String invalidDataError = "Epic sadface: Username and password do not match any user in this service";

    @Test
    private void loginTestValidData() {
        ShopMainPage shopMainPage = new LoginPage(driver)
                .loginWithValidData(User.getUsername(), User.getPassword());

        Assert.assertEquals(shopMainPage.getShopMainPageHeading().getText(), "Products");
    }

    @Test
    private void loginTestInValidData() {

        User.setUsername("random_username");
        User.setPassword("random_password");

        LoginPage loginPage = new LoginPage(driver)
                .loginWithInValidData(User.getUsername(), User.getPassword());

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), invalidDataError);
    }

    @Test
    private void loginTestWithoutUsername() {
        LoginPage loginPage = new LoginPage(driver)
                .loginWithoutUsername(User.getPassword());

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), "Epic sadface: Username is required");
    }

    @Test
    private void loginTestWithoutPassword() {
        LoginPage loginPage = new LoginPage(driver)
                .loginWithoutPassword(User.getUsername());

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), "Epic sadface: Password is required");
    }

    @Test
    private void loginTestBlockedUser() {

        User.setUsername("locked_out_user");

        LoginPage loginPage = new LoginPage(driver)
                .loginWithInValidData(User.getUsername(), User.getPassword());

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
