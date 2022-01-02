import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class LoginTest {

    private WebDriver driver;

    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void loginWithValidCredentials(){
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("ramona.mo@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        WebElement welcomeTextElement = driver.findElement(By.cssSelector(".hello strong"));
        String welcomeText = welcomeTextElement.getText();
//        if (welcomeText.equals("Hello, Ramona Mo!"))
//            System.out.println("Success");
//        else {
//            System.err.println("Fail");
//        }
        Assert.assertTrue(welcomeTextElement.isDisplayed());
        Assert.assertEquals("Hello, Ramona Mo!", welcomeText);
    }

    @Test
    public void loginWithInvalidCredentials(){
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("ramona.mo@mailinator.org");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        WebElement invalidTextElement = driver.findElement(By.cssSelector(".error-msg span"));
        String invalidText = invalidTextElement.getText();

//        if (text.equals("Invalid login or password."))
//            System.out.println("Success");
//        else
//            System.err.println("Fail");

        Assert.assertTrue(invalidTextElement.isDisplayed());
        Assert.assertEquals("Invalid login or password.", invalidText);

        WebElement stateDropdown = driver.findElement(By.id("billing:region_id"));
        Select select = new Select(stateDropdown);
        select.selectByIndex(1);
        select.selectByVisibleText("Alaska");
    }

    @After
    public void closePage(){
        driver.quit();
    }
    }

