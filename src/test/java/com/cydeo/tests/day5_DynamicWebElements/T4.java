package com.cydeo.tests.day5_DynamicWebElements;

import com.cydeo.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4 {

    @Test
    public void dropDownsTest4(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/dropdown");

       /* driver.findElement(By.xpath("//select[@id='dropdown']")).click();

        driver.findElement(By.xpath("//select[@id='dropdown']/option[2]")).click();*/

        Select simpleOption= new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        System.out.println("simpleOption.getFirstSelectedOption().getText() = " + simpleOption.getFirstSelectedOption().getText());

        Assert.assertEquals(simpleOption.getFirstSelectedOption().getText(),"Please select an option");

        simpleOption.selectByVisibleText("Option 1");

        System.out.println("simpleOption.getFirstSelectedOption().getText() = " + simpleOption.getFirstSelectedOption().getText());

        Select stateDropDowns= new Select(driver.findElement(By.xpath("//select[@id='state']")));

        stateDropDowns.selectByIndex(1);//AL

        BrowserUtils.sleep(2);

        stateDropDowns.selectByVisibleText("Alaska");

        BrowserUtils.sleep(2);

        stateDropDowns.selectByValue("AZ");


    }
}
