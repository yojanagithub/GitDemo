import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction {

    static WebDriver driver;
    public static void main(String[] args) {
        //Invoking Browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.20.0");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();

    }
}
