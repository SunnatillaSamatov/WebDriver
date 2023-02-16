package org.example;

import org.openqa.selenium.By;
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
        webDriver.switchTo().frame(webDriver.findElement(By.cssSelector("iframe.permission-core-iframe")));
        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//iframe[@sandbox='allow-forms allow-popups allow-popups-to-escape-sandbox allow-same-origin allow-scripts']")));

    }
    @Test
    public void testLogInValidUser(){
        PrivacyAgreementGMXmail privacyAgreement = new PrivacyAgreementGMXmail(webDriver);
        LoginPageGMXmail loginPage = privacyAgreement.managePrivacy();
        loginPage.loginWithCredentials("fakeaccout@gmx.com", "fakeaccount365");
        Assert.assertEquals(webDriver.getTitle(),"Free Email Addresses: Web based and secure Email - GMX.com");

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
