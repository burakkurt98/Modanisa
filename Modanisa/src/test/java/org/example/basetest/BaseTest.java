package org.example.basetest;

import org.example.drivermanager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    public void findElementsClick(By byElement){
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getInstance().getWebDriver() , Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(byElement)).click();
    }
    public void setKeys(By byElement,String text) {
        WebDriverWait  webDriverWait = new WebDriverWait(DriverManager.getInstance().getWebDriver() , Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(byElement)).sendKeys(text , Keys.ENTER);
    }
    public String getText(By byElement) {
        WebDriverWait  webDriverWait = new WebDriverWait(DriverManager.getInstance().getWebDriver() , Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(byElement)).getText();
    }
    public void hoverElementAndDeleteClick(By byElement , By byClick) {
        WebElement menu = DriverManager.getInstance().getWebDriver().findElement(byElement);
        DriverManager.getInstance().getActions().moveToElement(menu);
        menu = DriverManager.getInstance().getWebDriver().findElement(byClick);
        DriverManager.getInstance().getActions().moveToElement(menu).click().build().perform();
    }
}
