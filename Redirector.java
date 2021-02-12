import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class Redirector {
    @Test
    public void redirect(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/redirector");
        String firstPage =driver.getCurrentUrl();
        driver.findElement(By.id("redirect")).click();
        assertThat(driver.getCurrentUrl()).isEqualTo("https://the-internet.herokuapp.com/status_codes");
        assertThat(driver.getCurrentUrl()).doesNotContain(firstPage);
    }
}
