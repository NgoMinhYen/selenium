package test;

import core.DriverUtil;
import core.ahihi;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AutoCompletePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutoComplete {
    AutoCompletePage autoCompletePage = new AutoCompletePage();

    @BeforeMethod
    public void setBaseUrl() {
        DriverUtil.initDriver(ahihi.CHROME);
        DriverUtil.maximizeWindow();
        DriverUtil.navigateTo("https://demoqa.com/widgets");
    }

    @Test
    public void autoComplete() {
        List<String> listColors = new ArrayList<String>();
        listColors.add("Green");
        listColors.add("Yellow");
        listColors.add("Red");

        autoCompletePage.choiceColorInAutoComplete(listColors);
        autoCompletePage.checkColorReturn();
        listColors.equals(autoCompletePage.checkColorReturn());
        autoCompletePage.removeColorAndCheckListColorAfterRemove("Green");
        autoCompletePage.inputSingleColorName("Green");
    }

    @AfterMethod
    public void endPage() {
        DriverUtil.waitingTime(5);
        DriverUtil.quit();

    }

}
