package logic.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class PendingEventsPage extends BasePage{
    private MobileElement event;

    public PendingEventsPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
    public String getEventName(String eventName){
        event = scrollDownToElement(eventName);
        return event.getText();
    }
    public void clickEventByName(String eventName){
        event= scrollDownToElement(eventName);
        event.click();
    }
}
