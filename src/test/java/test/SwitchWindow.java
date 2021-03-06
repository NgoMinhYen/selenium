package test;

import core.DriverUtil;
import core.ahihi;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WindowPage;

public class SwitchWindow {
    WindowPage windowPage = new WindowPage();

    @BeforeMethod
    public void setBaseUrl() {
        DriverUtil.initDriver(ahihi.CHROME);
        DriverUtil.maximizeWindow();
        DriverUtil.navigateTo("https://demoqa.com/browser-windows");
    }

    @Test
    public void switchWindow() {
        windowPage.getNewTab();
        windowPage.getNewWindow();

    }

    @AfterMethod
    public void endPage() {
        DriverUtil.waitingTime(5);
        DriverUtil.close();
        DriverUtil.quit();

    }
}
