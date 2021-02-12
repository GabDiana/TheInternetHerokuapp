import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ContentJsAlert {
    public static WebDriver driver;

    @Test
    public void alert() {
        new PageFactory().setUpChrome("https://the-internet.herokuapp.com/context_menu");
        driver = PageFactory.driver;
        Actions righTclick=new Actions(driver);
        righTclick.contextClick(driver.findElement(By.id("hot-spot"))).perform();
        Alert popup=driver.switchTo().alert();
        popup.accept();
        driver.quit();

    }
}
