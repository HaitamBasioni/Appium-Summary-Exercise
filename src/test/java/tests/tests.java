package tests;

import enums.ChoosingDayEvent;
import infra.AndroidDriverManager;
import io.appium.java_client.android.AndroidDriver;
import logic.pages.MainPage;
import logic.pages.NewEventPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class tests {
    static private AndroidDriver driver;
    @BeforeEach
    public void setup(){
        driver = AndroidDriverManager.createAndroidDriver();
    }
    @AfterEach
    public void tearDown(){
        AndroidDriverManager.quitDriver(driver);
    }
    @Test
    public  void  addingNewEvent(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPlusSign();
        mainPage.clickDayEvent(ChoosingDayEvent.Today);
        NewEventPage eventPage = new NewEventPage(driver);
        eventPage.fullProcessAddingEvent("Zoom",23,10,22,"PM","Every day",2,"its meting");

    }

}
