import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class DragAndDrop {
    public static WebDriver driver;

    @Test
    public void dragAndDrop() {
        new PageFactory().setUpChrome("https://the-internet.herokuapp.com/drag_and_drop");
        driver = PageFactory.driver;
        WebElement a = driver.findElement(By.id("column-a"));
        WebElement b = driver.findElement(By.id("column-b"));
        assertThat(a.getText()).contains("A");
        assertThat(b.getText()).contains("B");

        Actions dranAndDropAction = new Actions(driver);
        dranAndDropAction.dragAndDrop(a, b);
        dranAndDropAction.build().perform();
        assertThat(a.getText()).contains("B");
        assertThat(b.getText()).contains("A");
    }
}
