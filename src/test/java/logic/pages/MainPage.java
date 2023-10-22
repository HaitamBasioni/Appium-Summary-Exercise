package logic.pages;

import enums.ChoosingDayEvent;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import logic.pages.BasePage;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    //locators
    private final By PLUS_SIGN_TO_ADD = By.id("com.claudivan.taskagenda:id/btNovoEvento") ;

    // mobile elements
    private MobileElement plusSignToAdd;
    private MobileElement today;
    private MobileElement tomorrow;
    private MobileElement other;



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
}
