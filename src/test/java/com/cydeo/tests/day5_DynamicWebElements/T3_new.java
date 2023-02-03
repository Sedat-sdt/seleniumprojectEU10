package com.cydeo.tests.day5_DynamicWebElements;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T3_new {
    @Test
    public void radioBtnTest(){
/*
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        */
/*
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  */

        Driver.getDriver().get("https://practice.cydeo.com/radio_buttons");

        WebElement hockeyBtn = Driver.getDriver().findElement(By.xpath("//input[@id='hockey']"));
        System.out.println("hockeyBtn.isEnabled() = " + hockeyBtn.isEnabled());
        hockeyBtn.click();

        hockeyBtn.isSelected();

        WebElement greenBtn = Driver.getDriver().findElement(By.xpath("//*[@id=\"green\"]"));
        greenBtn.click();
        System.out.println("greenBtn.isSelected() = " + greenBtn.isSelected());
        System.out.println("greenBtn.isEnabled() = " + greenBtn.isEnabled());
        System.out.println("greenBtn.isDisplayed() = " + greenBtn.isDisplayed());


    }
}
