package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class HomeScreen extends BaseScreen{
    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_main']")
    MobileElement fabAdd;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_add_event']")
    MobileElement fabAddEvent;
    @FindBy(xpath = "//*[@content-desc='Open']")
    MobileElement burgerMenu;
    @FindBy(xpath = "//*[@content-desc='Open']")
    List <MobileElement> list;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/nav_fr_logout']")
    MobileElement logoutButton;



    public EditCreatEventScreen initCreationEvent(){
        fabAdd.click();
        fabAddEvent.click();
        return new EditCreatEventScreen(driver);
    }
    public HomeScreen checkFabButtonPresentAssert(){
        should(fabAdd,10);
        Assert.assertTrue(fabAdd.isDisplayed());
        return this;
    }

    public boolean isFabAddPresent(){
        should(fabAdd,10);
        return fabAdd.isDisplayed();
    }
    public HomeScreen openMenu2(){
        if(isElementPresent(By.xpath("//*[@content-desc='Open']"))) {
            burgerMenu.click();
        }
        return this;
    }

    public HomeScreen openMenu3(){
        if(list.size()>0) {
            list.get(0).click();
        }
        return this;
    }
    public HomeScreen openMenu(){
        if(isDisplayedWithExp(burgerMenu)) {
            burgerMenu.click();
        }
        return this;
    }

    public LoginScreen logout(){
        if(isDisplayedWithExp(logoutButton)) {
            logoutButton.click();
        }
        return new LoginScreen(driver);
    }


}
