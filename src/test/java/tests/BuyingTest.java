package tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutOverviewPage;
import pages.CompletePage;
import pages.LoginPage;

import java.io.IOException;

public class BuyingTest extends BaseTest {

    private User user = new User("standard_user", "secret_sauce");

    @Test
    public void buyingTest() throws IOException {


        ExtentTest test = extentReports.createTest("Buying test.");

        CompletePage completePage = new LoginPage(driver)
                .loginWithValidData(user.getUsername(), user.getPassword(), test)
                .addToCart(test)
                .checkout(test)
                .completeForm(user.getFirstName(), user.getLastName(), user.getPostalCode(), test)
                .finishBuying(test);

        boolean finishHeadingIsDisplayed = completePage.getFinishHeading().isDisplayed();
        boolean finishHeadingCompletion = completePage.getFinishHeading().getText().equals("Thank you for your order!");

        if (!finishHeadingIsDisplayed)
            test.log(Status.FAIL, "Something went wrong");
        Assert.assertTrue(finishHeadingIsDisplayed);
        if (!finishHeadingCompletion)
            test.log(Status.FAIL, "Something went wrong");
        Assert.assertTrue(finishHeadingCompletion);

        test.log(Status.PASS, "Buying test passed.");
    }

    @Test
    public void buyingTestWithChecks() throws IOException {

        ExtentTest test = extentReports.createTest("Buying test with product name and price check.");

        CheckoutOverviewPage checkoutOverviewPage = new LoginPage(driver)
                .loginWithValidData(user.getUsername(), user.getPassword(), test)
                .addToCart(test)
                .checkout(test)
                .completeForm(user.getFirstName(), user.getLastName(), user.getPostalCode(), test);

        Assert.assertEquals(checkoutOverviewPage.getBoughtProduct().getText(), "Sauce Labs Backpack");
        Assert.assertEquals(checkoutOverviewPage.getTotalPriceWithoutTax().getText().substring(13), "29.99");
    }
}
