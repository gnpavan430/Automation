package testcases;

import org.junit.Test;
import org.openqa.selenium.By;
import pageobjects.AddABookingPage;
import pageobjects.HomePage;
import pageobjects.MyTrips;
import setup.Setup;
import setup.Utilities;

public class AddABooking extends Setup {
    @Test
    public void addABooking(){
        HomePage homePage = new HomePage(driver);
        AddABookingPage addABookingPage = new AddABookingPage(driver);

        MyTrips myTrips=new MyTrips(driver);
        homePage.myTrips().click();
        Utilities.waitForElement(driver,myTrips.bannersLink());
        driver.executeScript("client:client.swipe(\"Down\", 500, 500)");

        if(isElementPresent(By.xpath("//*[@text='Add a booking']"))){
            System.out.println("inside if");
            myTrips.addABooking().click();
        }
        else if(myTrips.addABookingActionButton().isDisplayed()){
            myTrips.addABookingActionButton().click();
        }
        Utilities.waitForElement(driver,addABookingPage.addABookingText());
        addABookingPage.bookingCode().sendKeys("abcdef");
        addABookingPage.lastName().sendKeys("ghijkl");
        addABookingPage.addABookingButton().click();





    }
    protected boolean isElementPresent(By by) {
        boolean isElement = false;
        try
        {
            if (driver.findElement(by) != null)
            {
                isElement = true;
                return isElement;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Element not found");
            isElement = false;
            return isElement;
        }
        return isElement;
    }
}
