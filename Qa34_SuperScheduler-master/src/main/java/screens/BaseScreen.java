package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseScreen {
    AppiumDriver<MobileElement>driver;

    public BaseScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void type(MobileElement element,String text){
        if(text!=null){
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void shouldHave(MobileElement element,String text,int time){
        new WebDriverWait(driver,time)
                .until(ExpectedConditions.textToBePresentInElement(element,text));
    }
    public void should(MobileElement element,int time){
        new WebDriverWait(driver,time)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isDisplayedWithExp(MobileElement element){
        try {
            should(element, 5);
            return element.isDisplayed();
        }catch (Exception ex){
            return false;
        }
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }
}
