package com.cydeo.tests.tasks;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskGasMileageCalculator {

    @Test
    public void mileageCalculator(){

    //   Add a new class GasMileageCalculatorTest
    //2. Go to https://www.calculator.net
    //3. Search for “gas mileage” using search box
    //4. Click on the “Gas Mileage Calculator” link

    Driver.getDriver().get("https://www.calculator.net");

        WebElement searchBox=Driver.getDriver().findElement(By.id("calcSearchTerm"));
        searchBox.sendKeys("gas mileage");

        WebElement searchButton=Driver.getDriver().findElement(By.xpath("//span[.='Search']"));
        searchButton.click();

        WebElement gasMileageCalculatorLink=Driver.getDriver().findElement(By.xpath("//a[.='Gas Mileage Calculator']"));
        gasMileageCalculatorLink.click();

     //5. On Next page verify:
        //a. Title equals: “Gas Mileage Calculator”
        //b. “Gas Mileage Calculator” label is displayed

    String actualTitle=Driver.getDriver().getTitle();
    String expectedTitle="Gas Mileage Calculator";

        Assert.assertEquals(actualTitle,expectedTitle);



    }



}
