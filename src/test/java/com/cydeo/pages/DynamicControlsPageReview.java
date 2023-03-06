package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPageReview {
    public DynamicControlsPageReview(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[.='Remove']")
    public WebElement removeButton;

    @FindBy(css="div#loading")
    public WebElement loadingBarr;

    @FindBy(css="input[label='blah']")
    public WebElement checkBox;

    @FindBy(id="message")
    public WebElement messageText;







}
