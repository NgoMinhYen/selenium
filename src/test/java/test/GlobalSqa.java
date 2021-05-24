package test;

import core.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GlobalSqaPage;

public class GlobalSqa {
    GlobalSqaPage globalSqaPage = new GlobalSqaPage();

    @BeforeMethod
    public void setBaseUrl() {
        DriverUtil.initDriver(ahihi.CHROME);
        DriverUtil.maximizeWindow();
        DriverUtil.navigateTo("https://www.globalsqa.com/");
    }

    @Test
    public void toolTip() {
//        globalSqaPage.clickSubMenu(Menu.DEMO, SubMenu.TOOL_TIP);
//        System.out.println("SSSS: " + globalSqaPage.getTooltip());
//        Assert.assertEquals(globalSqaPage.getTooltip(), SubMenu.TOOL_TIP.getSubMenu());
//        globalSqaPage.getTextLike();
//
//        globalSqaPage.clickSubMenu(Menu.DEMO, SubMenu.DRAG_AND_DROP);
//        Assert.assertEquals( globalSqaPage.checkExitPictureBeforeMove(PictureToMove.PICTURE1.getPictureToMove()),true);
//        globalSqaPage.DragAndDrop(PictureToMove.PICTURE1.getPictureToMove());
//        Assert.assertEquals( globalSqaPage.checkExitPictureAfterMove(PictureToMove.PICTURE1.getPictureToMove()),true);
    }

    @AfterMethod
    public void endPage() {
        DriverUtil.webDriver.switchTo().defaultContent();
        DriverUtil.waitingTime(5);
        DriverUtil.quit();

    }
}
