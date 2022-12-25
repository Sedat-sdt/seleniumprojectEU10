package com.cydeo.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T6_Facebook {
    public static void main(String[] args) {
        //TC #1: Facebook title verification
        //1. Open Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

       // 3. Verify title:
        //Expected: “Facebook - Log In or Sign Up”
        if(driver.getTitle().equals("Facebook - Log In or Sign Up")){
            System.out.println("Title PASSED!");
        }else {
            System.out.println("FAILED!");
        }

        //TC #2: Facebook incorrect login title verification
        //1. Open Chrome browser
        ///2. Go to https://www.facebook.com
        //3. Enter incorrect username

        driver.findElement(By.id("email")).sendKeys("abc");

        //4. Enter incorrect password

        driver.findElement(By.id("pass")).sendKeys("abc", Keys.ENTER);


        //5. Verify title changed to:
        //Expected: “Log into Facebook”
        if(driver.getTitle().equals("Log into Facebook")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
        //• Create new class for each task.
        //• There are some tips in the 2nd page for whoever needs it.
        //• Please try to solve yourself first before moving to the tips.









    }
}
