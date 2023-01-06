package com.cydeo.tests.day5_DynamicWebElements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNg_Selenium {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //Do browser driver setup
        //open browser
        driver = WebDriverFactory.getDriver("chrome");

        //max
        driver.manage().window().maximize();

        //imp wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public  void selenium_Test(){

        //get "https://google.com

        driver.get("https://google.com");
        String actualTitle=driver.getTitle();    //also it can run with these
        String expectedTitle="Google";

        //Assert:title is "Google"

        Assert.assertEquals(actualTitle,expectedTitle,"Not matching");
        //Assert.assertEquals(driver.getTitle(),"Google");


    }


}
