package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShopMainPage {

    @FindBy(xpath = "//span[text()='Products']")
    private WebElement shopMainPageHeading;

    @FindBy(xpath = "//select")
    private WebElement sortField;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> shopItemNames;

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

    public List<WebElement> getShopItemNames() {
        return shopItemNames;
    }

}
