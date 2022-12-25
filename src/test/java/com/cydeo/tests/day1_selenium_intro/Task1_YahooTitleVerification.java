package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.yahoo.com");

        //System.out.println("driver.getTitle() = " + driver.getTitle());
        //driver.getTitle() = Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos

        //Expected:"Yahoo"

        String expectedTitle= "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";

        String actualTitle= driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Title is as expected. Verification PASSED!");
        }else{
            System.out.println("Verification FAILED");
        }

//Title is as expected. Verification PASSED!

/*
TC #1: Yahoo Title Verification
1.Open Chrome browser
2.Go to https://www.yahoo.com
3.Verify title:
Expected: Yahoo
 */

    }
}
