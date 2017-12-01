package testcases;

import org.junit.Test;
import org.openqa.selenium.By;
import pageobjects.HomePage;
import setup.Setup;

public class BookATrip extends Setup {
    @Test
    public void bookATripFlow() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.book().click();
        driver.findElement(By.xpath("//*[@text='Destination']")).click();
        driver.findElement(By.xpath("//*[@placeholder='where to?']")).click();
        driver.getKeyboard().sendKeys("bcn");
        driver.findElement(By.xpath("//*[@class='UIAView' and ./*[@text='Barcelona']]")).click();
        driver.findElement(By.xpath("//*[@text='Select travel dates']")).click();
        Thread.sleep(8000);
       int count= driver.findElements(By.xpath("//*[@class='UIACollectionView']")).size();
       System.out.println("Number of elements:"+count);


    }
}
