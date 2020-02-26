import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class TestsWithGoodSelectors {
    WebDriver driver;

    @Before
    public void pageSetup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/ionutciuverca/IdeaProjects/Sele/src/main/drivers/chromedriver.exe");
       driver = new ChromeDriver() ;
       driver.get("http://qa2.dev.evozon.com/");
    }

    @Test
    public void accountTest(){

//        #header > div > div.skip-links > div > a

        driver.findElement(By.cssSelector("div.account-cart-wrapper a")).click();
        WebElement dropdown = driver.findElement(By.cssSelector("#header-account"));

        assertTrue(dropdown.isDisplayed());


        String dropdownString = driver.findElement(By.cssSelector("#header-account")).getText().toLowerCase();

        assertTrue(dropdownString.contains("account"));

    }

    @Test
    public void languagesTest(){

        List<WebElement> languages = driver.findElements(By.cssSelector("#select-language > option"));
        System.out.println("Number of languages for this webpage is : " +languages.size());

        assertEquals(3, languages.size());

        WebElement languageElement = driver.findElement(By.id("select-language"));
        Select languageOptions = new Select(languageElement);
        languageOptions.selectByVisibleText("French");
    }

    @Test
    public void searchTest(){
        WebElement search = driver.findElement(By.id("search"));
        search.clear();
        search.sendKeys("tees");

        //#search_mini_form > div.input-box > button
        WebElement submitSearch = driver.findElement(By.cssSelector("button[title=\"Search\"]"));
        submitSearch.click();

        //body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.sorter > div > label
        //body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.sorter > div > label
        WebElement sortElem = driver.findElement(By.cssSelector(".category-products>.toolbar .sort-by"));

        assertTrue(sortElem.isDisplayed());

        //body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.page-title > h1
        String searchTitle = driver.findElement(By.cssSelector("div.page-title")).getText().toLowerCase();

        assertTrue(searchTitle.contains("tees"));
    }

    @Test
    public void navigationTest(){
        List<WebElement> headline = driver.findElements(By.cssSelector(".level0.parent"));
//
//        Iterator<WebElement> itr = headline.iterator();
//        while (itr.hasNext()) {
//            System.out.println(itr.next().getText());
//            System.out.println("--------****-----");
//        }

        //#nav > ol > li.level0.nav-5.parent > a
         driver.findElement(By.cssSelector(".nav-5")).click();

       String actualUrl = driver.getCurrentUrl();

        assertEquals("http://qa2.dev.evozon.com/sale.html", actualUrl);
    }

    public WebElement getInputByTitle(String title){
        return driver.findElement(By.cssSelector("li.active input[title='" + title + "']"));
    }

    @Test
    public void checkoutTest(){
        //#nav > ol > li.level0.nav-2.parent > a
        WebElement category = driver.findElement(By.cssSelector(".nav-2"));

        //#nav > ol > li.level0.nav-2.parent > ul > li.level1.nav-2-3
        WebElement subcategory = driver.findElement(By.cssSelector(".nav-2-3"));

        Actions action = new Actions(driver);
        action.moveToElement(category).perform();
        action.moveToElement(subcategory).click().perform();

        WebElement specificElem = driver.findElement(By.cssSelector(".product-image[title*= 'Core']"));
        specificElem.click();




        List<WebElement> colorList = driver.findElements(By.cssSelector("div.input-box li.is-media"));
            Random color = new Random();
            WebElement randomColor = colorList.get(color.nextInt(colorList.size())) ;
            randomColor.click();

            List<WebElement> sizeList = driver.findElements(By.cssSelector("#configurable_swatch_size li[id*=opt]"));
            Random size = new Random();
            WebElement randomSize = sizeList.get(size.nextInt(sizeList.size()));
            randomSize.click();

            WebElement cartButton = driver.findElement(By.cssSelector("div>.btn-cart"));
            cartButton.click();


        WebElement search = driver.findElement(By.id("search"));
        search.clear();
        search.sendKeys("eye");
        //#search_mini_form > div.input-box > button
        WebElement submitSearch = driver.findElement(By.cssSelector("button[title = 'Search']"));
        submitSearch.click();
//        body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.sorter > div > label
        WebElement sortElem = driver.findElement(By.cssSelector(".category-products>.toolbar .sort-by"));

        assertTrue(sortElem.isDisplayed());

        //body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.page-title > h1
        String searchTitle = driver.findElement(By.cssSelector("div.page-title")).getText().toLowerCase();

        assertTrue(searchTitle.contains("eye"));

        WebElement cartButton1 = driver.findElement(By.cssSelector("div>.btn-cart"));
        cartButton1.click();


        WebElement cartList = driver.findElement(By.cssSelector("#shopping-cart-table > tbody tr"));
        List<WebElement> nrOfRows = cartList.findElements(By.tagName("tr"));
        System.out.println("Total number of Rows in the table are : "+ nrOfRows.size());

        assertEquals(2, nrOfRows.size());

        //body > div > div > div.main-container.col1-layout > div > div > div.cart.display-single-price > div.page-title.title-buttons > ul > li > button
        WebElement proccedToCheckoutBtn = driver.findElement(By.cssSelector(".button[title*='Proceed']"));
        proccedToCheckoutBtn.click();

        WebElement radioButtonAsGuest = driver.findElement(By.id("login:guest"));
        radioButtonAsGuest.click();

        WebElement continueButton = driver.findElement(By.cssSelector("#onepage-guest-register-button"));
        continueButton.click();

        getInputByTitle("First Name").sendKeys("John");
        getInputByTitle("Middle Name/Initial").sendKeys("Dossse");
        getInputByTitle("Last Name").sendKeys("Doe");
        getInputByTitle("Email Address").sendKeys("johndoe@mail.com");
        getInputByTitle("Street Address").sendKeys("Somesului");
        getInputByTitle("City").sendKeys("Cluj-Napoca");
        getInputByTitle("Zip/Postal Code").sendKeys("123456789");
        getInputByTitle("Telephone").sendKeys("0745123456");

        WebElement country = driver.findElement(By.cssSelector("select[title='Country']"));
        country.click();
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText("Romania");

        WebElement state = driver.findElement(By.cssSelector("select[title='State/Province']"));
        state.click();
        Select stateSelect = new Select(state);

        stateSelect.selectByVisibleText("Cluj");

        WebElement radioButtonShipToDifferentAddress = driver.findElement(By.cssSelector("input[title*='different']"));
        radioButtonShipToDifferentAddress.click();

        WebElement continueButtonBillingTab = driver.findElement(By.cssSelector("#billing-buttons-container button[title = 'Continue']"));
        continueButtonBillingTab.click();


        boolean shippingTab = driver.findElement(By.id("opc-shipping")).isDisplayed();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#shipping\\:firstname"))).click();

        if(shippingTab) {

            getInputByTitle("First Name").sendKeys("John");
            getInputByTitle("Last Name").sendKeys("Doe");
            getInputByTitle("Street Address").sendKeys("Somesului");
            getInputByTitle("City").sendKeys("Cluj-Napoca");
            getInputByTitle("Zip/Postal Code").sendKeys("123456789");
            getInputByTitle("Telephone").sendKeys("0745123456");

            WebElement countryShipping = driver.findElement(By.cssSelector("#shipping-new-address-form select[title='Country']"));
            countryShipping.click();
            Select countryShippingSelect = new Select(countryShipping);
            countryShippingSelect.selectByVisibleText("Romania");

            WebElement stateShipping = driver.findElement(By.cssSelector("#shipping\\:region_id"));
            stateShipping.click();
            Select stateShippingSelect = new Select(stateShipping);

            stateShippingSelect.selectByVisibleText("Cluj");

            WebElement continueButtonShippingTab = driver.findElement(By.cssSelector("#shipping-buttons-container button[title=\"Continue\"]"));
            continueButtonShippingTab.click();
        }

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".sp-methods dt:first-child")));

           WebElement radioButtonShippingMethod = driver.findElement(By.cssSelector(".sp-methods label[for*='free']"));
           radioButtonShippingMethod.click();


           WebElement continueButtonShippingMethod = driver.findElement(By.cssSelector("#shipping-method-buttons-container button"));
           continueButtonShippingMethod.click();

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#payment-buttons-container button"))).click();


        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title*='Place']"))).click();

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".checkout-onepage-success")));

        WebElement checkoutPageTitle = driver.findElement(By.cssSelector(".page-title >h1"));

        assertTrue(checkoutPageTitle.isDisplayed());

    }

    @After
    public void closePage(){
        driver.close();
    }
}
