package setup;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

public class Utilities {
    IOSDriver driver;
   public Utilities(){
       this.driver=driver;

    }
    public Utilities(IOSDriver driver){

    }

    public static void waitForElement(IOSDriver<IOSElement> driver, By element){
        new WebDriverWait(driver, 300).until(ExpectedConditions.presenceOfElementLocated(element));
       // new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(element));






    }

    public static double timeFormatter(Long time){
        double seconds=time/1000;
        System.out.println("seconds:"+seconds);
        double milliseconds=(double)(time%1000)/1000;
        System.out.println("Milli seconds:"+milliseconds);
        double duration=seconds+milliseconds;
        String value=""+seconds+"Seconds"+milliseconds+"Milli Seconds";
        return duration;


    }
    public void setBadNetworkCondition(IOSDriver driver){
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.executeScript("client:client.launch(\"com.apple.Preferences\", \"true\", \"true\")");
       /* String str1 = (String)driver.executeScript("client:client.swipeWhileNotFound(\"Down\", 400, 2000, \"//*[@value='Developer' and @XCElementType='XCUIElementTypeCell' and @onScreen='true']\", 1000, 8, true)");
        driver.findElementByXPath("//*[@text='Status' and @class='UIAView']").click();
        String i=driver.findElementByXPath("//*[@class='UIASwitch']").getAttribute("value");
        if(i.equalsIgnoreCase("0")){
            driver.findElementByXPath("//*[@class='UIASwitch']").click();
        }
       */ //driver.executeScript("client:client.swipeWhileNotFound(\"Down\", 500, 2000, \"//*[@name='Developer' and @label='Developer' and @knownSuperClass='UIAccessibilityElement' and @enabled='true' and @hidden='false' and @onScreen='true']\", 1000, 7, true)");
       // System.out.println("text is"+driver.findElementByXPath("//*[@text='Status' and @class='UIAView']").getText());
        //driver.findElementByXPath("//*[@text='Status' and @class='UIAView']").click();
       // driver.findElementByXPath("//*[@class='UIASwitch']").click();
       // driver.findElement(By.xpath("//*[@class='UIASwitch']")).click();
        driver.findElementByXPath("//*[@text='Very Bad Network' and @class='UIAView']").click();
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.executeScript("client:client.launch(\"com.klm.mobile.iphone.MCAR-iPhone\", \"true\", \"true\")");


        //driver.findElementByXPath("//*[@text='Edge' and @class='UIAView']").click();

    }
    public void setEdgeNetwork(IOSDriver driver){
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.executeScript("client:client.launch(\"com.apple.Preferences\", \"true\", \"true\")");
       /* String str1 = (String)driver.executeScript("client:client.swipeWhileNotFound(\"Down\", 400, 2000, \"//*[@value='Developer' and @XCElementType='XCUIElementTypeCell' and @onScreen='true']\", 1000, 8, true)");
        driver.findElementByXPath("//*[@text='Status' and @class='UIAView']").click();
        String i=driver.findElementByXPath("//*[@class='UIASwitch']").getAttribute("value");
        if(i.equalsIgnoreCase("0")){
            driver.findElementByXPath("//*[@class='UIASwitch']").click();
        }
       */ driver.findElementByXPath("//*[@text='Edge' and @class='UIAView']").click();
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.executeScript("client:client.launch(\"com.klm.mobile.iphone.MCAR-iPhone\", \"true\", \"true\")");

    }
    public Date date(){
        Date date = new Date();
        return date;
    }


    public void setWifi(IOSDriver<IOSElement> driver) {
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.executeScript("client:client.launch(\"com.apple.Preferences\", \"true\", \"true\")");
       /* String str1 = (String)driver.executeScript("client:client.swipeWhileNotFound(\"Down\", 400, 2000, \"//*[@value='Developer' and @XCElementType='XCUIElementTypeCell' and @onScreen='true']\", 1000, 8, true)");
        driver.findElementByXPath("//*[@text='Status' and @class='UIAView']").click();
        String i=driver.findElementByXPath("//*[@class='UIASwitch']").getAttribute("value");
        if(i.equalsIgnoreCase("0")){
            driver.findElementByXPath("//*[@class='UIASwitch']").click();
        }
*/
        driver.findElementByXPath("//*[@text='Wifi' and @class='UIAView']").click();
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.executeScript("client:client.launch(\"com.klm.mobile.iphone.MCAR-iPhone\", \"true\", \"true\")");

    }
}
