import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@Log4j2
public class DisappearingElements {
    public static WebDriver driver;
    @Test
    public void theListSize(){
        new PageFactory().setUpChrome("https://the-internet.herokuapp.com/disappearing_elements");
        driver=PageFactory.driver;
        List<WebElement> elements=driver.findElements(By.cssSelector("ul li"));
       int sizeBeforeRefresh =elements.size();
       driver.navigate().refresh();
        List<WebElement> elementsAfterRefresh=driver.findElements(By.cssSelector("ul li"));
        int sizeAfterRefresh=elementsAfterRefresh.size();

           if(sizeBeforeRefresh==sizeAfterRefresh){
             log.info("The number of elements are the same after refresh");
        }else {
               log.info("The number of elements changed");
           }
           driver.quit();
    }
}
