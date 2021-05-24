package test;

import core.DriverUtil;
import core.ahihi;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SliderPage;

public class Slider {
    SliderPage sliderPage = new SliderPage();

    @BeforeMethod
    public void setBaseUrl() {
        DriverUtil.initDriver(ahihi.CHROME);
        DriverUtil.maximizeWindow();
        DriverUtil.navigateTo("https://demoqa.com");
    }

    @Test
    public void switchWindow()
    {
        sliderPage.moveSlider(76);
    }

    @AfterMethod
    public void endPage() {
        DriverUtil.waitingTime(5);
//        DriverUtil.close();
        DriverUtil.quit();

    }
}
