package com.cydeo.tests.tasks;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.ConfigurationReader;
import com.cydeo.tests.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationForm {

    @Test

    public void registrationFormTest(){

        //TC#1: Registration form confirmation
        //Note: Use JavaFaker OR read from configuration.properties file when possible.
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form

        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        Faker faker= new Faker();

        //3. Enter first name

        WebElement inputFirstName= Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));

        inputFirstName.sendKeys(faker.name().firstName());

        BrowserUtils.sleep(2);

        //4. Enter last name

        WebElement inputLastName= Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));

        inputLastName.sendKeys(faker.name().lastName());

        BrowserUtils.sleep(2);

        //5. Enter username

        WebElement inputUserName=Driver.getDriver().findElement(By.xpath("//input[@data-bv-field='username']"));

        inputUserName.sendKeys(faker.bothify("###???"));

        BrowserUtils.sleep(2);

        //6. Enter email address

        WebElement inputEmailAdress=Driver.getDriver().findElement(By.xpath("//input[@name='email']"));

        inputEmailAdress.sendKeys(faker.bothify("???###@email.com"));
        BrowserUtils.sleep(2);

        //7. Enter password

        WebElement inputPassword=Driver.getDriver().findElement(By.xpath("//input[@name='password']"));

        inputPassword.sendKeys(faker.bothify("####????"));
        BrowserUtils.sleep(2);

        //8. Enter phone number

        WebElement inputPhoneNumber=Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));

        inputPhoneNumber.sendKeys(faker.numerify("###-###-####"));

        BrowserUtils.sleep(2);

        //9. Select a gender from radio buttons

        WebElement inputGender=Driver.getDriver().findElement(By.xpath("(//input[@name='gender'])[1]"));

        inputGender.click();

        BrowserUtils.sleep(2);

        //10.Enter date of birth
        WebElement inputDateOfBirth=Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        inputDateOfBirth.sendKeys("01/01/1999");

        BrowserUtils.sleep(2);

        //11.Select Department/Office
        Select departmentDropDown=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropDown.selectByIndex(faker.number().numberBetween(1,9));

        BrowserUtils.sleep(2);

        //12.Select Job Title

        Select jobTitleDropDown=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));

        jobTitleDropDown.selectByIndex(faker.number().numberBetween(1,8));
        BrowserUtils.sleep(2);

        //13.Select programming language from checkboxes
        WebElement selectProgrammingLanguage=Driver.getDriver().findElement(By.xpath("//input[@value='java']"));

        selectProgrammingLanguage.click();
        BrowserUtils.sleep(2);

        //14.Click to sign up button
        WebElement signUpButton=Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));

        signUpButton.click();
        BrowserUtils.sleep(2);

        //15.Verify success message “You’ve successfully completed registration.” is
        //displayed.

        WebElement successMessage=Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']/p"));
        String expectedMessageText="You’ve successfully completed registration!";
        String actualMessageText= successMessage.getText();

        Assert.assertEquals(expectedMessageText,actualMessageText,"! sign is  difference");

    }




}
