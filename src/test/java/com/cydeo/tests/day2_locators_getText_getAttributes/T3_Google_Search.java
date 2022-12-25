package com.cydeo.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_Google_Search {
    public static void main(String[] args) {

       // TC#3: Google search
        WebDriverManager.chromedriver().setup();

       // 1- Open a chrome browser
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

       //  2- Go to: https://google.com
        driver.get("https://google.com");

       // 3- Write “apple” in search box
        // 4- Click google search button(press enter using keys.enter)
        WebElement googleSearchBox=driver.findElement(By.name("q"));

        googleSearchBox.sendKeys("apple"+ Keys.ENTER);

        // 5- Verify title:
       // Expected: Title should start with “apple” word

        String expectedInTitle= "apple";
        String actualTitle=driver.getTitle();

        if(actualTitle.startsWith(expectedInTitle)){
            System.out.println("PASS!");
        }else {
            System.out.println("FAILED!");
        }





    }
}
