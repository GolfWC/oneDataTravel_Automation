package Hook;

import Util.ScreenshotUtil;
import com.saucelabs.saucerest.DataCenter;
import com.saucelabs.saucerest.SauceREST;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.loginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Logger;


public class Hook {
    public static WebDriver driver;
    Logger log = Logger.getLogger(Hook.class.getName());
    Properties properties = new Properties();

    @Before
    public void setUp() throws MalformedURLException, IOException {
        System.out.println("Initializing the browser...");
        String runEnv = "sauceLabs";
           //     "sauceLabs";
        String propertiesFile = "src/test/resources/" + runEnv + ".properties";
        properties.load(new FileInputStream(propertiesFile));

        if ("sauceLabs".equalsIgnoreCase(runEnv)) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", properties.getProperty("browser"));
            capabilities.setCapability("platformName", properties.getProperty("platform"));
            capabilities.setCapability("browserVersion", "latest");
            capabilities.setCapability("sauce:options", new HashMap<String, Object>());

            driver = new RemoteWebDriver(new URL(properties.getProperty("sauce.url")), capabilities);
        } else {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
    }

    @AfterStep
    public void takeScreenshotAfterStep(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "Screenshot");
        String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
        scenario.log("Sauce Labs Session ID: " + sessionId);
        scenario.log("Sauce Labs Video: https://app.saucelabs.com/tests/" + sessionId);
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Closing the browser...");
        if (driver != null) {
            String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
            SauceREST sauceREST = new SauceREST(properties.getProperty("sauce.username"), properties.getProperty("sauce.accessKey"), DataCenter.US_WEST);
            scenario.log("Sauce Labs Video: https://app.saucelabs.com/tests/" + sessionId);
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
