package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {
    IOSDriver driver;
    By book=By.xpath("//*[@text='Book']");
    By myTrips=By.xpath("//*[@text='My trips' and ./parent::*[@class='UIAView']]");
    By flyingBlue=By.xpath("//*[@name='Flying Blue' and @label='Flying Blue' and @hidden='false']");
    By profile=By.xpath("//*[@text='Profile' and ./parent::*[@class='UIAView']]");
    By contact=By.xpath("//*[@text='Contact']");
    public HomePage(IOSDriver driver){
        this.driver=driver;
    }
    public WebElement book(){
        return driver.findElement(book);
    }
    public WebElement myTrips(){
        return driver.findElement(myTrips);
    }
    public WebElement profile(){
        return driver.findElement(profile);
    }
    public WebElement contact(){
        return driver.findElement(contact);
    }

}
