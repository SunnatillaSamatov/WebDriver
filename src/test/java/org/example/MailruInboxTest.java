package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MailruInboxTest {

    WebDriver webDriver;
    @BeforeTest
    public void launchWebsite() throws InterruptedException {
        webDriver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium Driver\\chromedriver_win32\\chromedriver.exe");
        webDriver.get("https://www.gmx.com");
        PrivacyAgreementGMXmail privacyAgreement = new PrivacyAgreementGMXmail(webDriver);
        LoginPageGMXmail loginPage = privacyAgreement.managePrivacy();
        UserHomePageGMXmail homePage = loginPage.loginWithCredentials("fakeaccout@gmx.com", "fakeaccount365");
        homePage.sendTextEmail("Title", "\"RealName RealSurname\" <samplefakeaccount365@mail.ru>","Hello World, Good Afternoon Automation");
        Thread.sleep(10000);
    }

    @Test
    public void testMessageContentAndUserMailru()  {
        MailReading sample = new MailReading();
        boolean expected = sample.readMails("FakeName FakeSurname <fakeaccout@gmx.com>", "Hello World, Good Afternoon Automation");
        Assert.assertTrue(expected);
    }
    @AfterTest
    public void terminate(){
        webDriver.close();
    }
}
