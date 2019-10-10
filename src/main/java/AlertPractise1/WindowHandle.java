package AlertPractise1;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandle extends UtilsPage {

    @BeforeMethod

    public void setUpBrowser(){




        System.setProperty("webdriver.chrome.driver","src\\main\\Resources\\BrowserDriver\\chromedriver.exe");
        openChromeVersion76();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/popup.php");
    }
    @AfterMethod

    public void closeBrowser(ITestResult result){

        if(ITestResult.FAILURE==result.getStatus()){

            takeSnapShot(result.getName());
        }
        //driver.quit();
    }



    @Test

    public void windowHandle(){

    clickElement(By.xpath("//a[@target=\"_blank\"]"));

    String mainWindow = driver.getWindowHandle();

    Set<String> s1= driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while(i1.hasNext())
        {

            String childWindow = i1.next();

            if(!mainWindow.equalsIgnoreCase(childWindow)){

                driver.switchTo().window(childWindow);
                enterText(By.name("emailid"),"gaurav.3n@gmail.com");

                clickElement(By.name("btnLogin"));

                driver.close();

            }
        }


    }
}
