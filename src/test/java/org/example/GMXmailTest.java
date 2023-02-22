package org.example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;



public class GMXmailTest {
    WebDriver webDriver;

    @BeforeMethod
    public void launchWebsite(){
        webDriver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium Driver\\chromedriver_win32\\chromedriver.exe");
        webDriver.get("https://www.gmx.com");

    }
    @Test
    public void testLogInValidUser(){
        PrivacyAgreementGMXmail privacyAgreement = new PrivacyAgreementGMXmail(webDriver);
        LoginPageGMXmail loginPage = privacyAgreement.managePrivacy();
        UserHomePageGMXmail homePage = loginPage.loginWithCredentials("fakeaccout@gmx.com", "fakeaccount365");
        Assert.assertTrue(homePage.isLogoutAvialable());

    }
    @Test
    public void testLogInWrongUsername(){

        PrivacyAgreementGMXmail privacyAgreement = new PrivacyAgreementGMXmail(webDriver);
        LoginPageGMXmail loginPage = privacyAgreement.managePrivacy();
        loginPage.loginWithCredentials("fakeaccou", "fakeaccount365");
        Assert.assertEquals(webDriver.getTitle(),"GMX Free E-Mail");

    }

    @Test
    public void testLogInWrongPassword(){

        PrivacyAgreementGMXmail privacyAgreement = new PrivacyAgreementGMXmail(webDriver);
        LoginPageGMXmail loginPage = privacyAgreement.managePrivacy();
        loginPage.loginWithCredentials("fakeaccout@gmx.com", "fakeaccount");
        Assert.assertEquals(webDriver.getTitle(),"GMX Free E-Mail");

    }
    @AfterMethod
    public void terminateTest(){
        webDriver.close();
        webDriver=null;
    }


}
