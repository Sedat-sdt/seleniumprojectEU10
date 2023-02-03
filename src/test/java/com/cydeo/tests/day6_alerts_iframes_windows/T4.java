package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4 {
   WebDriver driver;
    @BeforeMethod

            public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/iframe");
    }

    @Test
    public void iframeTest(){

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));
        //driver.switchTo().frame("mce_0_ifr");

        WebElement messageText = driver.findElement(By.xpath("//body[@id='tinymce']/p"));

        String actualText = messageText.getText();
        String expectedText="Your content goes here.";
        Assert.assertEquals(actualText,expectedText);

        driver.switchTo().parentFrame();

        WebElement editorText = driver.findElement(By.xpath("//h3"));

        Assert.assertEquals(editorText.getText(),"An iFrame containing the TinyMCE WYSIWYG Editor");



    }



}
