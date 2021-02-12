import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

@Log4j2
public class Checkboxes {
    public static WebDriver driver;

    @Test
    public void checkbox() {
        new PageFactory().setUpChrome("https://the-internet.herokuapp.com/checkboxes");
        driver = PageFactory.driver;
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input"));
        for ( WebElement checkbox : checkboxes ) {
            checkbox.click();
            if (checkbox.isSelected()) {
                checkbox.click();
                log.info(checkbox.getAttribute("checked"));
            } else {
                log.info(checkbox.getAttribute("checked"));
            }
        }
        driver.quit();
    }
}
