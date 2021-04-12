package SocioTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    //empty constructor
    public Login() { }

    WebDriver driver = null;

    public Login(WebDriver driver){
        this.driver=driver;
    }


    public void browsersetUp(WebDriver driver) throws InterruptedException {
        //String projectPath = System.getProperty("user.dir");
        //System.setProperty("webdriver.chrome.driver", projectPath+"/src/main/resources/drivers/chromedriver");
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    public void loginToApp(WebDriver driver) throws InterruptedException {
        driver.navigate().to("https://staging.platform.socio.events/login");
        driver.findElement(By.id("email")).sendKeys("testautomation@socio.events");
        driver.findElement(By.id("password")).sendKeys("ta12345");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[data-testid='btnLogin']")).click();
        Thread.sleep(6000);

    }
    public void tearDown(WebDriver driver){
        this.driver.close();
        this.driver.quit();
    }



}
