package test;

import core.DriverUtil;
import core.ahihi;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProgressBarPage;
import pages.ProtractorPage;

public class ProgressBar {
    ProgressBarPage progressBarPage = new ProgressBarPage();

    @BeforeMethod
    public void setBaseUrl() {
        DriverUtil.initDriver(ahihi.CHROME);
        DriverUtil.maximizeWindow();
        DriverUtil.navigateTo("https://demoqa.com/progress-bar");
    }

    @Test
    public void progressBar() {
        progressBarPage.startProgressBar(60);

    }

    @AfterMethod
    public void endPage() {
        DriverUtil.waitingTime(5);
        DriverUtil.quit();

    }

}
