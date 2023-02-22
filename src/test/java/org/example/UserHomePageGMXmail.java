package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHomePageGMXmail {

    private final WebDriver webDriver;
    private NewEmailSendFromGMXmail newEmail;

    private By logoutButtonBy = By.xpath("//a[@class='navigator__item navigator__item--logout']");

    public UserHomePageGMXmail(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public void sendTextEmail(String subject, String recipient,String messageTextBody ) throws InterruptedException {

        newEmail = new NewEmailSendFromGMXmail(webDriver);
        newEmail.sendTextEmail(subject, recipient, messageTextBody);


    }

    public boolean isLogoutAvialable(){

        return webDriver.findElement(logoutButtonBy).isDisplayed();
    }
}
