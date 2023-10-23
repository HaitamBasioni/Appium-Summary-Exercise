package logic.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class EditEventPage extends BasePage{
    //locators
    private final By DELETE = By.id("com.claudivan.taskagenda:id/item_excluir");
    private final By SURE_TO_DELETE = By.id("android:id/button1");
    private final By TEXT_NO_EVENTS = By.id("com.claudivan.taskagenda:id/txt");
    private final By EDIT_EVENT = By.id("com.claudivan.taskagenda:id/item_editar");
    private final By EVENT_TITLE= By.id("com.claudivan.taskagenda:id/tvTitulo");
    private final By EVENT_TIME = By.id("com.claudivan.taskagenda:id/tvHora");
    private final By EVENT_DATE= By.id("com.claudivan.taskagenda:id/tvData");
    private final By DATE = By.id("com.claudivan.taskagenda:id/btData");
    private final By TASK_TYPE = By.id("com.claudivan.taskagenda:id/tvTipo");

    //Mobile elements
    private MobileElement delete;
    private MobileElement sureToDelete;
    private MobileElement textNoEvent ;
    private MobileElement editEvent;
    private MobileElement eventTittle;
    private MobileElement eventTime;
    private MobileElement eventDate;
    private MobileElement date;
    private MobileElement calenderDay;
    private MobileElement taskType;
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
    public void clickEdit(){
        editEvent= waitToVisible(EDIT_EVENT);
        editEvent.click();
    }
    public String getEventTittle(){
        eventTittle= waitToVisible(EVENT_TITLE);
        return eventTittle.getText();
    }
    public String getEventTime(){
        eventTime = waitToVisible(EVENT_TIME);
        return eventTime.getText();
    }
    public  void  choseDate(int day){
        date = waitToVisible(DATE);
        date.click();
        sureToDelete= waitToVisible(SURE_TO_DELETE);
        sureToDelete.click();
        calenderDay = waitForElementWithText((String.valueOf(day)));
        calenderDay.click();
        sureToDelete= waitToVisible(SURE_TO_DELETE);
        sureToDelete.click();
    }
    public String getEventDate(){
        eventDate = waitToVisible(EVENT_DATE);
        return eventDate.getText();
    }
    public String getTaskType(){
        taskType=waitToVisible(TASK_TYPE);
        return taskType.getText();
    }


}
