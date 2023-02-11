package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoad7Page {



//1. create constructor and instantiate driver and object of class
    public DynamicLoad7Page(){

        PageFactory.initElements(Driver.getDriver(),this);


    }

    @FindBy(xpath="//strong[.='Done!']")
    public WebElement doneMessageText;

    @FindBy(xpath = "//img[@alt='square pants']")
    public WebElement aFewMomentsLaterImage;




}
