package org.example.drivermanager;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DriverManager {
    private static DriverManager instance;
    private static WebDriver webDriver = null;
    private JavascriptExecutor js = null;
    private Actions actions = null;

    private DriverManager() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications");
        options.addArguments("disable-popup-blocking");
        webDriver = new ChromeDriver(options);
        actions = new Actions(webDriver);
        js = (JavascriptExecutor) webDriver;
        webDriver.manage().window().maximize();
    }

    public static DriverManager getInstance(){
        if (instance == null) {
            instance = new DriverManager();
        }
        return  instance;
    }

    public void goToUrl() {
        webDriver.navigate().to(" http://todomvc.com/examples/vue/");
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public JavascriptExecutor getJs() {
        return js;
    }

    public Actions getActions() {
        return actions;
    }
}
