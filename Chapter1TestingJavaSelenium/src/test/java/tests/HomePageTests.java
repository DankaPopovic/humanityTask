package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.LandingPage;

public class HomePageTests extends BaseTest {

    HomePage homePage;
    LandingPage landingPage;

    @Before
    public void SetUpHomePage(){
        homePage = new HomePage();
        landingPage = new LandingPage();

    }
// Dugme je na langingpage (zasto landing page btw) zasto test nije u toj klasi?
    @Test
    public void VerifyHomePageUrl(){
        landingPage.clickHomePageLink();
        Assert.assertEquals("http://book.theautomatedtester.co.uk/", homePage.verifyCurrent());
    }



}
