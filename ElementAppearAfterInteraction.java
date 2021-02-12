import org.assertj.core.api.Condition;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class ElementAppearAfterInteraction {
    public static WebDriver driver;

    @Test
    public void theElementIsHidden() {
        new PageFactory().setUpChrome("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver = PageFactory.driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);


        WebElement startButton = driver.findElement(By.cssSelector("#start button"));
        startButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#finish")));
        WebElement hiddenElement=driver.findElement(By.cssSelector("#finish"));
        assertThat(hiddenElement.isDisplayed()).isTrue();
    }
}