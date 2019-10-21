package com.laimin.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by LaiMin on 2019/10/15.
 */
public class actionsTest {

    WebDriver driver ;

    @BeforeMethod
    public void openFirefox(){

        System.setProperty("webdriver.gecko.driver",".\\drivers\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin","E:\\迅雷下载\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();

    }

    @Test
    public void testContextClick() throws InterruptedException {

        driver.get("https://www.baidu.com");

        WebElement element = driver.findElement(By.id("lg"));

        Actions builder = new Actions(driver);
//      操作鼠标右键点击
        builder.contextClick(element).perform();

        Thread.sleep(3000);

//        操作鼠标左键双击
//        builder.doubleClick(element).perform();
        element.click();
//        打开了新窗口后，获取第一个页面的句柄值
        String handle = driver.getWindowHandle();

//        driver控制权转交到新窗口,遍历获取到的所有窗口的句柄值，直到不是第一个窗口的
        for(String str : driver.getWindowHandles()){
            if(str.equals(handle))
                continue;
            driver.switchTo().window(str);
        }
//        等待元素加载完
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("_视频大全_高清在线观看")));

        WebElement element1 = driver.findElement(By.partialLinkText("_视频大全_高清在线观看"));
//        把鼠标移到该元素
        builder = new Actions(driver);
        builder.moveToElement(element1).perform();
//        拖动元素
        builder.dragAndDropBy(element1,200,200).perform();
//        拖动元素1到元素2上
//        builder.clickAndHold(element).moveToElement(element1).release(element1).perform();


    }

    @Test
    public void loadFileTest() throws InterruptedException {

        driver.get("https://www.wxwerp.com/?_debug_uid=M19");

        driver.findElement(By.linkText("进入旺销王")).click();

        Thread.sleep(3000);

        Actions builder = new Actions(driver);
        builder.click(driver.findElement(By.xpath("/html/body/form/div[3]/div[1]/div[4]/ul/li[3]/a"))).perform();
//        Thread.sleep(2000);
//        builder.click(driver.findElement(By.xpath("/html/body/form/div[3]/div[1]/div[4]/ul/li[3]/div/div[1]/div[1]/dl/dd[1]/a"))).perform();


        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table.items:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > div:nth-child(1) > input:nth-child(1)")));

        WebElement checkBoxElement = driver.findElement(By.cssSelector("table.items:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > div:nth-child(1) > input:nth-child(1)"));
        checkBoxElement.click();

        WebElement loadElement1 = driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/div[1]/div/div[5]/a"));
        loadElement1.click();
        WebElement loadElement2 = driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/div[1]/div/div[5]/ul/li[7]/a"));
        loadElement2.click();



    }

    @AfterMethod
    public void quitBrowser() throws InterruptedException {
        Thread.sleep(10000);
       driver.quit();
    }

}