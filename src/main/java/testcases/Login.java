package testcases;//package <set your test package>;

//import org.junit.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.LoginPage;
import pageobjects.Profile;
import pageobjects.FlyingBlue;
import setup.Quickstart;
import setup.Setup;
import setup.Utilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RunWith(Parameterized.class)
public class Login extends Setup {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    String goodNetwork="Good Network";
    String badNetwork="Bad Network";
    String edgeNetwork="Edge Network";
    private List<Object> list;

   // private Sample sample;
    //private IOSDriver driver;
   // protected IOSDriver<IOSElement> driver = setUp();

   // DesiredCapabilities dc = new DesiredCapabilities();
    //LoginPage loginPage=new LoginPage();



    public Login(List<Object> list){
        this.list=list;

    }

    /*  @Before
      public void setUp() throws MalformedURLException {
          dc.setCapability("reportDirectory", reportDirectory);
          dc.setCapability("reportFormat", reportFormat);
          dc.setCapability("testName", testName);
          dc.setCapability(MobileCapabilityType.UDID, "67e48a029ef2918109bbd2011bd3c6b4497f2eae");
          dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.klm.mobile.iphone.MCAR-iPhone");
          driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
          driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
      }
  */
    /*@Test
    public void testUntitled() {
        driver.executeScript("client:client.setDevice(\"ios_app:IMO's iPhone 5S Pavan\")");
       // driver.executeScript("client:client.launch(\"com.klm.mobile.iphone.MCAR-iPhone\")");
//        driver.manage().timeouts().implicitlyWait(6000,TimeUnit.MILLISECONDS);

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='UIAView' and ./*[@text='Btm_Normal_Enrollment']]")));
        //driver.findElement(By.xpath("//*[@class='UIAView' and ./*[@text='Btm_Normal_Enrollment']]")).click();
        loginPage.getFlyingBlue().click();
       *//* LoginPage.getFlyingBlue().click();
        LoginPage.getLogin().click();
        //driver.findElement(By.xpath("//*[@class='UIAView' and ./*[@text='Btm_Normal_Enrollment']]")).click();
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("1121711790");
        //driver.findElement(By.xpath("//*[@XCElementType='XCUIElementTypeTextField']")).clear();
       // driver.getKeyboard().sendKeys("1121711790");
        LoginPage.getPassword().click();
        LoginPage.getPassword().sendKeys("1234");

        //driver.findElement(By.xpath("//*[@XCElementType='XCUIElementTypeSecureTextField']")).click();
        //driver.getKeyboard().sendKeys("1234");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Before clicking the button"+dateFormat.format(date)); //2016/11/16 12:08:43
        LoginPage.getLoginButton().click();
        //driver.findElement(By.xpath("//*[@class='UIAButton' and ./preceding-sibling::*[@text='Log in'] and ./parent::*[@class='UIAView']]")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@value='1121711790' and @XCElementType='XCUIElementTypeTextView']")));
        Date date1 = new Date();
        System.out.println("After screen is loaded"+dateFormat.format(date1));
        long diff = date1.getTime()-date.getTime();
        System.out.println("Time taken for login"+diff);*//*
       *//* driver.findElement(By.xpath("//*[@class='UIAView' and ./*[@text='Btm_Normal_Profile']]")).click();
        driver.findElement(By.xpath("//*[@class='UIAButton']")).click();
        driver.findElement(By.xpath("//*[@text='Log out' and @class='UIAButton']")).click();
        String text=driver.findElement(By.xpath("//*[@class='UIAButton']")).getText();
        System.out.println("Text of button is"+text);*//*



    }*/
    @Test
     public void goodNetwork() throws IOException {
        Utilities utilities = new Utilities(driver);
        utilities.setWifi(driver);
        login(goodNetwork);




    }

    @Test
    public void badNetworkLogin() throws IOException {
        Utilities utilities = new Utilities(driver);
        utilities.setBadNetworkCondition(driver);
        login(badNetwork);



    }

    @Test
    public void edgeNetwork() throws IOException {
        Utilities utilities = new Utilities(driver);
        utilities.setEdgeNetwork(driver);
        login(edgeNetwork);

    }
    @Parameterized.Parameters
    public static List<Object> data() throws IOException {
        Quickstart quickstart = new Quickstart();
        List<List<Object>> values = quickstart.dataFromSheet();
        System.out.println("Values from sheet are"+values);
        List<Object> list = new ArrayList<Object>();
        for(int i=0;i<values.size();i++){
            list.add(values.get(i));
        }

        //List<Object> list = values.get(0);
        System.out.println("Values in list are"+list);
        return list;

    }

    public void login(String network) throws IOException {
        Quickstart quickstart = new Quickstart();
        FlyingBlue flyingBlue = new FlyingBlue(driver);
        LoginPage loginPage = new LoginPage(driver);
        Profile profile=new Profile(driver);
        flyingBlue.flyingBlue().click();
       /* Quickstart quickstart = new Quickstart();
        List<List<Object>> values = quickstart.dataFromSheet();
        List<Object> list = values.get(0);*/


//        Utilities.waitForElement(driver,loginPage.username());
        System.out.println("User name is"+list.get(0));

        loginPage.login().click();
        loginPage.username().clear();
        loginPage.username().sendKeys(list.get(0).toString());
        loginPage.password().sendKeys(list.get(1).toString());
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Before clicking the login button"+dateFormat.format(date)); //2016/11/16 12:08:43
        loginPage.loginButton().click();

        Utilities.waitForElement(driver,flyingBlue.getFlyingBlueNumberText());

//        flyingBlue.flyingBlueNumberText().click();
        Date date1 = new Date();
        System.out.println("After screen is loaded"+dateFormat.format(date1));
        long diff = date1.getTime()-date.getTime();
        double value = Utilities.timeFormatter(diff);
        System.out.println("Time in Seconds"+diff);
        System.out.println("Time taken for login"+value);
        profile.profileButton().click();
        profile.logoutButton().click();
        Date date2 = new Date();
        System.out.println("Before clicking logout button"+dateFormat.format(date2));
        profile.alertTextLogout().click();
        Utilities.waitForElement(driver,profile.loginButtonText());
        profile.loginButton().click();
        Date date3 = new Date();
        System.out.println("After logout"+dateFormat.format(date3));
        //Utilities.waitForElement(driver,loginPage.loginScreenHeaderText());


        long diff1 = date3.getTime()-date2.getTime();
        double value1 = Utilities.timeFormatter(diff1);
        System.out.println("Time in Seconds"+diff1);
        System.out.println("Time taken for logout"+value1);
        Date timeStamp= new Date();
        quickstart.appendValues(network,timeStamp,value,value1);









    }



}