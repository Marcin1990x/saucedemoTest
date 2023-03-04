package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CompletePage;
import pages.LoginPage;

public class BuyingTest extends BaseTest {

    @Test
    public void buyingTest() {

        CompletePage completePage = new LoginPage(driver)
                .loginWithValidData(User.getUsername(), User.getPassword())
                .addToCart()
                .checkout()
                .completeForm(User.getFirstName(), User.getLastName(), User.getPostalCode())
                .finishBuying();

        Assert.assertTrue(completePage.getFinishHeading().isDisplayed());
        Assert.assertEquals(completePage.getFinishHeading().getText(), "Thank you for your order!");
    }
}
