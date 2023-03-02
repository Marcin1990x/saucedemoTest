package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ShopMainPage;

public class SortingTests extends BaseTest {

    private String[] sortSelectors = {"Name (A to Z)", "Name (Z to A)", "Price (low to high)", "Price (high to low)"};

    @Test
    public void sortTest() {
        System.out.println(sortSelectors);
        ShopMainPage shopMainPage = new LoginPage(driver)
                .loginWithValidData("standard_user", "secret_sauce")
                .filterProducts(sortSelectors[2]);

        /*List<String> test = shopMainPage.getShopItemNames().stream().map(WebElement::getText).collect(Collectors.toList());
        System.out.println(test);*/
    }
}
