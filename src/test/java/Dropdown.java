import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        //(//div[text()='BLR - Bengaluru, India'])[1]
        //div[@data-testid='search-source-btn']/div[contains(@class,'r-majxgm')]
        //div[text()='BLR - Bengaluru, India'])[1]
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
        driver.findElement(By.xpath("//div[text()='BLR']")).click();
        driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']")).click();
        driver.findElement(By.xpath("//div[text()='MAA']")).click();

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

    }
}
