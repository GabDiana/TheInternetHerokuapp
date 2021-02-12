import Exceptions.OurException;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Log4j2
public class BrokenImage {
    public static WebDriver driver;

    @Test
    public void checkHttpRequest() {
        new PageFactory().setUpChrome("https://the-internet.herokuapp.com/broken_images");
        driver = PageFactory.driver;

        List<WebElement> images = driver.findElements(By.cssSelector(".example img"));

        for ( WebElement image : images ) {
            String url = image.getAttribute("src");
            RestAssured.baseURI = url;
            RequestSpecification httpRequest = RestAssured.given();
            Response response = httpRequest.request(Method.GET);
// option 1 with log
            if (response.statusLine().contains("200")) {
                log.info("Status cede is " + response.statusLine());
                assertThat(response.statusLine()).contains("200");
            } else {
                log.info("Status cede is " + response.statusLine());
                assertThat(response.statusLine()).contains("404");
            }
// option 2 with
            try {
                if (response.statusLine().contains("200")) {
                    log.info("Status cede is " + response.statusLine());
                    assertThat(response.statusLine()).contains("200");
                } else {
                    throw new OurException("The status isn't 200");
                }

            } catch (OurException e) {
                log.info("The image isn't loaded");
            }
        }
        driver.quit();
    }
}
