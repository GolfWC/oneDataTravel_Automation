package Hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.loginPage;

import java.util.logging.Logger;


public class Hook {
    public static WebDriver driver;
    Logger log = Logger.getLogger(Hook.class.getName());

    @Before
    public void setUp() {
        System.out.println("Initializing the browser...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);

    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Closing the browser...");


           if (scenario.isFailed()) {
            //  final byte[] screenshot = ((TakesScreenshot) Testbase.driver).getScreenshotAs(OutputType.BYTES);
               try{
                   log.info(scenario.getName() + " is failed");
               final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
               scenario.attach(screenshot, "image/png", scenario.getName());
                }catch (Exception e){
                     e.printStackTrace();
                }
           } else {
               try{
                   log.info(scenario.getName() + " is passed");
                     final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                        scenario.attach(screenshot, "image/png", scenario.getName());
               }catch (Exception e){
                   e.printStackTrace();
               }
           }
           if (driver != null) {
            driver.quit();
        }

    }

    public static WebDriver getDriver() {
        return driver;
    }

}
