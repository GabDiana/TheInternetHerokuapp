import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class MultipleWindows {
    @Test
    public void newWijdows() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://the-internet.herokuapp.com/windows");
        String hrefUrl = driver.findElement(By.cssSelector(".example a")).getAttribute("href");
        driver.findElement(By.cssSelector(".example a")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String firstWindow = driver.getWindowHandle();
        for ( String newWindow : driver.getWindowHandles() ) {
            driver.switchTo().window(newWindow);
        }
        driver.getCurrentUrl();
        assertThat(driver.getCurrentUrl()).isEqualTo(hrefUrl);
        driver.switchTo().window(firstWindow);
    }
}
