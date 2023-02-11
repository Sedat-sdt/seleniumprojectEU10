package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropDownPractices {
    public WebDriver driver;

    //1. Open Chrome browser
    @BeforeMethod
    public void setupMethod(){
      driver= WebDriverFactory.getDriver("chrome");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to http://practice.cydeo.com/dropdown
      driver.get("http://practice.cydeo.com/dropdown");
    }

  /*  @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }*/

    @Test
    public void stateDropDown_Task5(){


        //we located the dropdown and it is ready to  use now
        Select stateDropDown= new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3. Select Illinois

        stateDropDown.selectByVisibleText("Illinois");

        //4. Select Virginia

        stateDropDown.selectByValue("VA");

        //5. Select California

        stateDropDown.selectByIndex(5);

        //6. Verify final selected option is California.
        String expectedOptionText= "California";
        String actualOptionText= stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOptionText,expectedOptionText);

        //Use all Select options. (visible text, value, index)
    }

    @Test
    public void dateDropDownTest(){
        //TC #6: Selecting date on dropdown and verifying
        //3. Select “December 1st, 1923” and verify it is selected.

        Select yearDropDown= new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropDown= new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropDown= new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //Select year using : visible text
        yearDropDown.selectByVisibleText("1924");
        //Select month using : value attribute
        monthDropDown.selectByValue("11");
        //Select day using : index number
        dayDropDown.selectByIndex(0);

        String expectedYear="1924";
        String expectedMonth="December";
        String expectedDay="1";

        String actualYear=yearDropDown.getFirstSelectedOption().getText();
        String actualMonth=monthDropDown.getFirstSelectedOption().getText();
        String actualDay=dayDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualYear,expectedYear);
        Assert.assertEquals(actualMonth,expectedMonth);
        Assert.assertEquals(actualDay,expectedDay);



    }


}
