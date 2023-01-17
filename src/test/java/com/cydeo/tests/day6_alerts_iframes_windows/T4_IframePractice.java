package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_IframePractice {
    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        // Create new test and make set ups
        //1. Open browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");


    }
    //@Ignore
    @Test
    public void iframe_test(){
        //3. Assert: “Your content goes here.” Text is displayed.
        //we need to switch driver's focus to iframe from the parent html

        //option1:  switching to iframe using id attribute value
        driver.switchTo().frame("mce_0_ifr");

        //option2:   switching to iframe using passing index number of iframe
        //driver.switchTo().frame(0);

        //option 3:  locate as web element and pass in frame() method
        driver.findElement(By.xpath("//iframe[@id='mce_0_ifr'"));


        WebElement yourContentGoesHereText=driver.findElement(By.xpath("//p"));

        Assert.assertTrue(yourContentGoesHereText.isDisplayed());
        //4. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”

        //To be Able to verify the headerof iframe, we must switch back to main "HTML"

        driver.switchTo().parentFrame();

        WebElement headerText= driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(headerText.isDisplayed());

        String expectedheaderText="An iFrame containing the TinyMCE WYSIWYG Editor";
        String actualheaderText=headerText.getText();

        Assert.assertEquals(actualheaderText,expectedheaderText,"actual header text is not same as expected one!");


    }


}
