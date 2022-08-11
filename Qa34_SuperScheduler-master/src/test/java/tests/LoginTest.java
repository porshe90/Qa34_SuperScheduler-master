package tests;

import manager.Configuration;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;
import screens.SplashScreen;

public class LoginTest extends Configuration {


    @Test
    public void loginTestSuccess() {

//        boolean addPresent = new SplashScreen(driver)
//                .checkCurrentVersion("0.0.3")
        boolean addPresent =new LoginScreen(driver)
                .fillEmail("noa@gmail.com")
                .fillPassword("Nnoa12345$")
                .submitLogin()
                .isFabAddPresent();
        Assert.assertTrue(addPresent);

    }

    @Test
    public void loginTestSuccess2() {
//
//        boolean addPresent = new SplashScreen(driver)
//                .checkCurrentVersion("0.0.3")
        boolean addPresent =new LoginScreen(driver)
                .fillEmail("noa@gmail.com")
                .fillPassword("Nnoa12345$")
                .submitLogin()
                .isFabAddPresent();
        Assert.assertTrue(addPresent);

    }

    @Test
    public void loginSuccessModel(){

        User user = User.builder().email("noa@gmail.com").password("Nnoa12345$").build();
        boolean addPresent = new LoginScreen(driver)
                .complexLogin(user)
                .isFabAddPresent();
        Assert.assertTrue(addPresent);


    }
    @Test
    public void loginNegativeModelWrongPassword(){ // (noa@gmail.com + Nn12345$)
        User user = User.builder().email("noa@gmail.com").password("Nnn12345$").build();
        new LoginScreen(driver)
                .complexLoginNegative(user)
                .checkErrorMessage("Wrong email or password")
                .confirmError();

    }


    @AfterMethod
    public void postCondition(){
        new HomeScreen(driver)
                .openMenu()
                .logout();
    }

}
