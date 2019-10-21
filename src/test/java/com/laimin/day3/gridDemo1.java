package com.laimin.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by LaiMin on 2019/10/17.
 */
public class gridDemo1 {

    @Test
    public void testGrid() throws MalformedURLException, InterruptedException {

        DesiredCapabilities chromeDC = DesiredCapabilities.chrome();
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.171.1:4446/wd/hub"),chromeDC);
        driver.get("https://www.baidu.com");
        Thread.sleep(2000);
        driver.quit();

    }
//使用数据驱动方式存放不同浏览器和node地址，可实现分浏览器分系统执行case
    @DataProvider(name = "data1")
    public Object[][] test1(){
        return new Object[][]{
                {"firefox","http://192.168.171.1:5555"},
                {"chrome","http://192.168.171.1:7777"}
        };
    }

    @Test(dataProvider = "data1")
    public void testGrid2(String browser,String noedUrl) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = null;
        if(browser.equals("firefox")){
            dc = DesiredCapabilities.firefox();
        }else if (browser.equals("chrome")){
            dc = DesiredCapabilities.chrome();
        }else{
            System.out.println("error");
        }
        WebDriver driver = new RemoteWebDriver(new URL(noedUrl + "/wd/hub"), dc);
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        driver.quit();
    }


}