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
    private By coreIframeBy = By.cssSelector("iframe.permission-core-iframe");
    private By popUpIframeBy = By.xpath("//iframe[@sandbox='allow-forms allow-popups allow-popups-to-escape-sandbox allow-same-origin allow-scripts']");
    private By agreementButton = By.id("onetrust-accept-btn-handler");

    public LoginPageGMXmail managePrivacy(){

        webDriver.switchTo().frame(webDriver.findElement(coreIframeBy));
        webDriver.switchTo().frame(webDriver.findElement(popUpIframeBy));

        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(agreementButton));
        webDriver.findElement(agreementButton).click();
        return new LoginPageGMXmail(webDriver);

    }


}
