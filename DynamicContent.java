import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

@Log4j2
public class DynamicContent {
    public static WebDriver driver;
    public static String txt, txt1;

    @Test
    public void dynamicContent() {
        new PageFactory().setUpChrome("https://the-internet.herokuapp.com/dynamic_content?with_content=static");
        driver = PageFactory.driver;
        List<WebElement> text = driver.findElements(By.cssSelector(".large-10.columns"));
        for ( WebElement getText : text ) {
            txt = getText.getText();
        }
        driver.navigate().refresh();
        List<WebElement> text1 = driver.findElements(By.cssSelector(".large-10.columns"));
        for ( WebElement getText : text1 ) {
            txt1 = getText.getText();
        }

        if (txt.contains(txt1)) {
            log.info("The test passed, the content is the same");
        } else {
            log.info("The content was changed");
        }
    }
}
