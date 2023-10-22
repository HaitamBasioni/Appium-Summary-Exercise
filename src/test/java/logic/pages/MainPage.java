package logic.pages;

import enums.ChoosingDayEvent;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import logic.pages.BasePage;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    //locators
    private final By PLUS_SIGN_TO_ADD = By.id("com.claudivan.taskagenda:id/btNovoEvento") ;
    private final  By PENDING_EVENTS = By.id("com.claudivan.taskagenda:id/btEventosSemana");
    private final By ALLOW_NOTIFICATIONS = By.id("com.android.permissioncontroller:id/permission_allow_button");


    // mobile elements
    private MobileElement plusSignToAdd;
    private MobileElement today;
    private MobileElement tomorrow;
    private MobileElement other;
    private MobileElement pendingEvents;
    private MobileElement allowNotifications;


    public MainPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
    public void clickPlusSign(){
        plusSignToAdd=waitToVisible(PLUS_SIGN_TO_ADD);
        plusSignToAdd.click();
        today=waitForElementWithText(String.valueOf(ChoosingDayEvent.Today));
        tomorrow = waitForElementWithText(String.valueOf(ChoosingDayEvent.Tomorrow));
        other= waitForElementWithText(String.valueOf(ChoosingDayEvent.Other));
    }
    public  void  clickDayEvent(ChoosingDayEvent dayEvent){
        if (dayEvent== ChoosingDayEvent.Today)
            today.click();
        else if (dayEvent== ChoosingDayEvent.Tomorrow)
            tomorrow.click();
        else
            other.click();
    }
    public void clickPendingEvents(){
        pendingEvents= waitToVisible(PENDING_EVENTS);
        pendingEvents.click();
        allowNotifications= waitToVisible(ALLOW_NOTIFICATIONS);
        allowNotifications.click();
    }
}
