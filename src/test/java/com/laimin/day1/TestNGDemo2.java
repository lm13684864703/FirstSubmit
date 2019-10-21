package com.laimin.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by LaiMin on 2019/10/12.
 */
public class TestNGDemo2 {

    @Test
    public void assertEqualTest(){
        String a = "aaa";
        String b = "aaa";
        Assert.assertEquals(a,b,"校验是否相等");
    }

}