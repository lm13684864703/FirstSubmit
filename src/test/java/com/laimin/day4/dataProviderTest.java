package com.laimin.day4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by LaiMin on 2019/10/20.
 */
public class dataProviderTest {

    @DataProvider(name = "userList")
    public Object[][] data(){
        return new Object[][]{{"user1","password1"},{"user2","password2"}};
    }

    @Test(dataProvider = "userList")
    public void loginTest(String userName, String passWord){
        System.out.println("用户名：" + userName + "，密码：" + passWord);
    }

}