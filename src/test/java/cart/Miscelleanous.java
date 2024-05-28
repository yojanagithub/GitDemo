package cart;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.IOException;

public class Miscelleanous {
    public static void main(String[] args) throws IOException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().deleteCookieNamed("asdf");
        //deletesession cookies
        driver.get("https://www.google.com/");
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copy(src,new File("C://screenshot.png"));
        FileUtils.copyFile(src,new File("C:\\Users\\yojan\\SeleniumScreenshots\\screenshot.png"));

    }
}
