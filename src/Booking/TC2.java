package Booking;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class TC2 {
    public static void main(String[] args) {
        System.setProperty("webdrive.chrome.driver", "C:\\Users\\mroni\\IdeaProjects\\UnitedAir\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.americanairlines.com");
        WebElement footer = driver.findElement(By.id("aa-footer"));
       int linkcout = footer.findElements(By.tagName("a")).size();
       for (int i=0; i<linkcout; i++){
           footer.findElements(By.tagName("a")).get(i).sendKeys(Keys.CONTROL, Keys.ENTER);
       }
       Set<String>window = driver.getWindowHandles();

        Iterator<String> iterator = window.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            driver.switchTo().window(s);
            System.out.println(driver.getTitle());
        }


    }
}
