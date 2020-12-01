package test;

import core.DriverUtil;
import core.ahihi;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GuruPage;

public class Guru {
    GuruPage guruPage = new GuruPage();

    @BeforeMethod
    public void setBaseUrl() {
        DriverUtil.initDriver(ahihi.CHROME);
        DriverUtil.maximizeWindow();
        DriverUtil.navigateTo("http://demo.guru99.com/test/drag_drop.html");
    }

    @Test
    public void guRu() {
        guruPage.dragAndDrop();
    }


    @AfterMethod
    public void endPage() {
        DriverUtil.waitingTime(5);
        DriverUtil.quit();

    }
}
