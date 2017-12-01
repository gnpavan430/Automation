package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddABookingPage {
    IOSDriver driver;
    public AddABookingPage(IOSDriver driver){
        this.driver=driver;
    }
    By addABookingHeader = By.xpath("//*[@text='Add a booking']");
    By bookingCode = By.xpath("//*[@placeholder='Booking code or ticketnumber']");
    By lastName = By.xpath("//*[@placeholder='Last name']");
    By addABookingButton = By.xpath("((//*[@class='UIATable']/*[@class='UIAView'])[4]/*[@text='Find your booking'])[2]");


    public By addABookingText(){
        return addABookingHeader;
    }
    public WebElement bookingCode(){
        return driver.findElement(bookingCode);
    }
    public WebElement lastName(){
        return driver.findElement(lastName);
    }
    public WebElement addABookingButton(){
        return driver.findElement(addABookingButton);
    }




}
