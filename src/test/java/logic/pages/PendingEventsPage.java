package logic.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


public class PendingEventsPage extends BasePage{
    private final By EVENT_TITTLE = By.id("com.claudivan.taskagenda:id/tvTitulo");
    private MobileElement eventTitle;
    public PendingEventsPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
    public String getEventName(String eventName){
        eventTitle = scrollDownToElement(eventName);
        return eventTitle.getText();
    }
    public void clickEventByName(String eventName){
        eventTitle = scrollDownToElement(eventName);
        eventTitle.click();
    }
}
