package com.cydeo.tests.tasks;

import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskOrderPlacing {
    @Test
    public void smartBearOrderTest(){

        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //3. Enter username: “Tester”
        WebElement inputUserName= Driver.getDriver().findElement(By.xpath("//input[@type='text']"));
        inputUserName.sendKeys("Tester");

        //4. Enter password: “test”
        WebElement inputPassword= Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        inputPassword.sendKeys("test");

        //5. Click on Login button
        WebElement loginButton=Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        //6. Click on Order
        WebElement orderButton=Driver.getDriver().findElement(By.xpath("//a[.='Order']"));
        orderButton.click();

        //7. Select familyAlbum from product, set quantity to 2
        Select productName=new Select(Driver.getDriver().findElement(By.xpath("//select")));
        productName.selectByVisibleText("FamilyAlbum");

        WebElement inputQuantity=Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));

        inputQuantity.sendKeys("2");

        //8. Click to “Calculate” button
        WebElement calculateButton=Driver.getDriver().findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();

        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code
        Faker faker=new Faker();

        WebElement customerName=Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys(faker.name().fullName());

        WebElement streetInput=Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        streetInput.sendKeys(faker.address().streetAddress());

        WebElement cityInput=Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        cityInput.sendKeys(faker.address().city());

        WebElement stateInput=Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        stateInput.sendKeys(faker.address().state());

        WebElement zipCodeInput=Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zipCodeInput.sendKeys(faker.address().zipCode().replaceAll("-",""));

        //10.Click on “visa” radio button
        WebElement visaRadioButton=Driver.getDriver().findElement(By.xpath("(//input[@type='radio'])[1]"));
        visaRadioButton.click();

        //11.Generate card number using JavaFaker
        WebElement cardNumberInput= Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumberInput.sendKeys(faker.finance().creditCard().replaceAll("-",""));

        WebElement cardExpireDateInput= Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));

        cardExpireDateInput.sendKeys("11/24");

        //12.Click on “Process”
        WebElement processButton=Driver.getDriver().findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();

        //13.Verify success message “New order has been successfully added.
        WebElement messageText=Driver.getDriver().findElement(By.xpath("//div[@class='buttons_process']//strong"));

        String expectedMessageText = "New order has been successfully added.";
        String actualMessageText=messageText.getText();

        Assert.assertEquals(actualMessageText,expectedMessageText);
    }
}
