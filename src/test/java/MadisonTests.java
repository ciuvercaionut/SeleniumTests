import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;

import static org.junit.Assert.*;

public class MadisonTests {

    @Test
    public void homepageTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/ionutciuverca/IdeaProjects/Sele/src/main/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://qa2.dev.evozon.com/");

        String title = driver.getTitle();

        assertEquals("Madison Island", title);


        String url = driver.getCurrentUrl();
        assertEquals("http://qa2.dev.evozon.com/", url);

        //#header > div > a > img.large
        WebElement logo = driver.findElement(By.cssSelector(".logo"));
        assertTrue(logo.isDisplayed());

        logo.click();
//        driver.findElement(By.cssSelector("#header > div > a > img.large")).click();

        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://qa2.dev.evozon.com/", currentUrl);

        driver.close();
    }
}
