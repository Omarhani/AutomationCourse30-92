package login;


import base.BaseTests;
import data.Login;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

public class LoginTests1 extends BaseTests{
    @DataProvider
    public Object[][] testData() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        return readDataFromJson.readJsonFile().Login1;
    }
    @Test(dataProvider = "testData")
    public void testSuccessfulLogin(String username,String password){
        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.loginFeature(username,password);

    }



}
