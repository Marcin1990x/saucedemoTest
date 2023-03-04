package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {

    @FindBy(id = "finish")
    private WebElement finishButton;

    private WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CompletePage finishBuying() {
        finishButton.click();
        return new CompletePage(driver);
    }
}
