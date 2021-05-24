package pages;

import core.Button;
import core.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class MenuPage extends BasePage {
    Button btnWidgets = new Button(By.xpath("//div[contains(@class,'top-card')][4]"));
    Button btnSlider = new Button(By.xpath("//span[contains(.,'Menu')]//parent::li"));
    Button btnMainItem2 = new Button(By.xpath("//a[contains(.,'Main Item 2')]"));
    Button btnSubSubList = new Button(By.xpath("//a[contains(.,'SUB SUB LIST »')]//parent::li"));
    Button btnSubSubItem = new Button(By.xpath("//a[contains(.,'Sub Sub Item 2')]"));

    public void clickSubSubItem() {
        btnWidgets.click();
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", btnSlider.getWebElement());
        btnSlider.click();
        DriverUtil.waitForElemetClickAble(btnMainItem2, normalTime);
        Actions actions = new Actions(DriverUtil.getWebDriver());
        actions.moveToElement(btnMainItem2.getWebElement()).build().perform();

        DriverUtil.waitForElemetClickAble(btnSubSubList, normalTime);
        btnSubSubList.click();
        btnSubSubItem.click();
    }
}
