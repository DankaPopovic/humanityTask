package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LandingPage;

public class LandingPageTest extends BaseTest {

    LandingPage landingPage;

    @Before
    public void SetUpLandingPage() {
        landingPage = new LandingPage();
    }

    @Test
    public void VerifyCurrentUrl() {
        Assert.assertEquals("http://book.theautomatedtester.co.uk/chapter1", landingPage.verifyCurrent());
    }

    @Test
    public void VerifyHeadingText() {
        Assert.assertEquals("Selenium: Beginners Guide", landingPage.getHeadingText());
    }

    @Test
    public void VerifyInitialText() {
        Assert.assertEquals("If you have arrived here then you have installed Selenium IDE and are ready to start recording your first test.", landingPage.getInitialText());
    }

    @Test
    public void VerifyRadioButton() {
        landingPage.checkRadioButton();
        Assert.assertTrue(landingPage.isRadiobuttonSelected());
    }
// Pogresan Assert, umesto False treba da bude True. Radio button se ne moze odselektovati sem ako se drugi radio batton iz ste grupacije ne selektuje
    @Test
    public void VerifyRadioButtonUnchecking() {
        landingPage.checkRadioButton();
        landingPage.checkRadioButton();
        Assert.assertFalse(landingPage.isRadiobuttonSelected());
    }

    @Test
    public void VerifySelection1() {
        landingPage.selectOptions("Selenium IDE");
        Assert.assertEquals("Selenium IDE", landingPage.getSelectedTextFromDrpDownMenu());
    }

    @Test
    public void VerifySelection2() {
        landingPage.selectOptions("Selenium Code");
        Assert.assertEquals("Selenium Core", landingPage.getSelectedTextFromDrpDownMenu());
    }

    @Test
    public void VerifySelection3() {
        landingPage.selectOptions("Selenium RC");
        Assert.assertEquals("Selenium RC", landingPage.getSelectedTextFromDrpDownMenu());
    }

    @Test
    public void VerifySelection4() {
        landingPage.selectOptions("Selenium Grid");
        Assert.assertEquals("Selenium Grid", landingPage.getSelectedTextFromDrpDownMenu());
    }
// Nisu dobro nazvana dva sledeca testa, slobodno koristi pune reenice u nazivia testa jer na prvi pogled nije najjasnije sta testiras
    @Test
    public void VerifyUnselectedCheckBox() {
        landingPage.checkCheckBox();
        Assert.assertTrue(landingPage.ischeckBoxSelected());
    }
// Umesto try catche mozes da stavis u potpisu metode throws interruptedException
    @Test
    public void VerifySelectedCheckBox() {
        landingPage.checkCheckBox();

        try {
            Thread.sleep(4);
        } catch (InterruptedException e) {
        }

        landingPage.checkCheckBox();
        Assert.assertFalse(landingPage.ischeckBoxSelected());
    }
// Koji tekst?
    @Test
    public void VerifyAssertText() {
        Assert.assertEquals("Assert that this text is on the page", landingPage.getAssertText());
    }
// Koji button
    @Test
    public void VerifyButtonIsDisplayed() {
        Assert.assertTrue(landingPage.verifyButtonIsDisplayed());

    }
// Koji button tekst?
    @Test
    public void VerifyButtonText() {
        Assert.assertEquals("Verify this button is here", landingPage.getValueVerifyButton());
    }
// Zasto clickable ako proveravas da je Enabled?
    @Test
    public void VerifyButtonIsClickable() {
        Assert.assertTrue(landingPage.verifyButtonEnabled());
    }
// Sta je ETB?
    @Test
    public void VerifyButtonClearsETB() {
        String text = landingPage.clearBoxFromETB();
        if (text != "") {
            Assert.assertTrue(false);
        } else {
            Assert.assertTrue(true);
        }

    }

    @Test
    public void VerifyTextFromEditableBox() {
        Assert.assertEquals("To be used after the AJAX section of the book", landingPage.getTextFromETB());
    }

    @Test
    public void VerifyETBisEditable() {
        landingPage.enterTextInClearETB("ABCD avioni");
        Assert.assertEquals("ABCD avioni", landingPage.getTextFromETB());
    }
// Mozes prvo da obrises tekst iz njega umesto da asertujes postojeci tekst + novo dodati tekst
    @Test
    public void VerifyLoadButtonEntersTextinETB() {
        landingPage.enterTextInTextBox("ABCD avioni");
        landingPage.pressLoadTextButton();
        landingPage.getTextFromETB();
        Assert.assertEquals("To be used after the AJAX section of the book\n" +
                "ABCD avioni", landingPage.getTextFromETB());
    }

// Mozes prvo da obrises tekst iz njega umesto da asertujes postojeci tekst + novo dodati tekst
    @Test
    public void CheckingHiddenTextClickLink3() {
        landingPage.clickLink3();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        Assert.assertEquals("The following text has been loaded from another page on this site. It has been loaded in an asynchronous fashion so that we can work through the AJAX section of this chapter", landingPage.getTextFromHiddenTextBox());

}
}