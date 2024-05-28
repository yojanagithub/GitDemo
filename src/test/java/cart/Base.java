package cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Base {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String[] itemsNeeded={"Cucumber","Tomato","Brocolli","Beans"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
         //button[text()='ADD TO CART']
        AddItems(driver,itemsNeeded);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("promoBtn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }
    public static void AddItems(WebDriver driver,String[] itemsNeeded){

        List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
        int j=0;
        for(int i=0;i<products.size();i++){

            String[] name=products.get(i).getText().split("-");
            String formattedname=name[0].trim();

            //converting array to arraylist
            List itemsNeededList= Arrays.asList(itemsNeeded);
            if (itemsNeededList.contains(formattedname)){
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                    if (j==itemsNeeded.length){
                        break;
            }
        }

    }

}
}

