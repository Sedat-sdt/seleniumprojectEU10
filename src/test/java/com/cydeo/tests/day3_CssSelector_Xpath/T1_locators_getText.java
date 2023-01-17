package com.cydeo.tests.day3_CssSelector_Xpath;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_locators_getText {
    public static void main(String[] args) {

        // TC #1: NextBaseCRM, locators and getText() practice
        //1- Open a chrome browser

       // WebDriverManager.chromedriver().setup();
       // WebDriver driver= new ChromeDriver();

      WebDriver driver= WebDriverFactory.getDriver("chrome");// from utility package

        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Enter incorrect username: “incorrect”

        //driver.findElement(By.name("USER_LOGIN")).sendKeys("incorrect");
        WebElement inputUsername=driver.findElement(By.name("USER_LOGIN"));
        inputUsername.sendKeys("incorrect");

       // 4- Enter incorrect password: “incorrect”
       // driver.findElement(By.name("USER_PASSWORD")).sendKeys("incorrect");
        WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD"));// for reusability we created Web element here
       //alt+enter to create WebElement
        inputPassword.sendKeys("incorrect");


        //5- Click to login button.
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();


        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        //PS: Inspect and decide which locator you should be using to locate web
        //elements

        String actualMessage=driver.findElement(By.className("errortext")).getText();
        String expectedMessage="Incorrect login or password";

        if(actualMessage.equals(expectedMessage)){
            System.out.println("PASSED!");
        }else {
            System.out.println("FAILED!");
        }





    }
}
