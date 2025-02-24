package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;


public class loginPage {

//    private WebDriver driver;

    WebDriver driver ;
    public loginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private By username = By.id("eliloUserID");
    private By password = By.id("pasword");
    private By loginButton = By.id("login");

    public void enterUsername(String name) {
        driver.findElement(username).sendKeys(name);
    }

    public void enterPassword(String password) {
        driver.findElement(this.password).sendKeys(password);

    }

//    public void clickLoginButton() {
//
//    }


}
