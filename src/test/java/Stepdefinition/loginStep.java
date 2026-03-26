package Stepdefinition;

import Hook.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.loginPage;

import java.util.List;

public class loginStep {

    WebDriver driver = Hook.getDriver();
    loginPage loginPage = new loginPage(driver);


    @Given("I am on ebay website")
    public void i_am_on_ebay_website() {
        driver.get("https://www.ebay.com/");
    }


}


