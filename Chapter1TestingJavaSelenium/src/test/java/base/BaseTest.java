package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wdwait;

    @Before
    public void SetUp(){
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("http://book.theautomatedtester.co.uk/chapter1");


    }

    @After
    public void TearDown(){
        driver.close();
    }
}