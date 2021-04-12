package SocioTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RunnerClass {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        String AUTOMATE_USERNAME = "alihanozbayrak1";
        String AUTOMATE_ACCESS_KEY = "yYzukxkJ3sAqxT1pyW7B";
        String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("project", "SocioTest");
        caps.setCapability("build", "VeyselSocioTestRun");
        caps.setCapability("name", "Test1");
        caps.setCapability("browserstack.local", "false");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("browserstack.networkLogs", "true");
        caps.setCapability("browserstack.selenium_version", "4.0.0-alpha-6");
        WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("BrowserStack");
        element.submit();


        //This 3 step is written to debug codes on my local
        //String projectPath = System.getProperty("user.dir");
        //System.setProperty("webdriver.chrome.driver", projectPath+"/src/main/resources/drivers/chromedriver");
        //ChromeDriver driver = new ChromeDriver();

        Login lgn = new Login(driver);
        MyEventPage event = new MyEventPage(driver);
        WallPage wall = new WallPage(driver);



        lgn.browsersetUp(driver);
        lgn.loginToApp(driver);

        event.openEventPage(driver);
        event.clickWebApp(driver);
        event.enableWebApp(driver);
        event.clickAndCopyGetShareableLink(driver);
        event.clickCloseButton(driver);
        wall.openNewBrowser(driver);
        wall.openWallPage(driver);


        /* The given sample user do not show What is your mind page as it expected.
         With my credentials I could not see the same secion as well. So, the code
         below will not work due to application lack lack information inside app */

        /*
        wall.clickOnWhatIsOnYourMind(driver);
        wall.writeCommand(driver);
        wall.uploadImage(driver);
        wall.clickSendButton(driver);
        event.clickEditEvent(driver);
        event.clickWallEditButton(driver);
        event.assertWhetherPostIsExists(driver);
        wall.goBackToPreviousWindow(driver);*/


        lgn.tearDown(driver);
    }
}
