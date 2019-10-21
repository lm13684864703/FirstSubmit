package com.laimin.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by LaiMin on 2019/10/13.
 */
public class oprateAlertTest {

    WebDriver driver;

    @BeforeMethod
    public void openFirefox(){
        System.setProperty("webdriver.gecko.driver",".\\drivers\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin","E:\\迅雷下载\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void alertTest() throws InterruptedException {
        driver.get("http://www.wxwerp.com");
        driver.findElement(By.xpath("/html/body/form/div[4]/div[2]/div[1]/div[2]/ul[2]/li[7]/div")).click();
        Thread.sleep(3000);
//        获取到当前alert，driver控制权转交alert
        Alert alert = driver.switchTo().alert();
//        点击alert的确定
        alert.accept();
    }

    /**
     * 控制frame或iframe
     */
    @Test
    public void frameTest(){
        driver.get("xxxxx");
//        控制权转交frame时，frame定位可通过元素或者name或id等
        driver.switchTo().frame("aa");
//        在frame操作元素
        driver.findElement(By.id("ddd")).sendKeys("输入");
//        控制权转交回原来
        driver.switchTo().defaultContent();
    }

    @Test
    public void selectorTest(){

        driver.get("某个页面");
//        定位下拉框
        WebElement selector = driver.findElement(By.id("下拉框的id"));
//        new一个select对象
        Select select = new Select(selector);
//        通过索引选择
        select.selectByIndex(0);
//        通过value值选择
        select.selectByValue("标签里的value值");
//        通过text值
        select.selectByVisibleText("页面显示的text值");

    }

    /**
     * 从一个窗口打开一个新窗口进行操作
     */
    @Test
    public void windowsChangeTest() throws InterruptedException {

        driver.get("https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=monline_4_dg&wd=java%20foreach&oq=java%2520for%25E5%25BE%25AA%25E7%258E%25AF%25E9%2587%258C%25E7%259A%2584%25E5%2586%2592%25E5%258F%25B7&rsv_pq=dae7978a0009752b&rsv_t=7b157wVLeNI4EL4%2B7ZO2Bh6r5g%2FMTHeN7%2FeZtJ6e4i1zqO4LFMIY8bvc7qJFhbJubw5X&rqlang=cn&rsv_enter=1&rsv_dl=tb&inputT=5798&rsv_sug3=57&rsv_sug1=17&rsv_sug7=100&rsv_sug2=0&rsv_sug4=7382&rsv_sug=2");

//        String handle = driver.getWindowHandle();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/div[3]/div[2]/h3/a")).click();
//重点：获取第一个页面的句柄值必须在新窗口之后，否则导致driver.getWindowHandles()没有新窗口的句柄值
        String handle = driver.getWindowHandle();
          Set<String> handles = driver.getWindowHandles();
//        System.out.println("这是第一个" + handle1);
//        System.out.println("这是第二个" + handle2);
//        for(String str : handles){
//            System.out.println(str);
//        }

        for(String str : handles){
            if(str.equals(handle)){
                continue;
            }
            System.out.println(str);
            driver.switchTo().window(str);
        }

        Thread.sleep(10000);
        driver.findElement(By.id("toolber-keyword")).sendKeys("测试");

        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(handle);

        driver.findElement(By.id("kw")).sendKeys("测试2");
        Thread.sleep(2000);


    }

    @Test
    public void waitTest1() throws InterruptedException {

        driver.get("https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=monline_4_dg&wd=java%20foreach&oq=java%2520for%25E5%25BE%25AA%25E7%258E%25AF%25E9%2587%258C%25E7%259A%2584%25E5%2586%2592%25E5%258F%25B7&rsv_pq=dae7978a0009752b&rsv_t=7b157wVLeNI4EL4%2B7ZO2Bh6r5g%2FMTHeN7%2FeZtJ6e4i1zqO4LFMIY8bvc7qJFhbJubw5X&rqlang=cn&rsv_enter=1&rsv_dl=tb&inputT=5798&rsv_sug3=57&rsv_sug1=17&rsv_sug7=100&rsv_sug2=0&rsv_sug4=7382&rsv_sug=2");

//        String handle = driver.getWindowHandle();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/div[3]/div[2]/h3/a")).click();

        String handle = driver.getWindowHandle();
        for(String str : driver.getWindowHandles()){
            if(str.equals(handle)){
                continue;
            }
            System.out.println(str);
            driver.switchTo().window(str);
        }
        //全局等待,可放置beforeMethod注解下
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //显式等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("toolber-keyword")));
        driver.findElement(By.id("toolber-keyword")).sendKeys("测试");


    }

    @AfterMethod
    public void quitBrowser() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}