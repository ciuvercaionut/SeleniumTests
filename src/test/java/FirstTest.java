import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.text.Element;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class FirstTest {

    @Test
    public void goToGoogleHomepage(){
    System.setProperty("webdriver.chrome.driver", "C:/Users/ionutciuverca/IdeaProjects/Sele/src/main/drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("http://qa2.dev.evozon.com/");
    driver.manage().window().maximize();
    String title = driver.getTitle();
        System.out.println(title);
    String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
    driver.findElement(By.cssSelector("#header > div > a > img")).click();

    driver.navigate().to("http://qa2.dev.evozon.com/men/new-arrivals.html");
    driver.navigate().back();
    driver.navigate().forward();
    driver.navigate().refresh();
    driver.quit();
    }

    @Test
    public void accountPageTest(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/ionutciuverca/IdeaProjects/Sele/src/main/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://qa2.dev.evozon.com/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.quit();
    }

    @Test
    public void listOfLanguagesTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/ionutciuverca/IdeaProjects/Sele/src/main/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://qa2.dev.evozon.com/");
        driver.manage().window().maximize();

       List<WebElement> languages = driver.findElements(By.cssSelector("#select-language > option"));
        System.out.println("Number of languages for this webpage is : " +languages.size());
        WebElement element = driver.findElement(By.id("select-language"));
        Select languageOptions = new Select(element);
        languageOptions.selectByVisibleText("French");
        driver.quit();
    }

    @Test
    public void searchTest(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/ionutciuverca/IdeaProjects/Sele/src/main/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://qa2.dev.evozon.com/");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement search = driver.findElement(By.id("search"));
        search.sendKeys("woman");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.quit();
    }

    @Test
    public void newProductsListTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/ionutciuverca/IdeaProjects/Sele/src/main/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://qa2.dev.evozon.com/");

        List<WebElement> newProducts = driver.findElements(By.cssSelector(".item.last"));
        System.out.println("Number of new products is : " + newProducts.size());
//        for (int i = 0; i < newProducts.size(); i++) {
//            System.out.println(i + " " + newProducts.get(i).getText());
//            System.out.println("--------****-----");
//        }

        Iterator<WebElement> itr = newProducts.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next().getText());
            System.out.println("--------****-----");
        }
        System.out.println();
        driver.quit();
    }

    @Test
    public void navigationTest(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/ionutciuverca/IdeaProjects/Sele/src/main/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://qa2.dev.evozon.com/");
        List<WebElement> headline = driver.findElements(By.cssSelector(".level0.parent"));

        Iterator<WebElement> itr = headline.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next().getText());
            System.out.println("--------****-----");
        }
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();


        driver.quit();


    }
}
