package pages;

import core.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class WindowPage extends BasePage {

    public void getNewTab() {
        String handle = DriverUtil.getWebDriver().getWindowHandle();
        System.out.println(handle);
        DriverUtil.click(By.id("tabButton"));
        Set handles = DriverUtil.getWebDriver().getWindowHandles();
        System.out.println(handles);
        for (String handle1 : DriverUtil.getWebDriver().getWindowHandles()) {
            System.out.println(handle1);
            DriverUtil.webDriver.switchTo().window(handle1);
        }
        System.out.println("HHHH:" + DriverUtil.getText(By.id("sampleHeading")));

       DriverUtil.webDriver.close();
       DriverUtil.webDriver.switchTo().window(handle);

    }

    public void getNewWindow() {
        String handle = DriverUtil.getWebDriver().getWindowHandle();
        System.out.println(handle);
        DriverUtil.click(By.id("windowButton"));
        Set handles = DriverUtil.getWebDriver().getWindowHandles();
        System.out.println(handles);
        for (String handle1 : DriverUtil.getWebDriver().getWindowHandles()) {
            System.out.println(handle1);
            DriverUtil.webDriver.switchTo().window(handle1);
        }
        System.out.println("KKKKKK:" + DriverUtil.getText(By.id("sampleHeading")));

    }




}
