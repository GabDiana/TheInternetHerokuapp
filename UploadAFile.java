import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.assertThat;
public class UploadAFile {
    public static WebDriver driver;

    @Test
    public void uploadFile() {
        new PageFactory().setUpChrome("https://the-internet.herokuapp.com/upload");
        driver = PageFactory.driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement chooseFileButton = driver.findElement(By.cssSelector("#file-upload"));
        chooseFileButton.sendKeys("C:\\Users\\Asus\\IdeaProjects\\Selenium\\src\\test\\resources\\log4j2.xml");
        driver.findElement(By.cssSelector(".button")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#uploaded-files")));
        assertThat(driver.findElement(By.cssSelector("#uploaded-files")).getText().contains("log4j2.xml")).isTrue();
        driver.quit();
    }
}
