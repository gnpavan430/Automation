package setup;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Setup {
    public static IOSDriver<IOSElement> driver;

    static DesiredCapabilities dc = new DesiredCapabilities();


    @Before
    public void  setUp() throws MalformedURLException {

        dc.setCapability(MobileCapabilityType.UDID, "67e48a029ef2918109bbd2011bd3c6b4497f2eae");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.klm.mobile.iphone.MCAR-iPhone");
        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);



    }
    public static IOSDriver initializeDriver() throws MalformedURLException {
        IOSDriver driver1;
        if(driver!=null){
            driver1= driver;
        }
        else{
            dc.setCapability(MobileCapabilityType.UDID, "67e48a029ef2918109bbd2011bd3c6b4497f2eae");
            dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.klm.mobile.iphone.MCAR-iPhone");

            driver1 = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);


        }
        return driver1;
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
