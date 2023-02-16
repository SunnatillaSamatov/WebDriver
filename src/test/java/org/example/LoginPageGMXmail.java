package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageGMXmail {
    private final WebDriver webDriver;

    public LoginPageGMXmail(WebDriver webDriver){
        this.webDriver=webDriver;

    }

    private By loginButtonBy = By.xpath("//a[@id='login-button']");
    private By usernameBy = By.xpath("//input[@id='login-email']");
    private By passwordBy = By.xpath("//input[@id='login-password']");
    private By signInBy = By.xpath("//button[@class='btn btn-block login-submit']");

    public UserHomePageGMXmail loginWithCredentials(String userName, String password){

        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(loginButtonBy));
        webDriver.findElement(loginButtonBy).click();
        webDriver.findElement(usernameBy).sendKeys(userName);
        webDriver.findElement(passwordBy).sendKeys(password);
        webDriver.findElement(signInBy).click();

        return new UserHomePageGMXmail(webDriver);
    }



}
