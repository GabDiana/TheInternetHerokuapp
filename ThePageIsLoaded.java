import LearningSelenium.PageLoadUtilsClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class ThePageIsLoaded extends LoadableComponent<ThePageIsLoaded> {

        public final WebDriver driver;

    ThePageIsLoaded(WebDriver driver, String url) {
            this.driver = driver;
            this.driver.get(url);
        }

        @Override
        protected void load() {
        }

        @Override
        protected void isLoaded() {
            //indentificam conditia care trebuie sa fie imdeplinita ca pagina sa fie incarcata
            new PageLoadUtilsClass(driver).isElementPresent(By.xpath("//div/button"));
        }

}
