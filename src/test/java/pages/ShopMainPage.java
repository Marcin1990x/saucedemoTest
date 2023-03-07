package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.SeleniumHelper;

import java.util.List;

public class ShopMainPage {

    @FindBy(xpath = "//span[text()='Products']")
    private WebElement shopMainPageHeading;

    @FindBy(xpath = "//select")
    private WebElement sortField;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> shopItemNames;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> shopItemPrices;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement productBackpack;

    @FindBy(id = "shopping_cart_container")
    private WebElement shopingCartButton;

    private WebDriver driver;

    public ShopMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getShopMainPageHeading() {
        return shopMainPageHeading;
    }

    public ShopMainPage filterProducts(String filterName) {
        Select select = new Select(sortField);
        select.selectByVisibleText(filterName);
        return this;
    }

    public LoginPage logout() {
        menuButton.click();
        SeleniumHelper.waitForElementToBeClickable(logoutButton, driver);
        logoutButton.click();
        return new LoginPage(driver);
    }

    public YourCartPage addToCart() {
        productBackpack.click();
        shopingCartButton.click();
        return new YourCartPage(driver);
    }

    public List<WebElement> getShopItemNames() {
        return shopItemNames;
    }

    public List<WebElement> getShopItemPrices() {
        return shopItemPrices;
    }
}
