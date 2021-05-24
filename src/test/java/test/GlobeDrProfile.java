package test;

import common.ImageUtils;
import core.DriverUtil;
import core.ahihi;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GlobeDrProfilePage;

import java.io.File;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class GlobeDrProfile {
    GlobeDrProfilePage globeDrProfilePage = new GlobeDrProfilePage();
    ImageUtils imageUtils = new ImageUtils();

    @BeforeMethod
    public void setBaseUrl() {
        DriverUtil.initDriver(ahihi.CHROME);
        DriverUtil.maximizeWindow();
        DriverUtil.navigateTo("https://web1.globedr.com/");
    }

    @Test
    public void updateProfileInfo() {
//        globeDrProfilePage.updateProfile("0347249676", "123456", "Việt Nam", "14/10/1995", "74 ông ích khiêm, phường 14, quận 11");

        Assert.assertTrue(imageUtils.compareImage(new File("D:\\A.jpg"), new File("D:\\462.jpg")));

    }

    @AfterMethod
    public void endPage() {
        DriverUtil.waitingTime(3);
        DriverUtil.quit();
    }

}
