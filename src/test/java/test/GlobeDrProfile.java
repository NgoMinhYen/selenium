package test;

import core.DriverUtil;
import core.ahihi;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GlobeDrProfilePage;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class GlobeDrProfile {
    GlobeDrProfilePage globeDrProfilePage = new GlobeDrProfilePage();

    @BeforeMethod
    public void setBaseUrl() {
        DriverUtil.initDriver(ahihi.CHROME);
        DriverUtil.maximizeWindow();
        DriverUtil.navigateTo("https://web1.globedr.com/");
    }

    @Test
    public void updateProfileInfo() {
        globeDrProfilePage.updateProfile("0347249676", "123456","Việt Nam","14/10/1995","74 ông ích khiêm, phường 14, quận 11");

    }

    @AfterMethod
    public void endPage() {
        DriverUtil.waitingTime(3);
        DriverUtil.quit();
    }

}
