package AlertPractise1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPopup extends UtilsPage {

    @BeforeMethod

public void setUpBrowser(){




    System.setProperty("webdriver.chrome.driver","src\\main\\Resources\\BrowserDriver\\chromedriver.exe");
        openChromeVersion76();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
    driver.manage().window().maximize();
    driver.get("http://demo.guru99.com/test/delete_customer.php");
}
    @AfterMethod

    public void closeBrowser(ITestResult result){

        if(ITestResult.FAILURE==result.getStatus()){

            takeSnapShot(result.getName());
        }
        //driver.quit();
    }

@Test

    public void guru(){


    enterText(By.xpath("//input[@name=\"cusid\"]"),"53920");
   clickElement(By.name("submit"));

   Alert alert = driver.switchTo().alert();

   String alertMessage = driver.switchTo().alert().getText();

    System.out.println(alertMessage);

    sleep(5000);

    alert.accept();

    alert.accept();


}


}
