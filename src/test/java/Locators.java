import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("hello12");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.className("error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abc@123");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@123");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9834334323");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.cssSelector("button[class*='login-btn']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("rahulshetty");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

    }
}
