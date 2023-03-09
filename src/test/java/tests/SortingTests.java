package tests;

import com.aventstack.extentreports.ExtentTest;
import models.User;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ShopMainPage;
import utils.Sorting;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SortingTests extends BaseTest {

    private String[] sortSelectors = {"Name (A to Z)", "Name (Z to A)", "Price (low to high)", "Price (high to low)"};

    private int sortType = 3; // Choose sort type according to sortSelectors tab.

    private User user = new User("standard_user", "secret_sauce");

    @Test
    private void sortTest() throws IOException {

        ExtentTest test = extentReports.createTest("Sorting products test.");

        ShopMainPage shopMainPage = new LoginPage(driver)
                .loginWithValidData(user.getUsername(), user.getPassword(), test)
                .filterProducts(sortSelectors[sortType]);

        //Get product names
        List<String> shopItemNames = shopMainPage.getShopItemNames().stream()
                .map(WebElement::getText).collect(Collectors.toList());

        //Get product prices
        List<String> shopItemPrices = shopMainPage.getShopItemPrices().stream()
                .map(WebElement::getText)
                .map(price -> price.replace("$", ""))
                .collect(Collectors.toList());

        switch (sortType) {
            case 0:
                Assert.assertEquals(Sorting.sort(shopItemNames, 0), shopItemNames);
                break;
            case 1:
                Assert.assertEquals(Sorting.sort(shopItemNames, 1), shopItemNames);
                break;
            case 2:
                Assert.assertEquals(Sorting.sort(shopItemPrices, 2), shopItemPrices);
                break;
            case 3:
                Assert.assertEquals(Sorting.sort(shopItemPrices, 3), shopItemPrices);
                break;
        }
    }
}
