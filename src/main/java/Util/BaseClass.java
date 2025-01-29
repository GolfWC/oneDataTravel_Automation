package Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    private static final Logger log = LoggerFactory.getLogger(BaseClass.class);
    public static WebDriver driver;
    public BaseClass(WebDriver driver) {
        BaseClass.driver = driver;
    }
    Properties properties = new Properties();

    public String getProperties(String key) {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/environment.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }

    public void switchToWindow(String expectedWindowTitle) {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(expectedWindowTitle)) {
                return;
            }
        }
        throw new RuntimeException("Window with title '" + expectedWindowTitle + "' not found.");
    }

    public void switchToWindow() {
        for (String handle : driver.getWindowHandles()) {
            System.out.println("Window handle: " + handle);
            driver.switchTo().window(handle);
        }
    }

    public void switchToPopUpWindow() {
        String mainWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void closePopUpWindow() {
        driver.close();
        driver.switchTo().defaultContent();
    }

    public void closeAllPopUpWindows() {
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            driver.close();
        }
        driver.switchTo().defaultContent();
    }

    public void switchToFrame(String frameName) {
        driver.switchTo().frame(frameName);
    }

    public void switchToFrame(int frameIndex) {
        driver.switchTo().frame(frameIndex);
    }

    public void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    public void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void moveToElementAndClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void moveToElementAndDoubleClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).doubleClick().perform();
    }

    public void moveToElementAndRightClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).contextClick().perform();
    }

    public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement, targetElement).perform();
    }

    public void dragAndDropByOffset(WebElement sourceElement, int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(sourceElement, xOffset, yOffset).perform();
    }

    public void clickAndHold(WebElement element) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).perform();
    }

    public void release(WebElement element) {
        Actions actions = new Actions(driver);
        actions.release(element).perform();
    }

    public void doubleClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public void rightClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public void scrollIntoView(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void scrollDown() {
        Actions actions = new Actions(driver);
        actions.click().build().perform();
    }

    public void scrollUp() {
        Actions actions = new Actions(driver);
        actions.click().build().perform();
    }

    public void scrollRight() {
        Actions actions = new Actions(driver);
        actions.click().build().perform();
    }

    public void scrollLeft() {
        Actions actions = new Actions(driver);
        actions.click().build().perform();
    }

    public void scrollBy(int x, int y) {
        Actions actions = new Actions(driver);
        actions.moveByOffset(x, y).perform();
    }

    public void zoomIn() {
        Actions actions = new Actions(driver);
        actions.click().build().perform();
    }

    public void zoomOut() {
        Actions actions = new Actions(driver);
        actions.click().build().perform();
    }

    public void clickAndDrag(WebElement sourceElement, WebElement targetElement) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(sourceElement).moveToElement(targetElement).release().perform();
    }

    public void clickAndDragByOffset(WebElement sourceElement, int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(sourceElement).moveByOffset(xOffset, yOffset).release().perform();
    }

    public void clickAndDragByOffset(WebElement sourceElement, int xOffset, int yOffset, int times) {
        Actions actions = new Actions(driver);
        for (int i = 0; i < times; i++) {
            actions.clickAndHold(sourceElement).moveByOffset(xOffset, yOffset).release().perform();
        }
    }

    public void clickAndDragByOffset(WebElement sourceElement, int xOffset, int yOffset, int times, int delay) {
        Actions actions = new Actions(driver);
        for (int i = 0; i < times; i++) {
            actions.clickAndHold(sourceElement).moveByOffset(xOffset, yOffset).pause(delay).release().perform();
        }
    }

    public void clickAndDragByOffset(WebElement sourceElement, int xOffset, int yOffset, int times, int delay, int pause) {
        Actions actions = new Actions(driver);
        for (int i = 0; i < times; i++) {
            actions.clickAndHold(sourceElement).moveByOffset(xOffset, yOffset).pause(delay).release().pause(pause).perform();
        }
    }

    public void clickAndDragByOffset(WebElement sourceElement, int xOffset, int yOffset, int times, int delay, int pause, int release) {
        Actions actions = new Actions(driver);
        for (int i = 0; i < times; i++) {
            actions.clickAndHold(sourceElement).moveByOffset(xOffset, yOffset).pause(delay).release().pause(pause).perform();
        }
    }


    public void selectByVisibleText(WebElement element, String text) {
       Select select = new Select(element);
         select.selectByVisibleText(text);
    }

    public void selectByIndex(WebElement element, int index) {
       Select select = new Select(element);
         select.selectByIndex(index);
    }

    public void selectByValue(WebElement element, String value) {
       Select select = new Select(element);
         select.selectByValue(value);
    }

    public void deselectByVisibleText(WebElement element, String text) {
       Select select = new Select(element);
         select.deselectByVisibleText(text);
    }

    public void deselectByIndex(WebElement element, int index) {
       Select select = new Select(element);
         select.deselectByIndex(index);
    }

    public void deselectByValue(WebElement element, String value) {
       Select select = new Select(element);
         select.deselectByValue(value);
    }

    public void deselectAll(WebElement element) {
       Select select = new Select(element);
         select.deselectAll();
    }

    public void getFirstSelectedOption(WebElement element) {
       Select select = new Select(element);
         select.getFirstSelectedOption();
    }

    public void getAllSelectedOptions(WebElement element) {
       Select select = new Select(element);
         select.getAllSelectedOptions();
    }

    public void enterText(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }







}
