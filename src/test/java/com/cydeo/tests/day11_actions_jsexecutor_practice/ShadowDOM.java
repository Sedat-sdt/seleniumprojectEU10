package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ShadowDOM {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void shadowDOM_UsualWay() throws InterruptedException {

        driver.get("https://www.alodokter.com/");
        Thread.sleep(2000);

        WebElement firstName = driver.findElement(By.xpath("//*[@id='searchSpecialities']"));
        firstName.sendKeys("Ziya");
    }

    @Test
    public void shadowDOM_Open() throws InterruptedException {

        driver.get("https://www.alodokter.com/");
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Shadow Root - Open
        String str = "document.querySelector(\"hero-view\").shadowRoot.querySelector(\"#searchSpecialities\").value = \"Ziya\"";
        js.executeScript(str);

        //How to get text of the webElement with JS code if you may need any time later
        String getMyElementText = "return document.querySelector(\"hero-view\").shadowRoot.querySelector(\"h1.hero-title\").textContent";
        String text = (String) js.executeScript(getMyElementText);
        System.out.println("My web element text = " + text);
    }


    @Test
    public void shadowDOM_Closed() throws InterruptedException {

        driver.get("https://letcode.in/shadow");
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Shadow Root - Closed
        String str1 = "document.querySelector(\"my-web-component\").myRoot.querySelector(\"#lname\").value=\"Smith\"";
        js.executeScript(str1);
    }
}
