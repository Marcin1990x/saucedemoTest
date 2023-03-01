package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement usernameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ShopMainPage loginWithValidData(String username, String password) {
        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        loginButton.click();
        return new ShopMainPage(driver);
    }

    public LoginPage loginWithInValidData(String username, String password) {
        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        loginButton.click();
        return this;
    }

    public LoginPage loginWithoutUsername(String password) {
        passwordInputField.sendKeys(password);
        loginButton.click();
        return this;
    }

    public LoginPage loginWithoutPassword(String username) {
        usernameInputField.sendKeys(username);
        loginButton.click();
        return this;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }


}
