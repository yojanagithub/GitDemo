import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class fluentWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
            driver.findElement(By.cssSelector("[id='start'] button")).click();

            Wait<WebDriver> waitflu = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(3))
                    .ignoring(NoSuchElementException.class);

            WebElement foo = waitflu.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    WebElement element = driver.findElement(By.cssSelector("[id='finish'] h4"));
                    if (element.isDisplayed()) {
                        return element;
                    } else {
                        return null;
                    }
                }
            });

            System.out.println(foo.getText());

        } finally {
            driver.quit();
        }
    }
}