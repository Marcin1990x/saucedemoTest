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

    @FindBy(xpath = "//div[text()='Swag Labs']")
    private WebElement mainHeading;

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

    public void putUsername(String username) {
        usernameInputField.sendKeys(username);
    }

    public void putPassword(String password) {
        passwordInputField.sendKeys(password);
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public ShopMainPage clickLoginButton2() {
        loginButton.click();
        return new ShopMainPage(driver);
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public WebElement getMainHeading() {
        return mainHeading;
    }


}
