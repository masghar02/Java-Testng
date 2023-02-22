import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;

public class postCodeTest{

    ChromeDriver cd;
    randomUserdata rd = new randomUserdata();
    @BeforeClass
    public void beforeTest() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        cd = new ChromeDriver();
        cd.get("https://bystored:bystored2020@stage.bystored.com");
        cd.manage().window().maximize();
        Thread.sleep(1000);
//        String expected = "Hassle-free Storage Service | Storage Units by STORED";
//        String actual = cd.getTitle();
//        Assert.assertEquals(expected,actual);
    }
    @Test(priority = 0)
    public void invalidPostcode()throws InterruptedException{
       cd.findElement(By.id("postcode")).sendKeys("Test");
       cd.findElement(By.id("get-storage-price-v-35")).click();
       WebElement errorCode = (cd.findElement(By.id("notAvailable")));
       Assert.assertTrue(errorCode.isDisplayed());
       System.out.println("Invalid Postcode");
       Thread.sleep(1000);
    }
    @Test(priority = 1)
    public void validPostcode() throws InterruptedException{
        cd.findElement(By.id("postcode")).clear();
//        String actualTitle ="";
        cd.findElement(By.id("postcode")).sendKeys("BN9");
        cd.findElement(By.id("get-storage-price-v-35")).click();

//        String getBookingtitle = "Booking";
//        Thread.sleep(3);
//        actualTitle = cd.getTitle();
//
//        Assert.assertEquals(getBookingtitle, actualTitle);
        System.out.println("Valid Postcode");
        Thread.sleep(1000);
    }
    @AfterClass
    public void afterTest(){
        cd.close();
        cd.quit();
    }
}
