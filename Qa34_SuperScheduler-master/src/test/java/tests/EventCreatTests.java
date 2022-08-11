package tests;

import manager.Configuration;
import models.Event;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;

public class EventCreatTests extends Configuration {

    @BeforeClass
    public void preCondition() {
        new LoginScreen(driver)
                .complexLogin(User.builder().email("noa@gmail.com").password("Nnoa12345$").build());

    }

    @Test
    public void creatNewEventSuccess() {
        Event event = Event.builder()
                .title("New Title")
                .type("My Type")
                .breaks(3)
                .wage(60).build();

        boolean isfabPresent = new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(event)
                .isFabAddPresent();

        Assert.assertTrue(isfabPresent);

    }

    @AfterClass
    public void postCondition() {
        new HomeScreen(driver)
                .openMenu()
                .logout();
    }
}
