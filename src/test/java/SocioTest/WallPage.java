package SocioTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WallPage extends Login {
    MyEventPage myEvent = new MyEventPage();

    public WallPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openNewBrowser(WebDriver driver) {
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.manage().window().maximize();
        driver.get("https://staging.app.socio.events/MjQ0Mjc%3D/overview");

        //driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
        //driver.findElement (By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/div/table/tbody/tr[2]/td[2]")).sendKeys(Keys.chord(Keys.CONTROL, "v"));

    }
    public void goBackToPreviousWindow(WebDriver driver){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0)); // switch back to main screen
    }

    public void openWallPage(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div/div/div[2]/ul/div[5]/div[2]/span")).click();
        Thread.sleep(3000);
    }

    public void clickOnWhatIsOnYourMind(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//div[contains(text(),'What’s on your mind, Test?')]")).click();
        Thread.sleep(3000);
    }

    public void writeCommand(WebDriver driver) throws InterruptedException {
        driver.findElement(By.cssSelector("[placeholder='What’s on your mind, Test?']")).sendKeys("Hello World");
        Thread.sleep(3000);
    }
    public void uploadImage(WebDriver driver) throws InterruptedException {

        driver.findElement(By.xpath("//div[contains(text(),'Add Image')]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[contains(text(),'Add Image')]")).sendKeys("/Users/veyselkayaturk/IdeaProject/Socio/Moon.jpeg");
        driver.findElement(By.cssSelector("[title='Save']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[title='Upload']")).click();
    }
    public void clickSendButton(WebDriver driver) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        List<WebElement> elements = driver.findElements(By.cssSelector("[style='display: flex; flex-direction: column; justify-content: space-between;'] button"));
        elements.get(1).click();
        Thread.sleep(3000);
    }
}
