package logic.pages;

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

    //strings to locate elements by text
    String day1 = "Today";
    String day2 ="Tomorrow";
    String day3= "Other";

    public MainPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
    public void clickPlusSign(){
        plusSignToAdd=waitToVisible(PLUS_SIGN_TO_ADD);
        plusSignToAdd.click();
        today=waitForElementWithText(day1);
        tomorrow = waitForElementWithText(day2);
        other= waitForElementWithText(day3);
    }
    public  void  clickToday(){
        today.click();
    }
    public  void clickTomorrow(){
        tomorrow.click();
    }
    public  void clickOther(){
        other.click();
    }
}
