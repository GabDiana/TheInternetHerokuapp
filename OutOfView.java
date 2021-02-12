import lombok.SneakyThrows;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class OutOfView {
    public static WebDriver driver;

    @SneakyThrows
    @Test
    public void outOfViewPoint() {
        new PageFactory().setUpChrome("https://the-internet.herokuapp.com/exit_intent");
        driver = PageFactory.driver;
        Robot outOfViewPoint = new Robot();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".example p")));
        String currentUrl = driver.getWindowHandle();
        outOfViewPoint.mouseMove(300, 300);
        outOfViewPoint.mouseMove(-10, -10);

        for ( String modal : driver.getWindowHandles() ) {
            if (modal != currentUrl) {
                driver.switchTo().window(modal);
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".modal-footer")));
                driver.findElement(By.cssSelector(".modal-footer p")).click();
            }
        }
        driver.switchTo().window(currentUrl);
        driver.quit();
    }
}
