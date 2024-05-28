package cart;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class InvokingNewWindow {
    public static void main(String[] args) throws IOException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> win=driver.getWindowHandles();
        Iterator<String>it=win.iterator();
        String parentid=it.next();
        String childid1=it.next();
        driver.switchTo().window(childid1);
        driver.get("https://rahulshettyacademy.com/");
        String coursename=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
        driver.switchTo().window(parentid);
        WebElement NAME=driver.findElement(By.xpath("//div /input[@name='name']"));
                NAME.sendKeys(coursename);
                File file=NAME.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("logo.png"));
        //get height and width
        System.out.println(NAME.getRect().getDimension().getHeight());
        System.out.println(NAME.getRect().getDimension().getWidth());

    }
}
