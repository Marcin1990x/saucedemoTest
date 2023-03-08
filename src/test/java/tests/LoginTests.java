package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ShopMainPage;
import utils.DataProviderClass;

public class LoginTests extends BaseTest {

    private User user = new User("standard_user", "secret_sauce");

    @Test
    private void loginTestValidData() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.putUsername(user.getUsername());
        loginPage.putPassword(user.getPassword());
        ShopMainPage shopMainPage = loginPage.clickLoginButton2();

        Assert.assertEquals(shopMainPage.getShopMainPageHeading().getText(), "Products");
    }

    @Test(dataProvider = "login-data", dataProviderClass = DataProviderClass.class)
    private void loginTestInValidData(String username, String password, String assertText) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.putUsername(username);
        loginPage.putPassword(password);
        loginPage.clickLoginButton();

        //invalid data // without username // without password // blocked user
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), assertText);
    }
}
