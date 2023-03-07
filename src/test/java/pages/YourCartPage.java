package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBackpackButton;

    @FindBy(xpath = "//div[@class='cart_item']")
    private WebElement cartNotEmptyClass;

    private WebDriver driver;

    public YourCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CheckoutPage checkout() {
        checkoutButton.click();
        return new CheckoutPage(driver);
    }

    public YourCartPage removeBackpackFromCart() {
        removeBackpackButton.click();
        return this;
    }

    public boolean checkEmptyCart() {
        try {
            cartNotEmptyClass.getText();
        } catch (NoSuchElementException e) {
            return true;
        }
        return false;
    }
}
