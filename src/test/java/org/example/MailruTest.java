package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MailruTest {

    WebDriver webDriver;
    @BeforeMethod
    public void launchWebsite(){

        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium Driver\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.mail.ru");
        webDriver.manage().window().maximize();


    }
    @Test
    public void testValidUser(){
        LoginPageMailru loginPage = new LoginPageMailru(webDriver);
        UserHomePageMailru userHomePageMailru = loginPage.loginWithCredentials("samplefakeaccount365@mail.ru", "&k/TMKgr-Fc.7sB");
        String actualLoggedUsername = userHomePageMailru.getLoggedUsername();
        Assert.assertEquals(actualLoggedUsername,"samplefakeaccount365@mail.ru");
    }
    @Test
    public void testWrongUsername(){
        LoginPageMailru loginPage = new LoginPageMailru(webDriver);
        loginPage.insertUsername("samplefakeaccount@mail.ru");
        loginPage.getUsernameErrorMessage();
        Assert.assertEquals(loginPage.getUsernameErrorMessage(),"That account is not registered");

    }
    @Test
    public void testWrongPassword(){
        LoginPageMailru loginPage = new LoginPageMailru(webDriver);
        loginPage.insertUsername("samplefakeaccount365@mail.ru");
        loginPage.insertPassword("&k/TMKgr-Fc.");
        Assert.assertEquals(loginPage.getPasswordErrorMessage(),"Incorrect password. Try again");

    }
    @AfterMethod
    public void terminate(){
        webDriver.close();
        webDriver = null;
    }

}
