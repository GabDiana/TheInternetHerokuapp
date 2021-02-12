import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageFactory {
public static WebDriver driver;
    public static void setUpChrome(String url){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
         driver=new ChromeDriver();
        driver.get(url);
    }
    public static void setUpFirefox(String url){
        System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
        driver=new FirefoxDriver();
        driver.get(url);
    }

}
