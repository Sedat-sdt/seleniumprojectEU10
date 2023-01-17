package com.cydeo.tests.day3_CssSelector_Xpath;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_locators_getText_getAttribute {
    public static void main(String[] args) {

       //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


        //2- Go to: https://login1.nextbasecrm.com/

        driver.get("https://login1.nextbasecrm.com");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer

        WebElement rememberMeLabel= driver.findElement(By.className("login-item-checkbox-label"));
        String actualRememberMeLabel=rememberMeLabel.getText();
        String expectedRememberMeLabel="Remember me on this computer";

        if(actualRememberMeLabel.equals(expectedRememberMeLabel)){
            System.out.println("PASSED!");
        }else{
            System.out.println("FAILED!");
        }

        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?

        WebElement forgotPassword = driver.findElement(By.className("login-link-forgot-pass"));

        String actualForgotPassword=forgotPassword.getText();
        String expectedForgotPassword="Forgot your password?";

        if(actualForgotPassword.equals(expectedForgotPassword)){
            System.out.println("PASSED!");
        }else {
            System.out.println("expectedForgotPassword = " + expectedForgotPassword);
            System.out.println("actualForgotPassword = " + actualForgotPassword);

            System.out.println("FAILED!");
        }


        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes

        WebElement forgotPasswordAttribute = driver.findElement(By.className("login-link-forgot-pass"));

        String actualForgotPasswordAttribute=forgotPasswordAttribute.getAttribute("href");
        String expectedForgotPasswordAttribute="forgot_password=yes";

        System.out.println("expectedForgotPasswordAttribute = " + expectedForgotPasswordAttribute);
        System.out.println("actualForgotPasswordAttribute = " + actualForgotPasswordAttribute);

        if(actualForgotPasswordAttribute.contains(expectedForgotPasswordAttribute)) {

            System.out.println("PASSED!");
        }else {
            System.out.println("FAILED!");


        }


    }
}
