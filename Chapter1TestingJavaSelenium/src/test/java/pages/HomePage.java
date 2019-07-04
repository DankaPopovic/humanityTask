package pages;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {

    @FindBy(xpath = ".//div[@class='mainbody']")
    WebElement mainHomePageText;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyCurrent() {
        return driver.getCurrentUrl();
    }

}
