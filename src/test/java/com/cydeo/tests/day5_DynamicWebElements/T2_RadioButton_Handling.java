package com.cydeo.tests.day5_DynamicWebElements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T2_RadioButton_Handling {
    public static void main(String[] args) {

        //1. Open Chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        //3. Click to “Hockey” radio button
        WebElement radioButtonHockey=driver.findElement(By.xpath("//input[@id='hockey']"));
        //WebElement radioButtonHockey=driver.findElement(By.cssSelector("input#hockey"));

        radioButtonHockey.click();

        //4. Verify “Hockey” radio button is selected after clicking

        //System.out.println("radioButtonHockey.isSelected() = " + radioButtonHockey.isSelected());//true

        if(radioButtonHockey.isSelected() ){
            System.out.println("Button is selected. Verification PASSED!");
        }else {
            System.out.println("Button is not selected. Verification FAILED!");
        }
    }
}
