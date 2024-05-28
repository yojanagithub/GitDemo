package cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.List;


public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement>links=driver.findElements(By.xpath("//li[@class='gf-li']/a"));
        SoftAssert a=new SoftAssert();
        for (WebElement w:links){

            String url= w.getAttribute("href");
            HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int rescode=conn.getResponseCode();
            System.out.println(rescode);
            a.assertTrue(rescode<400,"broken link"+w.getText()+rescode);

        }
        a.assertAll();


    }
}
