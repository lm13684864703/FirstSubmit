package com.laimin.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by LaiMin on 2019/10/13.
 */
public class oprateElementTest1 {

    WebDriver driver;

    @BeforeMethod
    public void openFirefox(){
        System.setProperty("webdriver.gecko.driver",".\\drivers\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin","E:\\迅雷下载\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
    }
    /**
     * 打开百度
     * 点击新闻链接
     */
    @Test
    public void clickLinkTest(){
//        打开百度
        driver.get("https://www.baidu.com/");
//        找到新闻链接元素
        WebElement newsLink = driver.findElement(By.name("tj_trnews"));
//        点击链接
        newsLink.click();
//        获取当前url
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"http://news.baidu.com/","检验网址是否为新闻的");
    }

    /**
     * 打开百度
     * 搜索框输入selenium
     * 点击百度一下
     */
    @Test
    public void sendKeysTest() throws InterruptedException {

        driver.get("https://www.baidu.com");
        WebElement input = driver.findElement(By.id("kw"));
        input.sendKeys("selenium");
        WebElement botton = driver.findElement(By.id("su"));
        botton.click();
        Thread.sleep(3000);
//        获取当前页title
        String titleText = driver.getTitle();
//        清空输入框
        input.clear();
        Thread.sleep(3000);
        Assert.assertEquals(titleText,"selenium_百度搜索");

    }

    @Test
    public void getAttributeTest(){
        driver.get("https://www.baidu.com");
        WebElement input = driver.findElement(By.id("kw"));
        input.sendKeys("selenium");
//        获取元素属性值
        String attr = input.getAttribute("value");
        System.out.println(attr);
//        检验百度按钮是否展示  isDisplayed(), isSelected()[是否选中], isEnabled()[是否激活，可否输入、点击等]
        Boolean disp = driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(disp);
    }

    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }
}