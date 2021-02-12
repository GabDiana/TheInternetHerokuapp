import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class DropDown {
    public static WebDriver driver;

    @Test
    public void dropDown() {
        new PageFactory().setUpChrome("https://the-internet.herokuapp.com/dropdown");
        driver = PageFactory.driver;
        List<WebElement> elements = driver.findElements(By.cssSelector("option"));
        for ( WebElement element : elements ) {
            log.info(element.getText());
            if (element.getText().contains("Option 1")) {
                element.click();
            }
        }
    }
}
