package com.cydeo.tests.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtility {
    // //Mini-Task: CREATE A CLASS à SmartBearUtils
    //    //• Create a method called loginToSmartBear
    //    //• This method simply logs in to SmartBear when you call it.
    //    //• Accepts WebDriver type as parameter


    public static void logInToSmartBear(WebDriver driver ,String userName,String password){
        WebElement usernameText = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        usernameText.sendKeys(userName);

        WebElement passwordText = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        passwordText.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();

    }

}
