package com.cydeo.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_Library_LoginPage {
    public static void main(String[] args) {

        //TC #4: Library verifications
        WebDriverManager.chromedriver().setup();

        // 1. Open a chrome browser
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://library2.cybertekschool.com/login.html
        driver.get("https://library2.cybertekschool.com/login.html");

        //3. Enter username: “incorrect@email.com”
        WebElement userNameInput= driver.findElement(By.className("form-control"));
        userNameInput.sendKeys("incorrect@email.com");

        //4. Enter password: “incorrect password”
        WebElement passwordInput=driver.findElement(By.id("inputPassword"));
        passwordInput.sendKeys("incorrect password");

        //5.click to signin button
        WebElement signInButton= driver.findElement(By.tagName("button"));
        signInButton.click();

        //5. Verify: visually “Sorry, Wrong Email or Password”
        //displayed
        //PS: Locate username input box using “className” locator

        //Locate password input box using “id” locator
        //Locate Sign in button using “tagName” locator



    }
}
