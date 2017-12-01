package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTrips {
    IOSDriver driver;
    By addABooking=By.xpath("//*[@text='Add a booking']");
    By notifications = By.xpath("//*[@class='UIAButton' and @height>0 and ./parent::*[@text='MyTripsView']]");
    By noTripsText=By.xpath("//*[@text='You have no upcoming trips.']");
    By banners=By.xpath("((//*[@class='UIATable']/*[@class='UIAView'])[2]/*[@class='UIAButton' and @height>0])[1]");
    By addABookingActionButton=By.xpath("(//*[@text='MyTripsView']/*[@class='UIAButton' and @height>0])[2]");
    public MyTrips(IOSDriver driver){
        this.driver=driver;
    }
    public WebElement addABooking(){
        return driver.findElement(addABooking);
    }
    public WebElement notifications(){
        return driver.findElement(notifications);
    }
    public WebElement noNotificationsText(){
        return driver.findElement(noTripsText);
    }
    public WebElement banners(){
        return driver.findElement(banners);
    }
    public By bannersLink(){
        return banners;
    }
    public WebElement addABookingActionButton(){
        return driver.findElement(addABookingActionButton);
    }


}
