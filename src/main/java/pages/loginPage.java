package pages;

import Util.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;


public class loginPage extends  BaseClass {

//    private WebDriver driver;

    WebDriver driver ;
    public loginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private By username = By.xpath("//*[@id=\"loginControl\"]/div[3]/input");
    private By password = By.xpath("//*[@id=\"loginControl\"]/div[5]/input");
    private By loginButton = By.xpath("//*[@id=\"loginControl\"]/div[9]/button");

    public void enterUsername(String name) throws InterruptedException {

        driver.findElement(username).sendKeys(name);
    }

    public void enterPassword(String password) {
        driver.findElement(this.password).sendKeys(password);

    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}
