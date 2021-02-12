import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FloatingMenu {
    public static WebDriver driver;
    private static final String SCRIPT = "arguments[0].scrollIntoView();";

    @Test
    public void menuIsAlwaysDisplayed() {
        new PageFactory().setUpChrome("http://the-internet.herokuapp.com/floating_menu");
        driver = PageFactory.driver;
        WebElement menu=driver.findElement(By.id("menu"));

        List<WebElement> p= driver.findElements(By.cssSelector(".scroll.large-10.columns.large-centered p"));
        for ( WebElement pNumber: p ) {
            ((JavascriptExecutor) driver).executeScript(SCRIPT, pNumber);
            assertThat(menu.isDisplayed()).isTrue();
        }
        driver.quit();
    }
}
