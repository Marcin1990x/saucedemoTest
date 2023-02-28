package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ShopMainPage;

public class LoginTests extends BaseTest {

    @Test
    public void loginTestValidData() {
        ShopMainPage loginPage = new LoginPage(driver)
                .loginWithValidData("standard_user", "secret_sauce");

        Assert.assertEquals(loginPage.getShopMainPageHeading().getText(), "Products");
    }
}
