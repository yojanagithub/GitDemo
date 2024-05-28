package cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class StreamLivedemo {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//tr/th[@role='columnheader'][1]")).click();
        List<WebElement> elementList=driver.findElements(By.xpath("//tr/td[1]"));
        List<String> orginallist=elementList.stream().map(s->s.getText()).collect(Collectors.toUnmodifiableList());
        List<String> sortedlist=orginallist.stream().sorted().collect(Collectors.toUnmodifiableList());
        Assert.assertEquals(orginallist,sortedlist);
        Assert.assertTrue(orginallist.equals(sortedlist));
        List<String> price;
        //scan the name column with gettext ->Rice->print the price of the Rice
       do {
           List<WebElement> row=driver.findElements(By.xpath("//tr/td[1]"));
          price= row.stream().filter(s->s.getText().contains("Rice"))
                   .map(StreamLivedemo::getPriceVeggiess).collect(Collectors.toList());
           price.forEach(a-> System.out.println(a));
           if (price.size()<1){
               driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
           }
       }while (price.size()<1);


        //driver.close();
    }
    public static String getPriceVeggiess(WebElement s){
    String prices=s.findElement(By.xpath("following-sibling::td[1]")).getText();

        return prices;


    }
}
