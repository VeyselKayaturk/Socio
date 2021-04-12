package SocioTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MyEventPage extends Login {
    WebDriverWait wait;
    public MyEventPage(WebDriver driver){
        this.driver=driver;

    }

    public MyEventPage() {

    }

    public void openEventPage(WebDriver driver) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"rs-wrapper\"]/article/div/div/div[2]/div/div/div/div[2]/div/span/div"));
        Thread.sleep(5000);;
        if (!element.isDisplayed()) {
            driver.findElement(By.id("event-app-nav")).click();
            Thread.sleep(2000);
            driver.findElement(By.className("active")).click();
            Thread.sleep(2000);
            Assert.assertEquals("Test Automation Assessment Event", driver.findElement(By.className("m-t-sm rs-dashhead-title")).getText());
        }
        element.click();
        Thread.sleep(2000);
    }
    public void clickWebApp(WebDriver driver)throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"rs-wrapper\"]/aside/ul/li[6]/a/span")).click();
        Thread.sleep(2000);
    }
    public void enableWebApp(WebDriver driver) throws InterruptedException {
        //WebElement element = driver.findElement(By.cssSelector("[class='form-group'] [class*='bootstrap-switch-off']"));
        boolean enableWebAppYes = driver.findElements(By.cssSelector("[class='form-group'] [class*='bootstrap-switch-on']")).size()>0;
        if (!enableWebAppYes) {
            driver.findElement(By.cssSelector("[class='form-group'] [class*='bootstrap-switch-off']")).click();
        }
        Thread.sleep(3000);
        //click to save button
        driver.findElement(By.cssSelector("[class='btn btn-success']")).click();
    }

    public void clickAndCopyGetShareableLink(WebDriver driver) throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Get Shareable Link')]"));
        action.moveToElement(element).perform();
        Thread.sleep(2000);
        //click and copy get shareable link
        driver.findElement(By.xpath("//button[contains(text(),'Get Shareable Link')]")).click();
        Thread.sleep(3000);

        String copiedLink = driver.findElement(By.className("form-control")).getText();
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div[2]/div/span/span/button")).click();
    }

    public void clickCloseButton(WebDriver driver){
        driver.findElement(By.className("close")).click();

    }

    public void clickEditEvent(WebDriver driver) throws InterruptedException {
        driver.findElement(By.className("gcon gcon-pencil rs-icon-menu")).click();
        Thread.sleep(3000);
    }

    public void clickWallEditButton(WebDriver driver) throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.id("Wall"));
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.id("Wall")).click();
        driver.findElement(By.cssSelector("[data-testid='buttonEditFeature']")).click();
    }
    public void assertWhetherPostIsExists(WebDriver driver) {

        List<WebElement> listOfElement = driver.findElements(By.cssSelector("[id='componentItemsList'] [data-testid*='row']"));
        boolean flag = false;

        for (int i = 0; i < listOfElement.size(); i++) {
            if (listOfElement.size()!=0) {
                System.out.println("There is post in the list. Post title:");
                flag = true;
                break;
            }
        }
        Assert.assertEquals(true, "You don't have any posts yet!");
    }
}
