import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.lang3.RandomStringUtils;

public class CartTest {

    private WebDriver driver;

    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void addToCartAsUserTest() {
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("ramona.mo@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector(".level0:nth-child(5)")).click();
        driver.findElement(By.cssSelector(".product-name a[title~='Dobby']")).click();
        driver.findElement(By.cssSelector(".swatch-label img[alt='Blue']")).click();
        driver.findElement(By.id("option81")).click();
        driver.findElement(By.cssSelector(".add-to-cart span")).click();

        WebElement addedToCartElement = driver.findElement(By.cssSelector(".success-msg span"));
        String addedToCart = addedToCartElement.getText();
    }

    @Test
    public void productStaysInCartAfterLogOutandReLogIn(){
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("ramona.mo@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector(".level0:nth-child(5)")).click();
        driver.findElement(By.cssSelector(".product-name a[title~='Dobby']")).click();
        driver.findElement(By.cssSelector(".swatch-label img[alt='Blue']")).click();
        driver.findElement(By.id("option81")).click();
        driver.findElement(By.cssSelector(".add-to-cart span")).click();
        driver.findElement(By.cssSelector(".header-minicart .label")).click();
        driver.findElement(By.className("close")).click();

        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".last a[title='Log Out']")).click();

        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("ramona.mo@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector(".header-minicart .label")).click();
        driver.findElement(By.className("cart-link")).click();
    }

    @Test
    public void deletingFromCartAsLoggedIn(){
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("ramona.mo@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector(".level0:nth-child(5)")).click();
        driver.findElement(By.cssSelector(".product-name a[title~='Dobby']")).click();
        driver.findElement(By.cssSelector(".swatch-label img[alt='Blue']")).click();
        driver.findElement(By.id("option81")).click();
        driver.findElement(By.cssSelector(".add-to-cart span")).click();
        driver.findElement(By.cssSelector(".header-minicart .label")).click();
        driver.findElement(By.className("cart-link")).click();
        driver.findElement(By.cssSelector(".product-cart-remove .btn-remove")).click();

        WebElement emptyCartElement = driver.findElement(By.cssSelector(".page-title h1"));
        String emptyCart = emptyCartElement.getText();
        Assert.assertTrue(emptyCartElement.isDisplayed());
        Assert.assertEquals("SHOPPING CART IS EMPTY",emptyCart);
    }

    @Test
    public void updateCartQuantityAsLoggedInUser(){
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("ramona.mo@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector(".level0:nth-child(5)")).click();
        driver.findElement(By.cssSelector(".product-name a[title~='Dobby']")).click();
        driver.findElement(By.cssSelector(".swatch-label img[alt='Blue']")).click();
        driver.findElement(By.id("option81")).click();
        driver.findElement(By.cssSelector(".add-to-cart span")).click();
        driver.findElement(By.cssSelector(".header-minicart .label")).click();
        driver.findElement(By.className("cart-link")).click();

        driver.findElement(By.cssSelector(".product-cart-actions .qty")).clear();
        driver.findElement(By.cssSelector(".product-cart-actions .qty")).sendKeys("10");
        driver.findElement(By.cssSelector(".product-cart-actions .btn-update")).click();

    }

    @After
    public void closePage(){
       driver.quit();
    }
}
