package cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Calendertest {
    public static void main(String[] args) throws InterruptedException {
        String day="11";
        String month="8";
        String year="2027";
        String[] expectedlist={month,day,year};

        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='react-date-picker__calendar-button react-date-picker__button']")).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // Locate the button element using XPath and wait until it is clickable
//        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='react-date-picker__calendar-button react-date-picker__button']")));
//
//        // Click the button
//        button.click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
        driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']")).getText());
       List<WebElement> actuallist= driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
       for (int i=0;i<actuallist.size();i++){
           System.out.println(actuallist.get(i).getAttribute("value"));
           Assert.assertEquals(actuallist.get(i).getAttribute("value"),expectedlist[i]);
       }
       driver.close();


    }
}
