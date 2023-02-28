package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

public class BaseTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        driver = DriverFactory.getDriver("chrome");
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown()
    {
        //driver.quit();
    }
}
