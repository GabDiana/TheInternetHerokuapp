import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class EntryAd {
    public static WebDriver driver;

    @Test

    public void dynamicContent() {
        new PageFactory().setUpChrome("https://the-internet.herokuapp.com/entry_ad");
        driver = PageFactory.driver;
        String currentWindow = driver.getWindowHandle();
        for ( String adwindow : driver.getWindowHandles() ) {
            if (adwindow != currentWindow) {
                driver.switchTo().window(adwindow);
                WebDriverWait wait = new WebDriverWait(driver, 5);
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".modal-title")));
                log.info(driver.findElement(By.cssSelector(".modal-title")).getText());
                driver.findElement(By.cssSelector(".modal-footer p")).click();
            }
        }
        driver.switchTo().window(currentWindow);
    }
}
