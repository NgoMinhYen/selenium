package test;

import core.DriverUtil;
import core.ahihi;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProtractorPage;

public class ProtractorCheckbox {
    ProtractorPage protractorPage = new ProtractorPage();

    @BeforeMethod
    public void setBaseUrl() {
        DriverUtil.initDriver(ahihi.CHROME);
        DriverUtil.maximizeWindow();
        DriverUtil.navigateTo("http://www.way2automation.com/angularjs-protractor/checkboxes/");
    }

    @Test
    public void testCheckBox() {
        protractorPage.getTextCheckBoxChosen();
        protractorPage.getTextDesable();
        protractorPage.getTextNotSelected();
        protractorPage.checkGarageImplement();
        Assert.assertEquals(protractorPage.isSelected("Axe"),true);
        Assert.assertEquals(protractorPage.isSelected("Chainsaw"),true);
        Assert.assertEquals(protractorPage.isSelected("Leaf Blower"),true);
        protractorPage.getTextHaveTowSelected();

    }

    @AfterMethod
    public void endPage() {
        DriverUtil.waitingTime(5);
        DriverUtil.quit();

    }
}
