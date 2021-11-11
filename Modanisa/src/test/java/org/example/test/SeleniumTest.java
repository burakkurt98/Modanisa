package org.example.test;

import org.example.basetest.BaseTest;
import org.example.drivermanager.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;
import org.apache.log4j.Logger;

public class SeleniumTest {

    final static Logger logger = Logger.getLogger(SeleniumTest.class);

    @Before
    public void setUp() {
        DriverManager.getInstance().goToUrl();
    }
    
    @Test
    public void webSiteTest(){
        BaseTest baseTest = new BaseTest();

        logger.info("Go to todos Page");
        logger.info("Step -1");
        baseTest.setKeys( By.cssSelector("input[autofocus=\"autofocus\"]") , "buy some milk");
        assertEquals(baseTest.getText(By.cssSelector("div  label")),"buy some milk");

        logger.info("Step -2");
        baseTest.setKeys( By.cssSelector("input[autofocus=\"autofocus\"]") , "enjoy the assignment");
        assertEquals(baseTest.getText(By.cssSelector("li:nth-child(1)  div  label")),"buy some milk");
        assertEquals(baseTest.getText(By.cssSelector("li:nth-child(2)  div  label")),"enjoy the assignment");

        logger.info("Step -3");
        baseTest.findElementsClick(By.cssSelector("li:nth-child(2)  div  input"));
        baseTest.findElementsClick(By.cssSelector("button[class=\"clear-completed\"]"));
        baseTest.findElementsClick(By.cssSelector("li:nth-child(1)  div  input"));
        assertEquals(baseTest.getText(By.cssSelector("div  label")),"buy some milk");

        logger.info("Step -4");
        baseTest.findElementsClick(By.cssSelector("li:nth-child(1)  div  input"));
        assertEquals(baseTest.getText(By.cssSelector("div  label")),"buy some milk");

        logger.info("Step -5");
        baseTest.findElementsClick(By.cssSelector("li:nth-child(1)  div  input"));
        baseTest.findElementsClick(By.cssSelector("button[class=\"clear-completed\"]"));
        baseTest.setKeys( By.cssSelector("input[autofocus=\"autofocus\"]") , "rest for a while");
        baseTest.hoverElementAndDeleteClick( By.cssSelector("div  label") , By.cssSelector("button[class=\"destroy\"]"));

        logger.info("Step -6");
        baseTest.setKeys( By.cssSelector("input[autofocus=\"autofocus\"]") , "rest for a while");
        baseTest.setKeys( By.cssSelector("input[autofocus=\"autofocus\"]") , "drink water");
        baseTest.hoverElementAndDeleteClick(By.cssSelector("li[class=\"todo\"]:nth-child(1)") , By.cssSelector("button[class=\"destroy\"]"));
        assertEquals(baseTest.getText(By.cssSelector("div  label")),"drink water");
        logger.info("Finish Test");
    }

    @After
    public void tearDown(){
        DriverManager.getInstance().getWebDriver().close();
        DriverManager.getInstance().getWebDriver().quit();
    }
}
