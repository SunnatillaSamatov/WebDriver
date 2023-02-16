package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageMailru {

    private final WebDriver webDriver;

    public LoginPageMailru(WebDriver webDriver){
        this.webDriver=webDriver;

    }

    private By usernameBy = By.xpath("//input[@class='input-0-2-71']");
    private By nextButtonBy = By.cssSelector("button.base-0-2-79.primary-0-2-93");
    private By passwordBy = By.xpath("//input[@class='input-0-2-71 withIcon-0-2-72']");
    private By submitButtonBy = By.xpath("//button[@class='base-0-2-79 primary-0-2-93']");
    private By usernameErrorBy = By.xpath("//small[@class='base-0-2-25 small-0-2-34 error-0-2-40']");
    private By passwordErrorBy = By.xpath("//div[@data-test-id='password-input-error']");


    public UserHomePageMailru loginWithCredentials(String username, String password){

        insertUsername(username);
        insertPassword(password);
        webDriver.switchTo().defaultContent();
        return new UserHomePageMailru(webDriver);

    }

    public void insertUsername(String username){
        webDriver.findElement(usernameBy).sendKeys(username);
        webDriver.findElement(nextButtonBy).click();
    }

    public void insertPassword(String password){
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(passwordBy));
        webDriver.findElement(passwordBy).sendKeys(password);
        webDriver.findElement(submitButtonBy).click();
    }

    public String getUsernameErrorMessage(){
        new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(usernameErrorBy));
        WebElement element = webDriver.findElement(usernameErrorBy);
        return element.getText();
    }

    public String getPasswordErrorMessage(){
        new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(passwordErrorBy));
        WebElement element = webDriver.findElement(passwordErrorBy);
        return element.getText();
    }

}
