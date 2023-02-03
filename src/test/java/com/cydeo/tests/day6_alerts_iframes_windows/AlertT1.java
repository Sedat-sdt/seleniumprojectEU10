package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertT1 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts");

    }

    @Test
    public void alertTest(){

        WebElement jsAlertBtn = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlertBtn.click();


        Alert alert=driver.switchTo().alert();
        alert.accept();

        WebElement resultText=driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(resultText.getText(),"You successfully clicked an alert");
    }

    @Test
    public void alertTest2(){
        WebElement jsConfirmBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary'][2]"));

        jsConfirmBtn.click();

        Alert alert=driver.switchTo().alert();

        BrowserUtils.sleep(2);
        alert.accept();

        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertEquals(resultText.getText(),"You clicked: Ok");

        Assert.assertTrue(resultText.isDisplayed());
    }

    @Test
    public void alertTest3(){

        WebElement jsPromptBtn = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPromptBtn.click();
        BrowserUtils.sleep(2);

        Alert alert=driver.switchTo().alert();
        alert.sendKeys("hello");
        BrowserUtils.sleep(2);

        alert.accept();

        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertEquals(resultText.getText(),"You entered: hello");


    }
}
