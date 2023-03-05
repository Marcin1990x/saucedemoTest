package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement totalPriceWithoutTax;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement boughtProduct;


    private WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CompletePage finishBuying() {
        finishButton.click();
        return new CompletePage(driver);
    }

    public WebElement getTotalPriceWithoutTax() {
        return totalPriceWithoutTax;
    }

    public WebElement getBoughtProduct() {
        return boughtProduct;
    }
}
