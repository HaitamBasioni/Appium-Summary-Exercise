package logic.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;
    public BasePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);

    }
    public MobileElement waitToVisible(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("NoSuchElementException: " + e.getMessage());
        } catch (TimeoutException e) {
            throw new TimeoutException("TimeoutException: " + e.getMessage());
        }
    }
    public MobileElement waitForElementWithText(String text) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + text + "\")")
        ));

        return (MobileElement) webElement;
    }

    public MobileElement  scrollDownToElement( String elementText) {
        MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"" + elementText + "\"));"
        ));
        return element;
    }
    public MobileElement findElementByIndex( int index){
        return driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().index(" + index + ")")).get(0);
    }
}
