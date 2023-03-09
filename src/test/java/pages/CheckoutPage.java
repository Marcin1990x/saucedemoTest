package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ScreenshotMaker;

import java.io.IOException;

public class CheckoutPage {

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueButton;
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CheckoutOverviewPage completeForm(String firstName, String lastName, String postalCode, ExtentTest test) throws IOException {
        test.log(Status.INFO, "Completing form stage.");
        firstNameInput.sendKeys(firstName);
        test.log(Status.PASS, "First Name passed.");
        lastNameInput.sendKeys(lastName);
        test.log(Status.PASS, "Last Name passed.");
        postalCodeInput.sendKeys(postalCode);
        test.log(Status.PASS, "Postal Code passed.", ScreenshotMaker.getScreenshot(driver));
        continueButton.click();
        return new CheckoutOverviewPage(driver);
    }
}