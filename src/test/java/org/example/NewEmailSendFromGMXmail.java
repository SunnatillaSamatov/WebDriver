package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewEmailSendFromGMXmail {

    private final WebDriver webDriver;

    private By homeIframeBy = By.cssSelector("iframe[name='home']");
    private By unreadEmailBy = By.xpath("//a[@class='iac inbox-link'][@data-iac-usecase='inbox_unread']");
    private By thirdPartyIframeBy = By.id("thirdPartyFrame_mail");
    private By newMailComposeButtonBy = By.xpath("//a[@class='m-button button-cta button-size-large button-block button-link js-component']");
    private By recipientBy =By.xpath("//input[@class='select2-input']");
    private By subjectBy = By.xpath("//input[@class='mailobjectpanel-textfield_input']");
    private By messageBodyIframeBy = By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']");
    private By messageBodyBy =By.id("body");
    private By messageSendButtonBy = By.id("compose-send-button");



    public NewEmailSendFromGMXmail(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public UserHomePageGMXmail sendTextEmail(String subject, String recipient,String messageTextBody ){

        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(homeIframeBy));
        webDriver.switchTo().frame(webDriver.findElement(homeIframeBy));

        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(unreadEmailBy));
        webDriver.findElement(unreadEmailBy).click();

        webDriver.switchTo().defaultContent();
        webDriver.switchTo().frame(webDriver.findElement(thirdPartyIframeBy));

        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(newMailComposeButtonBy));
        webDriver.findElement(newMailComposeButtonBy).click();

        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(recipientBy));
        webDriver.findElement(recipientBy).sendKeys(recipient);

        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(subjectBy));
        webDriver.findElement(subjectBy).sendKeys(subject);

        webDriver.switchTo().frame(webDriver.findElement(messageBodyIframeBy));
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(messageBodyBy));
        webDriver.findElement(messageBodyBy).sendKeys(messageTextBody);

        webDriver.switchTo().defaultContent();
        webDriver.switchTo().frame(webDriver.findElement(thirdPartyIframeBy));

        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(messageSendButtonBy));
        webDriver.findElement(messageSendButtonBy).click();

        return new UserHomePageGMXmail(webDriver);
    }

}
