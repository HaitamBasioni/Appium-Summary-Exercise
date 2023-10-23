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
        newEventPage.fullProcessAddingEvent(eventTittle,23,10,22,"PM","Every day",2,"Zoom meeting");

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
    @Test
    public void testEventEditName(){
        //Arrange in the beforeEach adding new event
        // Act
        mainPage.clickPendingEvents();
        pendingEventsPage.clickEventByName(eventTittle);
        editEventPage.clickEdit();
        newEventPage.inputTitle("party");
        newEventPage.clickSaveButton();
        //Assert
        String eventName= editEventPage.getEventTittle();
        Assertions.assertEquals("party",eventName);
    }
    @Test
    public void testEventEditTime(){
        //Arrange in the beforeEach adding new event
        // Act
        mainPage.clickPendingEvents();
        pendingEventsPage.clickEventByName(eventTittle);
        editEventPage.clickEdit();
        newEventPage.choseTime(11,01,"AM");
        newEventPage.clickSaveButton();
        //Assert
        String eventTime= editEventPage.getEventTime();
        Assertions.assertEquals("11:01 am",eventTime);
    }
    @Test
    public void testEventEditDate(){
        //Arrange in the beforeEach adding new event
        // Act
        mainPage.clickPendingEvents();
        pendingEventsPage.clickEventByName(eventTittle);
        editEventPage.clickEdit();
        editEventPage.choseDate(25);
        newEventPage.clickSaveButton();
        //Assert
        String eventDate= editEventPage.getEventDate();
        Assertions.assertEquals("Wed, 25 Oct 2023",eventDate);
    }
    @Test
    public void testEventEditRepeat(){
        //Arrange in the beforeEach adding new event
        // Act
        mainPage.clickPendingEvents();
        pendingEventsPage.clickEventByName(eventTittle);
        editEventPage.clickEdit();
        newEventPage.choseRepeat("Every week");
        newEventPage.clickSaveButton();
        //Assert
        String eventRepeat= newEventPage.getRepeat();
        Assertions.assertEquals("Repeats every 1 week.",eventRepeat);
    }
    @Test
    public void testEventEditTaskType(){
        //Arrange in the beforeEach adding new event
        // Act
        mainPage.clickPendingEvents();
        pendingEventsPage.clickEventByName(eventTittle);
        editEventPage.clickEdit();
        newEventPage.choseTask(0);
        newEventPage.clickSaveButton();
        //Assert
        String eventType= editEventPage.getTaskType();
        Assertions.assertEquals("Task",eventType);
    }
    @Test
    public void testEventEditDescription(){
        //Arrange in the beforeEach adding new event
        // Act
        mainPage.clickPendingEvents();
        pendingEventsPage.clickEventByName(eventTittle);
        editEventPage.clickEdit();
        newEventPage.addDescription("change description");
        newEventPage.clickSaveButton();
        //Assert
        String eventDescription= editEventPage.getDescription();
        Assertions.assertEquals("change description",eventDescription);
    }
    @Test
    public void testEventIsCompleted(){
        //Arrange in the beforeEach adding new event
        // Act
        mainPage.clickPendingEvents();
        pendingEventsPage.clickEventByName(eventTittle);
        editEventPage.clickCompleted();
        editEventPage.clickBackButton();
        //Assert
        boolean isCompleted= editEventPage.isCompleteDisplayed();
        Assertions.assertEquals(true,isCompleted);
    }

}
