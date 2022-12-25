package com.cydeo.tests.tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class userNameAndPassword {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://app.vytrack.com/user/login");

        WebElement userNameBox= driver.findElement(By.id("prependedInput"));
        userNameBox.sendKeys("abcd");

        WebElement passwordBox= driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys("abcd");

        WebElement loginButton= driver.findElement(By.id("_submit"));
        loginButton.click();

        WebElement alertMessage= driver.findElement(By.className("alert"));

        String actualMessage=alertMessage.getText();
        String expectedMessage="Invalid user name or password.";

        if(actualMessage.equals(expectedMessage)){
            System.out.println("PASSED!");
        }else {
            System.out.println("FAILED!");
        }

        String actualURL=driver.getCurrentUrl();

        if(actualURL.contains("vytrack")){
            System.out.println("PASSED!");
        }else {
            System.out.println("FAILED!");
        }

        driver.findElement(By.partialLinkText("Forgot")).click();

        String actualTitle=driver.getTitle();
        String expectedTitle="Forgot Password";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("PASSED!");
        }else {
            System.out.println("FAILED!");
        }












    }
}
