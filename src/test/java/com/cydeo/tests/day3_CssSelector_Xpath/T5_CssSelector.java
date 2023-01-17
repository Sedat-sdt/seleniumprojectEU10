package com.cydeo.tests.day3_CssSelector_Xpath;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_CssSelector {
    public static void main(String[] args) {
        //TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //3- Enter incorrect username into login box:

        WebElement loginBox=driver.findElement(By.cssSelector("input[class='login-inp']"));
        loginBox.sendKeys("incorrect", Keys.ENTER);


        //4- Click to `Reset password` button

        WebElement resetPasswordButton=driver.findElement(By.cssSelector("button[class='login-btn']"));
        resetPasswordButton.click();



        //5- Verify “error” label is as expected
        //Expected: Login or E-mail not found

        //WebElement errorLabel=driver.findElement(By.cssSelector("div[class='errortext']"));
        WebElement errorLabel=driver.findElement(By.xpath("//div[@class='errortext']"));

        String actualErrorLabelText=errorLabel.getText();
        String expectedErrorLabelText="Login or E-mail not found";

        System.out.println("expectedErrorLabelText = " + expectedErrorLabelText);
        System.out.println("actualErrorLabelText = " + actualErrorLabelText);

        if(actualErrorLabelText.equals(expectedErrorLabelText)){
            System.out.println("Error label text is PASSED!");
        }else{
            System.out.println("Error label text is FAILED!");
        }
    }
}
