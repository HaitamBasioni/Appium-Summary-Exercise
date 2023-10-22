package logic.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class EditEventPage extends BasePage{
    //locators
    private final By DELETE = By.id("com.claudivan.taskagenda:id/item_excluir");
    private final By SURE_TO_DELETE = By.id("android:id/button1");
    private final By TEXT_NO_EVENTS = By.id("com.claudivan.taskagenda:id/txt");

    //Mobile elements
    private MobileElement delete;
    private MobileElement sureToDelete;
    private MobileElement textNoEvent ;
    public EditEventPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
    public void deleteEvent(){
        delete= waitToVisible(DELETE);
        delete.click();
        sureToDelete = waitToVisible(SURE_TO_DELETE);
        sureToDelete.click();
        sureToDelete = waitToVisible(SURE_TO_DELETE);
        sureToDelete.click();
    }
    public boolean isEventDeleted(){
        textNoEvent = waitToVisible(TEXT_NO_EVENTS);
        return  textNoEvent.isDisplayed();
    }


}
