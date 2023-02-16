package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PrivacyAgreementGMXmail {

    private final WebDriver webDriver;

    public PrivacyAgreementGMXmail(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    private By agreementButton = By.id("onetrust-accept-btn-handler");

    public LoginPageGMXmail managePrivacy(){

        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(agreementButton));
        webDriver.findElement(agreementButton).click();
        return new LoginPageGMXmail(webDriver);

    }


}
