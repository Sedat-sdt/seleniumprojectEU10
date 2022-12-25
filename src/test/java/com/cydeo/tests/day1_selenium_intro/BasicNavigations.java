package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {

        //setup browser driver
        WebDriverManager.chromedriver().setup();
        //create web driver
        //open empty browser
        WebDriver driver=new ChromeDriver();

        //This is the line will maximize the browser page
        driver.manage().window().maximize();

        ///driver.manage().window().fullscreen(); it doesn't work for windows



        //go to tesla.com
        driver.get("https://www.tesla.com");

        String currentTitle= driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);//Electric Cars, Solar & Clean Energy | Tesla

        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        //stop code execution for 3 seconds
        Thread.sleep(3000);

        //use selenium to navigate back
        driver.navigate().back();

        //stop code execution for 3 seconds
        Thread.sleep(3000);

        //use selenium to navigate back
        driver.navigate().forward();

        //stop code execution for 3 seconds
        Thread.sleep(3000);

        //use selenium to navigate refresh
        driver.navigate().refresh();

        Thread.sleep(3000);
        //use navigate().to():
        driver.navigate().to("https://www.google.com");


        //get the title of the page
        //System.out.println("driver.getTitle() = " + driver.getTitle());

        currentTitle= driver.getTitle();// since we reassign, we didn't use variable name
        System.out.println("currentTitle = " + currentTitle);  //google

        //get the current URL using selenium
        currentURL = driver.getCurrentUrl();  //re assign
        System.out.println("currentURL = " + currentURL);

        //this will close the currently opened window
        driver.close();

        //this will close all of the opened window
        driver.quit();



    }
}
