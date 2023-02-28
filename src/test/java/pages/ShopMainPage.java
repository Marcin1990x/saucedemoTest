package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopMainPage {

    @FindBy(xpath = "//span[text()='Products']")
    private WebElement shopMainPageHeading;

    private WebDriver driver;

    public ShopMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getShopMainPageHeading() {
        return shopMainPageHeading;
    }
}
