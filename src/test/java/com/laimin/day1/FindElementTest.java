package com.laimin.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by LaiMin on 2019/10/12.
 */
public class FindElementTest {

    WebDriver driver;

    @BeforeMethod
    public void openFirefox(){
        //设置geckodriver路径
        System.setProperty("webdriver.gecko.driver","E:\\IdeaProjects\\SeleniumDemo2\\drivers\\geckodriver.exe");
        //设置firefox安装路径
        System.setProperty("webdriver.firefox.bin","E:\\迅雷下载\\Mozilla Firefox\\firefox.exe");
        //实例化FirefoxDriver,打开火狐
        driver = new FirefoxDriver();
    }

    @Test
    public void findById(){
        //打开百度
        driver.get("https://www.baidu.com");
        //通过id查找元素
        WebElement divElement = driver.findElement(By.id("u1"));
    }

    @Test
    public void findByName(){
        //打开百度
        driver.get("https://www.baidu.com");
        //通过name查找元素
        WebElement inputElement = driver.findElement(By.name("rn"));
    }

    @Test
    public void findByXpath(){
        //打开百度
        driver.get("https://www.baidu.com");
        //通过xpath查找单个元素
//        WebElement aElement = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[3]/a[1]"));
//        System.out.println(aElement.getText());
        //查找多个元素
        List<WebElement> aElements = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div/div[3]/a"));

        for (int i = 0; i < aElements.size(); i++) {
            System.out.println(aElements.get(i).getText());
        }


    }

    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }

}