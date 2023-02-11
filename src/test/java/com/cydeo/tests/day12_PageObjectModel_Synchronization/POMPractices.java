package com.cydeo.tests.day12_PageObjectModel_Synchronization;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POMPractices {
    LibraryLoginPage libraryLoginPage;
    Faker faker;


    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get("https://library1.cydeo.com");
        libraryLoginPage= new LibraryLoginPage();
        faker=new Faker();
    }


    @Test
    public void required_field_error_message_test(){


        //TC #1: Required field error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com



        //3- Do not enter any information
        //4- Click to “Sign in” button
        libraryLoginPage.signInButton.click();


        //5- Verify expected error is displayed:
        //Expected: This field is required.

        Assert.assertEquals(libraryLoginPage.fieldRequiredErrorMessage.getText(),"This field is required.");
        //NOTE: FOLLOW POM DESIGN PATTER
    }

    @Test
    public void invalid_email_format_error_message_test(){
        //TC #2: Invalid email format error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        //3- Enter invalid email format


       // libraryLoginPage.inputUsername.sendKeys(faker.internet().emailAddress());
        libraryLoginPage.inputUsername.sendKeys("smthngWrng");

        BrowserUtils.sleep(2);
        libraryLoginPage.signInButton.click();

        BrowserUtils.sleep(2);

        //4- Verify expected error is displayed:
        //Expected: Please enter a valid email address.

        Assert.assertEquals(libraryLoginPage.enterValidEmailErrorMessage.getText(),"Please enter a valid email address.");

        //Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());
        //NOTE: FOLLOW POM DESIGN PATTER

        Driver.closeDriver();


    }

    @Test

    public void library_negative_loginTest(){
        //TC #3: Library negative login
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        //3- Enter incorrect username or incorrect password


        libraryLoginPage.inputUsername.sendKeys("wrongUserName");
        BrowserUtils.sleep(2);

        libraryLoginPage.inputPassword.sendKeys(faker.letterify("????"));

        BrowserUtils.sleep(2);
        libraryLoginPage.signInButton.click();

        BrowserUtils.sleep(2);

        //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password

        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());

        //Assert.assertEquals(libraryLoginPage.wrongEmailOrPasswordErrorMessage.getText(),"Sorry, Wrong Email or Password");
        //NOTE: FOLLOW POM DESIGN PATTER


    }



}
