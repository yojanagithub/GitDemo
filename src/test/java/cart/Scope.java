package cart;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());
        WebElement footerdriver= driver.findElement(By.id("gf-BIG"));
        System.out.println(footerdriver.findElements(By.tagName("a")).size());
        WebElement columndriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int linkscount=columndriver.findElements(By.tagName("a")).size();
        for  (int i=1;i<linkscount;i++) {
            String clickonenter = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonenter);
            Thread.sleep(5000);
        }
            Set<String> abc=driver.getWindowHandles();
            Iterator<String> it=abc.iterator();
            while (it.hasNext()){
                driver.switchTo().window(it.next());
                System.out.println(driver.getTitle());

            }


    }
}


