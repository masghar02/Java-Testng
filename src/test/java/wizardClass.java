import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class wizardClass extends randomUserdata{

    ChromeDriver cd;

    @BeforeClass
    public void beforeTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        cd = new ChromeDriver();
        cd.get("https://bystored:bystored2020@stage.bystored.com/booking");
        cd.manage().window().maximize();
        Thread.sleep(1000);
    }
    @Test(priority = 1)
    public void selectUnit() throws InterruptedException {
        Thread.sleep(1000);
        cd.findElement(By.xpath("//body/section[@id='section1']/div[1]/div[1]/div[3]/div[1]/div[1]/div[4]/div[1]/label[1]")).click();
        Thread.sleep(1000);
        cd.findElement(By.id("step1-cta-next")).click();

    }
    @Test (priority = 2)
    public void selectPromotions() throws InterruptedException {
        Thread.sleep(1000);
        cd.findElement(By.xpath("//body[1]/section[2]/div[1]/div[1]/div[1]/ul[1]/li[3]")).click();
        Thread.sleep(1000);
        cd.findElement(By.id("step2-cta-next")).click();


    }
    @Test(priority = 3)
    public void userAddress() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(cd, Duration.ofSeconds(30));
        wait.until(
                ExpectedConditions.elementToBeClickable(By.id("postCode"))).click();
        cd.findElement(By.id("postCode")).clear();

        cd.findElement(By.id("postCode")).sendKeys("SW6");
        Thread.sleep(1000);
        cd.findElement(By.id("address")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//body[1]/section[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]"))).click();
//        cd.findElement(By.xpath("//body[1]/section[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]")).click();
        Thread.sleep(1000);
//        WebElement dateWidgetFrom = wait.until(
//                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar"))).get(0);


    }
    @Test(priority = 4 )
    public void userData() throws InterruptedException {
        randomUserdata rd = new randomUserdata();
        cd.findElement(By.id("fname")).sendKeys(rd.RandGeneratedStr(6));
        Thread.sleep(1000);
        cd.findElement(By.id("lname")).sendKeys(rd.RandGeneratedStr(5));
        Thread.sleep(1000);
        cd.findElement(By.id("email")).sendKeys(rd.Randomemail());
        Thread.sleep(1000);
        cd.findElement(By.id("phone")).sendKeys(rd.Randonumber());
        Thread.sleep(1000);
        cd.findElement(By.id("step3-cta-next")).click();
        Thread.sleep(1000);
    }
    @Test (priority = 5)
    public void getDate() throws InterruptedException {
        String month = "March";
        String day = "1";
        Thread.sleep(1000);
        while (true)
        {
            String getMonth = cd.findElement(By.className("ui-datepicker-month")).getText();
            if(getMonth.equals(month))
            {
                break;
            }else {
                cd.findElement(By.xpath("//body/section[@id='newsection4']/div[1]/div[1]/div[2]/div[1]/div[1]/a[2]")).click();
            }
        }
        Thread.sleep(1000);
        By calendarXpath = By
                .xpath("//td[not(contains(@class,'ui-datepicker-calendar'))]/a[text()='"
                        + day + "']");
//        System.out.println(calendarXpath);
        cd.findElement(calendarXpath).click();
    }
    @Test(priority = 6)
    public void selectTime() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(cd, Duration.ofSeconds(20));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("generic-slot")));
//        wait.until(
//                ExpectedConditions.elementToBeClickable(By.className("arrival-load"))).click();
        cd.findElement(By.id("arrival-load")).click();
        cd.findElement(By.xpath("//body[1]/section[4]/div[2]/div[1]/ul[1]/li[1]")).click();
//        wait.until( ExpectedConditions.visibilityOfElementLocated(By.id("section5")));
        Thread.sleep(1000);
        cd.findElement(By.id("datepicker-btn")).click();
    }
    @Test(priority = 7)
    public void packingAssistance() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(cd,Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='section6']")));
        Thread.sleep(1000);
        cd.findElement(By.xpath("//body/section[@id='section6']/div[1]/ul[1]/li[1]/label[1]")).click();
    }
    @Test(priority = 8)
    public void readyToBook() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(cd, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='section8']")));
        cd.findElement(By.id("continueReservation")).click();
        System.out.println("Booking Created");
        Thread.sleep(10000);
    }
    @AfterClass
    public void afterTest(){
        cd.close();
        cd.quit();
    }
}
