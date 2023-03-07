package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.YourCartPage;

public class RemoveFromCartTest extends BaseTest {

    private User user = new User("standard_user", "secret_sauce");

    @Test
    public void removeFromCartTest() {

        YourCartPage yourCartPage = new LoginPage(driver)
                .loginWithValidData(user.getUsername(), user.getPassword())
                .addToCart()
                .removeBackpackFromCart();

        Assert.assertTrue(yourCartPage.checkEmptyCart());
    }
}
