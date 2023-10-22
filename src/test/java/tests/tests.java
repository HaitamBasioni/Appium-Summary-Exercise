package tests;

import enums.ChoosingDayEvent;
import infra.AndroidDriverManager;
import io.appium.java_client.android.AndroidDriver;
import logic.pages.EditEventPage;
import logic.pages.MainPage;
import logic.pages.NewEventPage;
import logic.pages.PendingEventsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class tests {
    static private AndroidDriver driver;
    private final String eventTittle="Zoom";
    MainPage mainPage;
    NewEventPage newEventPage;
    PendingEventsPage pendingEventsPage;
    EditEventPage editEventPage;
    @BeforeEach
    public void setup(){
        driver = AndroidDriverManager.createAndroidDriver();
        //Arrange in the beforeEach
        mainPage = new MainPage(driver);
        newEventPage = new NewEventPage(driver);
        pendingEventsPage = new PendingEventsPage(driver);
        editEventPage = new EditEventPage(driver);
        //Act
        mainPage.clickPlusSign();
        mainPage.clickDayEvent(ChoosingDayEvent.Today);
        newEventPage.fullProcessAddingEvent(eventTittle,23,10,22,"PM","Every day",2,"its meting");

    }
    @AfterEach
    public void tearDown(){
        AndroidDriverManager.quitDriver(driver);
    }

    @Test
    public  void  testAddNewEventSuccess(){
        //Arrange in the beforeEach adding new event

        //Act
        mainPage.clickPendingEvents();
        //Assert
        String eventName= pendingEventsPage.getEventName(eventTittle);
        Assertions.assertEquals(eventTittle,eventName);
    }
    @Test
    public void testEventDeletion() {
        //Arrange in the beforeEach adding new event

        //Act
        mainPage.clickPendingEvents();
        pendingEventsPage.clickEventByName(eventTittle);
        editEventPage.deleteEvent();
        // Assert
        boolean isDeleted = editEventPage.isEventDeleted();
        Assertions.assertEquals(true , isDeleted);
    }
    
}
