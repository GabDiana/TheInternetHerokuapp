import lombok.extern.log4j.Log4j2;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Log4j2
public class AddDeleteElement {
    public static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
//        new ThePageIsLoaded(driver, "https://the-internet.herokuapp.com/add_remove_elements/").get();
    }

    //    @Test
    public void addElement() {
        driver.findElement(By.xpath("//div/button")).click();
        List<WebElement> buttons = driver.findElements(By.id("elements"));
        assertThat(buttons.size()).isGreaterThan(1);
    }

    @Test
    public void deleteElement() {
        driver.findElement(By.xpath("//div/button")).click();
        driver.findElement(By.className("added-manually")).click();
        driver.quit();
    }

    @Test
    public void addDeleteElements() {
        for (int  i=0;i<10;i++ ){
        driver.findElement(By.xpath("//div/button")).click();}
        assertThat(driver.findElements(By.className("added-manually")).size()).isEqualTo(10);
      List<WebElement> delete= driver.findElements(By.className("added-manually"));
        for ( WebElement x:delete ){
            x.click();
        }
        assertThat(driver.findElements(By.className("added-manually")).size()).isEqualTo(0);
        driver.quit();
    }
}
