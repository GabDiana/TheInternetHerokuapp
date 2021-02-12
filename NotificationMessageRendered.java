import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class NotificationMessageRendered {

    @Test
    public void messageVerification() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.cssSelector("p a")).click();
        String message = driver.findElement(By.cssSelector(".flash")).getText();
        if (message.contains("Action successful")) {
            assertThat(message).contains("Action successful");
        } else
            assertThat(message).contains("Action unsuccesful, please try again");
        driver.quit();
    }
}
