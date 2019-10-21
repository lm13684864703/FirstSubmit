package com.laimin.day1;

import org.testng.annotations.*;

public class TestNGDemo1 {

    @BeforeTest
    public void beforTest(){
        System.out.println("这是@BeforTest注解");
    }
    @BeforeMethod
    public void beforMethod(){
        System.out.println("这是@BeforMethod注解");
    }
    @AfterMethod
    public void afterMethod1(){
        System.out.println("这是@AfterMthod注解");
    }
    @Test
    public void testCase1(){
        System.out.println("这是@Test注解1");
    }
    @Test
    public void testCase2(){
        System.out.println("这是@Test注解2");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("这是@AfterTest注解");
    }


}