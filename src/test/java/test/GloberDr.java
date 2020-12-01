package test;

import core.DriverUtil;
import core.ahihi;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GlobeDrPage;

public class GloberDr {
    GlobeDrPage globeDrPage = new GlobeDrPage();

    @BeforeMethod
    public void setBaseUrl() {
        DriverUtil.initDriver(ahihi.FIRE_FOX);
        DriverUtil.maximizeWindow();
        DriverUtil.navigateTo("https://web1.globedr.com/");
    }

    @Test
    public void Login() {
        globeDrPage.Login("admin", "1");
    }

    @AfterMethod
    public void endPage() {
        DriverUtil.waitingTime(5);
//        DriverUtil.close();
        DriverUtil.quit();

    }
}
