package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ShopMainPage;

public class LoginTests extends BaseTest {

    private String invalidDataError = "Epic sadface: Username and password do not match any user in this service";

    @Test
    private void loginTestValidData() {
        ShopMainPage shopMainPage = new LoginPage(driver)
                .loginWithValidData("standard_user", "secret_sauce");

        Assert.assertEquals(shopMainPage.getShopMainPageHeading().getText(), "Products");
    }

    @Test
    private void loginTestInValidData() {
        LoginPage loginPage = new LoginPage(driver)
                .loginWithInValidData("random_username", "random_password");

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), invalidDataError);
    }

    @Test
    private void loginTestWithoutUsername() {
        LoginPage loginPage = new LoginPage(driver)
                .loginWithoutUsername("secret_sauce");

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), "Epic sadface: Username is required");
    }

    @Test
    private void loginTestWithoutPassword() {
        LoginPage loginPage = new LoginPage(driver)
                .loginWithoutPassword("standard_user");

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), "Epic sadface: Password is required");
    }
}
