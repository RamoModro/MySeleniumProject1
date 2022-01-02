import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class SearchFldTest {

    private WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

        @Test
        public void searchResultsMatchSearchedKeyword(){
            String keyword = RandomStringUtils.randomAlphanumeric(20) + "keyword";
            driver.findElement(By.id("search")).sendKeys(keyword);
        }


    @After
    public void closePage(){
        driver.quit();
    }
}

