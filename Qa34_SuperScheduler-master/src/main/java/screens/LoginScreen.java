package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.User;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class LoginScreen extends BaseScreen{
    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy (xpath  ="//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement emailEditText;
    @FindBy (xpath  ="//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditText;
    @FindBy (xpath  ="//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;
    @FindBy (xpath = "//*[@resource-id='android:id/message']")
    MobileElement errorMessage;
    @FindBy (xpath = "//*[@resource-id='android:id/button1']")
    MobileElement okBtn;


    public LoginScreen confirmError(){
        okBtn.click();
        return this;
    }

    public LoginScreen checkErrorMessage(String message){
        shouldHave(errorMessage,message,10);
        Assert.assertEquals(errorMessage.getText(),message);
        return this;
    }

    public LoginScreen fillEmail(String email){

        should(emailEditText,10);
        type(emailEditText,email);
        //return new LoginScreen(driver);
        return this;
    }
    public LoginScreen fillPassword(String password){
        type(passwordEditText,password);
        return this;
    }
    public HomeScreen submitLogin(){
        driver.hideKeyboard();
        loginButton.click();
        return new HomeScreen(driver);
    }

    public WizardScreen submitRegistration(){
        driver.hideKeyboard();
        loginButton.click();
        return new WizardScreen(driver);
    }
    public HomeScreen complexLogin(User user){
        should(emailEditText,10);
        type(emailEditText, user.getEmail());
        type(passwordEditText, user.getPassword());
        driver.hideKeyboard();
        loginButton.click();

        return new HomeScreen(driver);
    }

    public LoginScreen complexLoginNegative(User user){
        should(emailEditText,10);
        type(emailEditText, user.getEmail());
        type(passwordEditText, user.getPassword());
        driver.hideKeyboard();
        loginButton.click();

        return this;
    }

}
