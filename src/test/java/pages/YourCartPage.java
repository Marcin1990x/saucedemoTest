package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    private WebDriver driver;

    public YourCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CheckoutPage checkout() {
        checkoutButton.click();
        return new CheckoutPage(driver);
    }
}
