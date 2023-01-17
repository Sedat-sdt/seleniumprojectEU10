package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_AlertPractices {
    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //C #1: Information alert practice
        //1. Open browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2. Go to website: http://practice.cydeo.com/javascript_alerts

        driver.get("http://practice.cydeo.com/javascript_alerts");

    }
    @Test
    public void alertButtonTest(){

        //3. Click to “Click for JS Alert” button

        WebElement alertButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));

        alertButton.click();

        Alert alert= driver.switchTo().alert();

        //4. Click to OK button from the alert
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.

        WebElement resultAlert= driver.findElement(By.xpath("//p[.='You successfully clicked an alert']"));


        Assert.assertTrue(resultAlert.isDisplayed(),"Result text is not displayed");

        String expectedResultAlert="You successfully clicked an alert";
        String actualResultAlert=resultAlert.getText();

        Assert.assertEquals(actualResultAlert,expectedResultAlert,"Actual result text is not as expected!");

    }

    @Test
    public void alertButtonTest2(){

        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        //3. Click to “Click for JS Confirm” button
        WebElement confirmButton=driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmButton.click();

        //4. Click to OK button from the alert
        Alert alert=driver.switchTo().alert();
        alert.accept();
        //alert.dismiss();
        //alert.senKeys("hello");


        //5. Verify “You clicked: Ok” text is displayed.

       WebElement alertText= driver.findElement(By.xpath("//p[.='You clicked: Ok']"));

       Assert.assertTrue(alertText.isDisplayed(),"Result text is NOT displayed");

       String expectedText="You successfully clicked an alert";
       String actualText=alertText.getText();

       Assert.assertEquals(actualText,expectedText,"Actual result text is not as expected!!!");
}
    @Test
    public void alertButtonTest3(){

        //3. Click to “Click for JS Prompt” button

        WebElement promptButton=driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        promptButton.click();

        //4. Send “hello” text to alert
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("hello");

        //5. Click to OK button from the alert
        alert.accept();

        //6. Verify “You entered: hello” text is displayed
        WebElement resultMessageText=driver.findElement(By.xpath("//p[.='You entered: hello']"));
        Assert.assertTrue(resultMessageText.isDisplayed(),"Result message is not displayed!");

        String expectedMessageText="You entered: hello";
        String actualMessageText=resultMessageText.getText();

        Assert.assertEquals(actualMessageText,expectedMessageText,"Actual message is not same as expected one!");


    }



}


