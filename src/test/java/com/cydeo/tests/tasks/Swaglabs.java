package com.cydeo.tests.tasks;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Swaglabs {

    @BeforeMethod
public void setUpMethod(){
        Driver.getDriver().get("https://www.saucedemo.com/");
    }
    @Test
    public void swaglabsLoginTest(){

        WebElement inputUserName=Driver.getDriver().findElement(By.xpath("//input[@id='user-name']"));
        inputUserName.sendKeys("standard_user");

        BrowserUtils.sleep(2);

        WebElement inputPassword=Driver.getDriver().findElement(By.xpath("//input[@id='password']"));
        inputPassword.sendKeys("secret_sauce");

        WebElement loginBtn=Driver.getDriver().findElement(By.xpath("//input[@id='login-button']"));
        loginBtn.click();

        /*WebElement productSortContainer=Driver.getDriver().findElement(By.xpath("//select[@class='product_sort_container']"));
        productSortContainer.click();*/

        Select productSortContainer= new Select(Driver.getDriver().findElement(By.xpath("//select[@class='product_sort_container']")));
        productSortContainer.selectByIndex(3);// select highToLow

        BrowserUtils.sleep(2);

        WebElement addToCartBtn=Driver.getDriver().findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
        addToCartBtn.click();

        BrowserUtils.sleep(2);

        WebElement cartNumberText=Driver.getDriver().findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        String expectedNumberText="1";
        String actualNumberText=cartNumberText.getText();
        Assert.assertEquals(expectedNumberText,actualNumberText);

        WebElement cartImage=Driver.getDriver().findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cartImage.click();

        BrowserUtils.sleep(2);

        WebElement checkOutBtn= Driver.getDriver().findElement(By.xpath("//button[@id='checkout']"));
        checkOutBtn.click();

        BrowserUtils.sleep(2);

        Faker faker=new Faker();

        WebElement inputFirstName= Driver.getDriver().findElement(By.xpath("//input[@id='first-name']"));

        inputFirstName.sendKeys(faker.name().firstName());
        BrowserUtils.sleep(2);


        WebElement inputLastName= Driver.getDriver().findElement(By.xpath("//input[@id='last-name']"));

        inputLastName.sendKeys(faker.name().lastName());

        BrowserUtils.sleep(2);

        WebElement inputZipCode= Driver.getDriver().findElement(By.xpath("//input[@id='postal-code']"));
        inputZipCode.sendKeys(faker.address().zipCode());

        BrowserUtils.sleep(2);

        WebElement continueBtn= Driver.getDriver().findElement(By.xpath("//input[@id='continue']"));

        continueBtn.click();
        BrowserUtils.sleep(2);

        WebElement finishBtn= Driver.getDriver().findElement(By.xpath("//button[@id='finish']"));

        finishBtn.click();
        BrowserUtils.sleep(2);

        WebElement completeMessage=Driver.getDriver().findElement(By.xpath("//h2[@class='complete-header']"));

        Assert.assertEquals(completeMessage.getText(),"THANK YOU FOR YOUR ORDER");









    }
}
