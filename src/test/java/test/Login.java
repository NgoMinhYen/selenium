package test;

import core.DriverUtil;
import core.ahihi;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Login {
    LoginPage loginPage=new LoginPage();
    @BeforeTest
    public void setBaseUrl() {
        DriverUtil.initDriver(ahihi.CHROME);
        DriverUtil.maximizeWindow();
        DriverUtil.navigateTo("http://www.way2automation.com/angularjs-protractor/registeration/#/login");
    }
    @DataProvider(name = "dataLogin")
    public static Object[][]
    dataLogin() {
        return new Object[][]{{"angular", "password", "angular"}};
    }

    @Test(dataProvider = "dataLogin")
    public void login(String userName, String password, String rename){
        loginPage.login(userName,password,rename);
        System.out.println("AAAA: " +loginPage.getTextHome() );
        DriverUtil.close();
    }
    @AfterTest
    public void endPage() {
        DriverUtil.waitingTime(3);
        DriverUtil.quit();
    }


}
