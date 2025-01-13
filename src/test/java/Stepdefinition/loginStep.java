package Stepdefinition;

import Hook.Hook;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.loginPage;

public class loginStep {

    WebDriver driver = Hook.getDriver();
    loginPage loginPage = new loginPage(driver);


    @Given("I am on the login page")
    public void i_am_on_the_login_page() {

        driver.get("https://www.americanexpress.com/en-us/account/login/");

    }
    @When("I enter my username and password")
    public void i_enter_my_username_and_password() {
        loginPage.enterUsername("Golf Wuttikrai");

    }
    @Then("I should be logged in")
    public void i_should_be_logged_in() {

    }

}
