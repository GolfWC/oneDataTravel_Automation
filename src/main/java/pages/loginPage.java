package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

    private WebDriver driver;


//    public loginPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, loginPage.class);
//    }

    private By username = By.id("//*[@id=\"APjFqb\"]");
    private By password = By.id("password");
    private By loginButton = By.id("login");

    public void enterUsername(String username) {
        driver.findElement(this.username).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(username).sendKeys("Test Automation");

    }

}
