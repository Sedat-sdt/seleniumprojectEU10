package com.cydeo.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork3 {
    public static void main(String[] args) {

        //TC #3: Back and forth navigation
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        //3- Click to Gmail from top right.
        WebElement gmailButton=driver.findElement(By.className("gb_j"));
        gmailButton.click();

        //4- Verify title contains:
        //Expected: Gmail
        String expectedTitle="Gmail";
        String actualTitle=driver.getTitle();

        System.out.println(actualTitle);

        if(actualTitle.contains(expectedTitle)){
            System.out.println("PASSED!");
        }else{
            System.out.println("FAILED!");
        }

        //5- Go back to Google by using the .back();
        driver.navigate().back();

        //6- Verify title equals:
        //Expected: Google

        String expectedTitle2="Google";
        actualTitle=driver.getTitle();

        if(actualTitle.equals(expectedTitle2)){
            System.out.println("PASSED!");
        }else {
            System.out.println("FAILED!");
        }
    }
}
/*
Gmail: Ücretsiz, Gizli ve Güvenli E-posta | Google Workspace
PASSED!
PASSED!
 */