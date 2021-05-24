package test;

import core.DriverUtil;
import core.ahihi;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RadioButtonPage;

public class RadioButton {
    RadioButtonPage radioButtonPage = new RadioButtonPage();

    @BeforeMethod
    public void setBaseUrl() {
        DriverUtil.initDriver(ahihi.CHROME);
        DriverUtil.maximizeWindow();
        DriverUtil.navigateTo("https://demoqa.com/elements");
        DriverUtil.implicitlyWait(5);
    }

    @Test
    public void clickTheSite() {
        radioButtonPage.clickRadioButton();
        Assert.assertEquals("Yes",radioButtonPage.getTextAfterClick());
    }

    @AfterMethod
    public void endPage() {
        DriverUtil.waitingTime(5);
        DriverUtil.quit();
    }
}
