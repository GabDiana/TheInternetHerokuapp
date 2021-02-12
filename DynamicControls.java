
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControls {
    public static WebDriver driver;

    @Test
    public void dynamicContent() {
        new PageFactory().setUpChrome("https://the-internet.herokuapp.com/dynamic_controls");
        driver = PageFactory.driver;
        WebElement input = driver.findElement(By.cssSelector("#input-example input"));
        WebElement enableButton = driver.findElement(By.cssSelector("#input-example button"));
        if (input.isEnabled()) {
            input.sendKeys("HI");
        } else {
            enableButton.click();
            WebDriverWait wait = new WebDriverWait(driver, 7);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("message")));
            input.sendKeys("Write after click on enable button");
            enableButton.click();
        }
        driver.quit();
    }
}
