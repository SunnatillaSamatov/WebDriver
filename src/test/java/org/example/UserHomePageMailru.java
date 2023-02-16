package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserHomePageMailru {
    private final WebDriver webDriver;

    private By loggedUserameBy = By.xpath("//span[@class='ph-project__user-name svelte-1hiqrvn']");


    public UserHomePageMailru(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getLoggedUsername(){

          new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(loggedUserameBy));
          WebElement element = webDriver.findElement(loggedUserameBy);

        return element.getText();

    }


}
