import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class JqueryUI {
    @Test
    public void jQueryElements() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions hover = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu#");

        List<WebElement> enableButton = new ArrayList<>(driver.findElements(By.cssSelector(".ui-menu-icon.ui-icon.ui-icon-carat-1-e")));
        WebElement element = enableButton.get(1);

        hover.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#ui-id-4")));
        WebElement download = driver.findElement(By.cssSelector("#ui-id-4"));
        hover.moveToElement(download).perform();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#ui-id-5")));
        WebElement pdf = driver.findElement(By.cssSelector("#ui-id-5"));
        hover.moveToElement(pdf).click().perform();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert x = driver.switchTo().alert();
        x.dismiss();
        driver.quit();

    }
}
