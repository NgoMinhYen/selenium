package pages;

import core.DriverUtil;
import core.Menu;
import core.SubMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class GlobalSqaPage extends BasePage {
    By dbHome = By.id("menu-item-1513");
    By dbTesterBub = By.xpath("(//a[contains(.,'Tester’s Hub')])[1]");
    By txtTooltip = By.xpath("//div[@class='page_heading']/h1");
    By dbVideoBasic = By.id("Video Based");
    By txtILikeThis = By.xpath("//div[@class='ui-tooltip-content']");
    String xPathMenu = "//a[contains(.,'%s')]//parent::li";
    String xPathSubMenu = "//a[contains(.,'%s')]//parent::li";
    By iframeDemo = By.xpath("(//iframe[@class='demo-frame lazyloaded'])[2]");
    By btLike = By.xpath("//button[contains(.,'Like')]");
    By iframeDragAndDrop = By.xpath("//iframe[@class='demo-frame lazyloaded']");
    String pathPictureToMove = "//h5[.='%s']//parent::li";
    By moveToElement = By.id("trash");

    private void openMenu(String main, String menu){
        DriverUtil.waitVisibilityOfElementLocated(dbHome, normalTime);
        By dbDemoTestingSite = By.xpath(String.format(xPathMenu, main));
        By dbTooltip = By.xpath(String.format(xPathSubMenu, menu));

        DriverUtil.getActions()
                .moveToElement(DriverUtil.findElement(dbTesterBub))
                .moveToElement(DriverUtil.findElement(dbDemoTestingSite))
                .moveToElement(DriverUtil.findElement(dbTooltip))
                .click().build().perform();
    }

    public void clickSubMenu(Menu menu, SubMenu submenu) {


        DriverUtil.waitVisibilityOfElementLocated(dbHome, normalTime);
        By dbDemoTestingSite = By.xpath(String.format(xPathMenu, menu.getMenu()));
        By dbTooltip = By.xpath(String.format(xPathSubMenu, submenu.getSubMenu()));

        DriverUtil.getActions()
                .moveToElement(DriverUtil.findElement(dbTesterBub))
                .moveToElement(DriverUtil.findElement(dbDemoTestingSite))
                .moveToElement(DriverUtil.findElement(dbTooltip))
                .click().build().perform();
    }

    public String getTooltip() {
        DriverUtil.waitVisibilityOfElementLocated(txtTooltip, normalTime);
        return DriverUtil.getText(txtTooltip);
    }

    public void getTextLike() {
        DriverUtil.click(dbVideoBasic);
        DriverUtil.waitVisibilityOfElementLocated(iframeDemo, normalTime);
        DriverUtil.webDriver.switchTo().frame(DriverUtil.findElement(iframeDemo));
        DriverUtil.waitVisibilityOfElementLocated(btLike, normalTime);
        new Actions(DriverUtil.getWebDriver()).clickAndHold(DriverUtil.findElement(btLike)).build().perform();
        DriverUtil.waitVisibilityOfElementLocated(txtILikeThis, normalTime);
        DriverUtil.getText(txtILikeThis);
        System.out.println("DDD: " + DriverUtil.getText(txtILikeThis));
        DriverUtil.webDriver.switchTo().defaultContent();

    }

    public void DragAndDrop(String text) {
        By fromPicture = By.xpath(String.format(pathPictureToMove, text));
        Actions actions = new Actions(DriverUtil.webDriver);
        actions.dragAndDrop(DriverUtil.findElement(fromPicture), DriverUtil.findElement(moveToElement)).build().perform();

    }

    public boolean checkExitPictureBeforeMove(String text) {
        DriverUtil.waitVisibilityOfElementLocated(iframeDragAndDrop, normalTime);
        DriverUtil.webDriver.switchTo().frame(DriverUtil.findElement(iframeDragAndDrop));
        return checkExitPicture(By.xpath("//ul[@id='gallery']/li/h5"), text);

    }

    public boolean checkExitPictureAfterMove(String text) {
        DriverUtil.waitVisibilityOfElementLocated(By.xpath("//div[@id='trash']//li"),normalTime);
        return checkExitPictureAfterMove(By.xpath("//div[@id='trash']//li/h5"), text);
    }

    public static boolean checkExitPicture(By by, String text) {
        boolean isExit = false;
        List<WebElement> list = DriverUtil.findElements(by);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().equals(text)) {
                isExit = true;
            }
        }
        return isExit;
    }
    public static boolean checkExitPictureAfterMove(By by, String text) {
        boolean isExit = false;
        List<WebElement> list = DriverUtil.findElements(by);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAttribute("innerHTML").equals(text)) {
                isExit = true;
            }
        }
        return isExit;
    }
}
