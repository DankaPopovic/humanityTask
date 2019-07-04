package pages;


import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
// zasto drzis neiskoriscene importe?
import java.nio.channels.SelectableChannel;

public class LandingPage extends BaseTest {

    @FindBy(xpath = ".//div[@class='mainheading']")
    WebElement mainHeading;

    @FindBy(xpath = "/html/body/div[2]/p[1]")
    WebElement initialText;

    @FindBy(id = "radiobutton")
    WebElement radioButton;

    @FindBy(xpath = ".//div[2]/p[4]/a")
    WebElement homePageButton;

    @FindBy(id = "selecttype")
    WebElement drpDown;

    @FindBy(xpath = ".//input[@name='selected(1234)']")
    WebElement checkBox;


    @FindBy(id = "divontheleft")
    WebElement assertText;

    @FindBy(id = "verifybutton")
    WebElement verifyButton;

    @FindBy(id = "secondajaxbutton")
    WebElement loadTextTothePage;

    @FindBy(id = "storeinput")
    WebElement textBox;


    @FindBy(xpath = ".//*[@id=\"ajaxdiv\"]")
    WebElement hiddenText;

    @FindBy(xpath = ".//div[@class='multiplewindow']")
    WebElement link1;

    @FindBy(xpath = ".//div[@class='multiplewindow2']")
    WebElement link2;

    @FindBy(id = "loadajax")
    WebElement link3;

    @FindBy(id = "html5div")
    WebElement editableTextBox;

    public LandingPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyCurrent() {
        return driver.getCurrentUrl();
    }

    public String getHeadingText() {
        return mainHeading.getText();
    }

    public String getInitialText() {
        return initialText.getText();
    }

    public boolean isRadiobuttonSelected() {
        if (radioButton.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public void checkRadioButton() {
        radioButton.click();
    }

    public void selectOptions(String value) {
        Select drpDownSelVersion = new Select(drpDown);
        drpDownSelVersion.selectByValue(value);
    }
// Preporucljivo je da se promenljive smislenije nazivaju da bi bilo sto vise "human readable" eg. selectedOption umesto tmp
    public String getSelectedTextFromDrpDownMenu() {
        Select select = new Select(drpDown);
        WebElement tmp = select.getFirstSelectedOption();
        return tmp.getText();
    }
// Pre klika fali provera da li je vec selektovan
    public void checkCheckBox() {
        checkBox.click();
    }


    public boolean ischeckBoxSelected() {
        if (checkBox.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public void clickHomePageLink() {
        homePageButton.click();
    }


    public void clickLink1() {
        link1.click();
    }

    public void clickLink2() {
        link2.click();
    }

    public void clickLink3() {
        link3.click();
    }

    public String getAssertText() {
        return assertText.getText();
    }

    public String getTextFromHiddenTextBox() {
        return hiddenText.getAttribute("innerText");
    }

    public void enterTextInTextBox(String text) {
        textBox.sendKeys(text);
    }

    public void pressLoadTextButton() {
        loadTextTothePage.click();
    }

    public String getTextFromETB() {
        return editableTextBox.getText();
    }

    public void enterTextinETB(String text1) {
        enterTextInTextBox(text1);
    }

    public String getValueVerifyButton() {
        return verifyButton.getAttribute("value");
    }

    public boolean verifyButtonIsDisplayed() {
        if (verifyButton.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyButtonEnabled() {
        if (verifyButton.isEnabled()) {
            return true;
        } else {
            return false;
        }

    }

   public String clearBoxFromETB(){
        verifyButton.click();
        return editableTextBox.getText();
   }



    public void  enterTextInClearETB(String textToEnter){
        editableTextBox.clear();
        editableTextBox.sendKeys(textToEnter);
    }


   }


