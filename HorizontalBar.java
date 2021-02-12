import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HorizontalBar {
    public static WebDriver driver;

    @Test
    public void dynamicContent() {
        new PageFactory().setUpChrome("https://the-internet.herokuapp.com/horizontal_slider");
        driver = PageFactory.driver;
        WebElement input = driver.findElement(By.cssSelector("input"));
        Actions move=new Actions(driver);
       move.dragAndDropBy(input,20,0).perform();
    }
}
