package logic.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import logic.pages.BasePage;
import org.openqa.selenium.By;

public class NewEventPage extends BasePage {
    //locators
    private final By EVENT_NAME = By.id("com.claudivan.taskagenda:id/etTitulo");
    private final By DATE = By.id("com.claudivan.taskagenda:id/btData");
    private final By OK_BUTTON = By.id("android:id/button1");
    private final By TIME = By.id("com.claudivan.taskagenda:id/btHora");
    private final By TIME_KEYBOARD_SIGN = By.id("android:id/toggle_mode");
    private final By HOURS_INPUT= By.id("android:id/input_hour");
    private final By MINUTES_INPUT = By.id("android:id/input_minute");
    private final By CHOSE_AM_PM = By.id("android:id/am_pm_spinner");
    private final By REPEAT = By.id("com.claudivan.taskagenda:id/btRepetirTexto");
    private final By TASK = By.id("com.claudivan.taskagenda:id/vgItemEtiqueta");
    private final By DESCRIPTION_INPUT = By.id("com.claudivan.taskagenda:id/etDescricao");
    private final By SAVE_BUTTON = By.id("com.claudivan.taskagenda:id/item_salvar");

    //MOBILE ELEMENTS
    private  MobileElement eventName ;
    private MobileElement date;
    private MobileElement okButton;
    private MobileElement calenderDay;
    private MobileElement time;
    private MobileElement timeKeyBoardSign;
    private MobileElement hoursINPUT;
    private MobileElement minutesInput;
    private MobileElement choseAMpm;
    private MobileElement amOrPmElement ;
    private MobileElement repeat;
    private MobileElement whenToRepeat;
    private MobileElement task;
    private MobileElement taskType;
    private MobileElement descriptionInput;
    private MobileElement saveButton;
    public NewEventPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
    public void inputTitle(String title){
        eventName = waitToVisible(EVENT_NAME);
        eventName.clear();
        eventName.sendKeys(title);
    }

    public  void  choseDate(int day){
        date = waitToVisible(DATE);
        date.click();
        calenderDay = waitForElementWithText((String.valueOf(day)));
        calenderDay.click();
        okButton = waitToVisible(OK_BUTTON);
        okButton.click();

    }
    public  void choseTime(int hours , int minutes, String amORpm ){
        time = waitToVisible(TIME);
        time.click();
        timeKeyBoardSign = waitToVisible(TIME_KEYBOARD_SIGN);
        timeKeyBoardSign.click();
        hoursINPUT = waitToVisible(HOURS_INPUT);
        hoursINPUT.sendKeys(String.valueOf(hours));
        minutesInput = waitToVisible(MINUTES_INPUT);
        minutesInput.sendKeys(String.valueOf(minutes));
        choseAMpm = waitToVisible(CHOSE_AM_PM);
        choseAMpm.click();
        amOrPmElement = waitForElementWithText(amORpm);
        amOrPmElement.click();
        okButton= waitToVisible(OK_BUTTON);
        okButton.click();
    }
    public void  choseRepeat(String repeatEvery){
        repeat= waitToVisible(REPEAT);
        repeat.click();
        whenToRepeat= waitForElementWithText(repeatEvery);
        whenToRepeat.click();
    }
    public  void  choseTask(int index){
        task= waitToVisible(TASK);
        task.click();
        taskType = findElementByIndex(index);
        taskType.click();
    }
    public  void  addDescription(String description){
        descriptionInput = waitToVisible(DESCRIPTION_INPUT);
        descriptionInput.sendKeys(description);
    }
    public  void clickSaveButton(){
        saveButton = waitToVisible(SAVE_BUTTON);
        saveButton.click();
    }
    public void fullProcessAddingEvent(String title,int day,int hours,int minutes, String amPM, String repeat,int task,String description){
        inputTitle(title);
        choseDate(day);
        choseTime(hours,minutes,amPM);
        choseRepeat(repeat);
        choseTask(task);
        addDescription(description);
        clickSaveButton();
    }
}
