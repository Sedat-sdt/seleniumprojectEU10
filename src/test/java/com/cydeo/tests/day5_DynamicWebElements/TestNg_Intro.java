package com.cydeo.tests.day5_DynamicWebElements;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNg_Intro {

    @Test(priority=1)
    public void test1(){
        System.out.println("Test 1 is running...");

        //ASSERT EQUALS: compare 2 of the same things
        String actual="Apple";
        String expected= "Apple";

        Assert.assertEquals(actual,expected);


    }


    @Test(priority = 2)// this parenthesis not mandatory
    public void test2(){
        System.out.println("Test 2 is running...");

        //ASSERT TRUE
        String actual="apple";
        String expected="apple";

        Assert.assertTrue(actual.equals(expected));
    }


    @BeforeClass
    public void setupMethod(){
        System.out.println("---> BeforeClass is running");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("---> AfterClass is running!");
    }

    @BeforeMethod
    public  void  setUpMethod(){
        System.out.println("---> BeforeMethod is running!");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("---> AfterMethod is running!");
    }



}
