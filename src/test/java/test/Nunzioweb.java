package test;

import core.DriverUtil;
import core.ahihi;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NunziowebPage;

public class Nunzioweb {
    NunziowebPage nunziowebPage = new NunziowebPage();

    @BeforeMethod
    public void setBaseUrl() {
        DriverUtil.initDriver(ahihi.CHROME);
        DriverUtil.maximizeWindow();
        DriverUtil.navigateTo("https://nunzioweb.com/");
    }
    @Test
    public void getTextCenter(){
        nunziowebPage.getTextCenter();
    }
    @AfterMethod
    public void endPage() {
        DriverUtil.waitingTime(5);
        DriverUtil.quit();

    }
}
