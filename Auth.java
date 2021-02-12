import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Auth {
    public static WebDriver driver;

    @Test
    public void auth() {
        String credentials="admin:admin@";
        new PageFactory().setUpChrome("https://" + credentials + "the-internet.herokuapp.com/basic_auth");
        driver =PageFactory.driver;
        WebElement confirmationText=driver.findElement(By.cssSelector(".example p"));
        assertThat(confirmationText.getText()).isEqualTo("Congratulations! You must have the proper credentials.");
        driver.quit();

    }
}
