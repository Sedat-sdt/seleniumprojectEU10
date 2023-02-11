package com.cydeo.tests.day4_cssSelector_XpathContinue;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_Xpath_CssSelector {
    public static void main(String[] args) {

        //XPATH and CSS Selector PRACTICES
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #1: XPATH and cssSelector Practices
        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com/forgot_password

        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)
        //a. “Home” link

        //locate using cssSelector syntax1: class value
        WebElement homeLink1=driver.findElement(By.cssSelector("a[class='nav-link']"));

        //locate using cssSelector syntax1: href value
        WebElement homeLink2=driver.findElement(By.cssSelector("a[href='/']"));

        //locate using cssSelector syntax2:
        WebElement homeLink3=driver.findElement(By.cssSelector("a.nav-link"));


        //locate using xpath syntax1:
        WebElement homeLink4=driver.findElement(By.xpath("//a[@class='nav-link']"));


        //b. “Forgot password” header

        //locate header using cssSelector locate parent element and move down to h2
        WebElement header_ex1=driver.findElement(By.cssSelector("div.example > h2"));

        //locate header using xpath:
        //WebElement header_ex2=driver.findElement(By.xpath("//h2[text()='Forgot Password']"));
        WebElement header_ex2=driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        //c. “E-mail” text

        //locate with xpath
        WebElement emailLabel=driver.findElement(By.xpath("//label[@for='email']"));

        //d. E-mail input box
        WebElement inputBox_ex1=driver.findElement(By.xpath("//input[@name='email']"));

        //xpath contains method    //tagname[contains(@atribute, 'value')]
        WebElement inputBox_ex2=driver.findElement(By.xpath("//input[contains(@pattern,'a-z')]"));


        //e. “Retrieve password” button
        WebElement retrievePasswordButton=driver.findElement(By.xpath("//button[@id='form_submit']"));
        WebElement retrievePasswordButton1=driver.findElement(By.xpath("//button[@class='radius']"));
        WebElement retrievePasswordButton2=driver.findElement(By.cssSelector("button.radius"));// by using class(.)


        //f. “Powered by Cydeo text
        WebElement poweredByCydeoText=driver.findElement(By.xpath("//div[@style='text-align: center;']"));



        //4. Verify all web elements are displayed.

        System.out.println("homeLink1.isDisplayed() = " + homeLink1.isDisplayed());
        System.out.println("header_ex1.isDisplayed() = " + header_ex1.isDisplayed());
        System.out.println("emailLabel.isDisplayed() = " + emailLabel.isDisplayed());
        System.out.println("inputBox_ex1.isDisplayed() = " + inputBox_ex1.isDisplayed());
        System.out.println("retrievePasswordButton1.isDisplayed() = " + retrievePasswordButton1.isDisplayed());
        System.out.println("retrievePasswordButton2.isDisplayed() = " + retrievePasswordButton2.isDisplayed());
        System.out.println("poweredByCydeoText.isDisplayed() = " + poweredByCydeoText.isDisplayed());


    }
}
