package cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {
    public static void main(String[] args) {
        //chromedriver.chromium.org/capabilities
        ChromeOptions options=new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
    }
}
