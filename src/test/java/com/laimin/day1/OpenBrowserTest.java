package com.laimin.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by LaiMin on 2019/10/12.
 */
public class OpenBrowserTest {

    WebDriver driver;

    @Test
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\IdeaProjects\\SeleniumDemo2\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

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
    public void backForwarRefresh() throws InterruptedException {

        //打开网址
        driver.get("https://www.baidu.com");
        //等待
        Thread.sleep(3000);
        //打开网址
        driver.get("http://www.wxwerp.com");
        //后退
        driver.navigate().back();
        //等待
        Thread.sleep(3000);
        //前进
        driver.navigate().forward();
        //等待
        Thread.sleep(3000);
        //刷新浏览器
        driver.navigate().refresh();
        //等待
        Thread.sleep(3000);

    }

    @Test
    public void winChange() throws InterruptedException {

        //s实例化Dimension 设置窗口大小
        Dimension dimension = new Dimension(300,300);
        driver.manage().window().setSize(dimension);
        //等待
        Thread.sleep(3000);
        //窗口最大化
        driver.manage().window().maximize();
        //等待
        Thread.sleep(3000);

    }

    /*
    检验当前网址是否为百度网址
     */
    @Test
    public void checkUrl(){

        driver.get("https://www.baidu.com");
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.baidu.com/");

    }

    @AfterMethod
    public void quitBrowser(){
        //关闭浏览器
        driver.quit();
    }

}