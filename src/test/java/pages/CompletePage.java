package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletePage {

    @FindBy(xpath = "//h2")
    WebElement finishHeading;

    private WebDriver driver;

    public CompletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getFinishHeading() {
        return finishHeading;
    }
}
