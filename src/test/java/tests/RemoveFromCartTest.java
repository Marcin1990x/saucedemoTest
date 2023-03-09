package tests;

import com.aventstack.extentreports.ExtentTest;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.YourCartPage;

import java.io.IOException;

public class RemoveFromCartTest extends BaseTest {

    private User user = new User("standard_user", "secret_sauce");

    @Test
    public void removeFromCartTest() throws IOException {

        ExtentTest test = extentReports.createTest("Remove from shopping cart test.");

        YourCartPage yourCartPage = new LoginPage(driver)
                .loginWithValidData(user.getUsername(), user.getPassword(), test)
                .addToCart(test)
                .removeBackpackFromCart();

        Assert.assertTrue(yourCartPage.checkEmptyCart());
    }
}
