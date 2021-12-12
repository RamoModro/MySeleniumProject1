import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    public void registerNewUser(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Ramona");
        driver.findElement(By.id("middlename")).sendKeys("Ionela");
        driver.findElement(By.id("lastname")).sendKeys("Modrogan");
        driver.findElement(By.name("email")).sendKeys("ramona.modrogan@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("12345%");
        driver.findElement(By.className("validate-cpassword")).sendKeys("12345%");
        driver.findElement(By.cssSelector("#form-validate > div.fieldset > ul > li.control > label")).click();
        driver.quit();
    }
}
