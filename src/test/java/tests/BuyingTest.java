package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutOverviewPage;
import pages.CompletePage;
import pages.LoginPage;

public class BuyingTest extends BaseTest {

    private User user = new User("standard_user", "secret_sauce");

    @Test
    public void buyingTest() {

        CompletePage completePage = new LoginPage(driver)
                .loginWithValidData(user.getUsername(), user.getPassword())
                .addToCart()
                .checkout()
                .completeForm(user.getFirstName(), user.getLastName(), user.getPostalCode())
                .finishBuying();

        Assert.assertTrue(completePage.getFinishHeading().isDisplayed());
        Assert.assertEquals(completePage.getFinishHeading().getText(), "Thank you for your order!");
    }

    @Test
    public void buyingTestWithChecks() {

        CheckoutOverviewPage checkoutOverviewPage = new LoginPage(driver)
                .loginWithValidData(user.getUsername(), user.getPassword())
                .addToCart()
                .checkout()
                .completeForm(user.getFirstName(), user.getLastName(), user.getPostalCode());

        Assert.assertEquals(checkoutOverviewPage.getBoughtProduct().getText(), "Sauce Labs Backpack");
        Assert.assertEquals(checkoutOverviewPage.getTotalPriceWithoutTax().getText().substring(13), "29.99");
    }
}
