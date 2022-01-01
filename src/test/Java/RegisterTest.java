import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    private WebDriver driver;

    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void registerNewUser(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".links [title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Ramona");
        driver.findElement(By.id("middlename")).sendKeys("Ionela");
        driver.findElement(By.id("lastname")).sendKeys("Modrogan");
        driver.findElement(By.name("email")).sendKeys("ramona.modrogan@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("12345%");
        driver.findElement(By.className("validate-cpassword")).sendKeys("12345%");
        driver.findElement(By.cssSelector(".button[title='Register']")).click();
    }

    @After
    public void closePage(){
        driver.quit();
    }
}
