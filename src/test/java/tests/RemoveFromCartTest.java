package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.YourCartPage;

import java.util.Optional;

public class RemoveFromCartTest extends BaseTest {

    private User user = new User("standard_user", "secret_sauce");
    @Test
    public void removeFromCartTest(){

        YourCartPage yourCartPage = new LoginPage(driver)
                .loginWithValidData(user.getUsername(), user.getPassword())
                .addToCart()
                        .removeBackpackFromCart();

                //.removeBackpackFromCart();
        System.out.println(driver.findElement(By.xpath("//div[@class='cart_item']")).isDisplayed());

    }


}
