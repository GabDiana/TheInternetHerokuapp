import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class iFrameTest {
    public static WebDriver driver;

    @Test
    public void menuIsAlwaysDisplayed() {
        new PageFactory().setUpChrome("http://the-internet.herokuapp.com/nested_frames");
        driver = PageFactory.driver;
        String currentWindowHandler = driver.getWindowHandle();
        driver.switchTo().frame("frame-top").switchTo().frame("frame-middle");
        WebElement menu = driver.findElement(By.id("content"));
        assertThat(menu.getText().contains("MIDDLE")).isTrue();
        driver.switchTo().window(currentWindowHandler).switchTo().frame("frame-bottom");
//      driver.switchTo().parentFrame().switchTo().parentFrame().switchTo().frame("frame-bottom");
        driver.quit();
    }
}
