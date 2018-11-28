package Booking;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
public class TestCaseOne {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mroni\\IdeaProjects\\UnitedAir\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.americanairlines.com");
        // String downkey = Keys.chord(Keys.DOWN, Keys.DOWN,Keys.C);
        driver.findElement(By.name("originAirport")).clear();
        driver.findElement(By.name("originAirport")).sendKeys("PHL");
        Thread.sleep(3000);
        driver.findElement(By.name("originAirport")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(By.name("destinationAirport")).sendKeys("JFK");
        Thread.sleep(3000);
        driver.findElement(By.name("destinationAirport")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        WebElement passenger = driver.findElement(By.name("adultOrSeniorPassengerCount"));
        Select select = new Select(passenger);
        select.selectByValue("3");
        driver.findElement(By.name("departDate")).click();
        while (!driver.findElement(By.className("ui-datepicker-month")).getText().equalsIgnoreCase("may")) {
            // driver.findElement(By.className("ui-datepicker-title,ui-datepicker-month")).click();
            driver.findElement(By.xpath("//a[@title='Next']")).click();
        }
        int deportdate = driver.findElements(By.xpath("//*[@data-handler='selectDay']")).size();
        for (int i = 0; i < deportdate; i++) {
            String dates = driver.findElements(By.xpath("//*[@data-handler='selectDay']")).get(i).getText();
            if (dates.equalsIgnoreCase("5")) {
                driver.findElements(By.xpath("//*[@data-handler='selectDay']")).get(i).click();
                break;
            }
        }
        driver.findElement(By.name("returnDate")).click();
        while (!driver.findElement(By.className("ui-datepicker-month")).getText().equalsIgnoreCase("september")) {
            // driver.findElement(By.className("ui-datepicker-title,ui-datepicker-month")).click();
            driver.findElement(By.xpath("//a[@title='Next']")).click();
        }
        int retundate = driver.findElements(By.xpath("//*[@data-handler='selectDay']")).size();
        for (int i = 0; i < retundate; i++) {
            String dates = driver.findElements(By.xpath("//*[@data-handler='selectDay']")).get(i).getText();
            if (dates.equalsIgnoreCase("5")) {
                driver.findElements(By.xpath("//*[@data-handler='selectDay']")).get(i).click();
                break;
            }
        }
        driver.findElement(By.cssSelector("[value='Search']")).click();
    }
}


