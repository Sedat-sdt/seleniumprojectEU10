package com.cydeo.tests.tasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckingLinkNumber {

    @Test
    public void linkNumberTest(){
        //1. Open Chrome browser
        //2. Go to https://www.openxcell.com
        //3. Count the number of the links on the page and verify
        //Expected: 332

        Driver.getDriver().get("https://www.openxcell.com");

        List<WebElement> links=Driver.getDriver().findElements(By.tagName("a"));
        System.out.println("links.size() = " + links.size());

        for (WebElement eachLink : links) {
            System.out.print(eachLink.getText()+"  ");
        }
        Integer expectedLinkNumber=355;
        Integer actualLinkNumber=links.size();

        Assert.assertEquals(expectedLinkNumber,actualLinkNumber,"Link numbers are not matching!");



    }

}
