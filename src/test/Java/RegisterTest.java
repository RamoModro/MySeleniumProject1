import org.apache.commons.lang3.RandomStringUtils;
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

        String firstname = RandomStringUtils.randomAlphanumeric(10)+"firstname";
        driver.findElement(By.id("firstname")).sendKeys(firstname);

        String middlename = RandomStringUtils.randomAlphanumeric(10)+"middlename";
        driver.findElement(By.id("middlename")).sendKeys(middlename);

        String lastname = RandomStringUtils.randomAlphanumeric(10)+"lastname";
        driver.findElement(By.id("lastname")).sendKeys(lastname);

        String email = RandomStringUtils.randomAlphanumeric(10)+"@email.com";
        driver.findElement(By.id("email_address")).sendKeys(email);

        String password = RandomStringUtils.randomAlphanumeric(10)+"password";
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.className("validate-cpassword")).sendKeys(password);

        driver.findElement(By.cssSelector(".button[title='Register']")).click();

        WebElement successfullRegistrationElement = driver.findElement(By.cssSelector(".success-msg span"));
        String successfullRegistration = successfullRegistrationElement.getText();

        Assert.assertTrue(successfullRegistrationElement.isDisplayed());
        Assert.assertEquals("Thank you for registering with Madison Island.", successfullRegistration );
    }

    @Test
    public void registerWithDuplicateEmail(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".links [title='Register']")).click();
        String firstname = RandomStringUtils.randomAlphanumeric(10)+"firstname";
        driver.findElement(By.id("firstname")).sendKeys(firstname);

        String middlename = RandomStringUtils.randomAlphanumeric(10)+"middlename";
        driver.findElement(By.id("middlename")).sendKeys(middlename);

        String lastname = RandomStringUtils.randomAlphanumeric(10)+"lastname";
        driver.findElement(By.id("lastname")).sendKeys(lastname);
        driver.findElement(By.id("email_address")).sendKeys("ramona.mo@mailinator.com");
        String password = RandomStringUtils.randomAlphanumeric(10)+"password";
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.className("validate-cpassword")).sendKeys(password);

        driver.findElement(By.cssSelector(".button[title='Register']")).click();

        WebElement duplicateEmailElement = driver.findElement(By.cssSelector(".error-msg span"));
        String duplicateEmail = duplicateEmailElement.getText();
        Assert.assertTrue(duplicateEmailElement.isDisplayed());
        Assert.assertEquals("There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.", duplicateEmail );



    }

        @After
        public void closePage(){
        driver.quit();
    }
}
