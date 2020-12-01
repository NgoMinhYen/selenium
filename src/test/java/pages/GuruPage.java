package pages;

import core.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class GuruPage extends BasePage {
    By btOrange = By.xpath("//a[contains(.,' 5000 ')]//parent::li[@data-id='2']");
    By btCenter = By.xpath("//ol[@id='amt7']");

    public void dragAndDrop() {
        DriverUtil.waitVisibilityOfElementLocated(btOrange,normalTime);
        new Actions(DriverUtil.webDriver).dragAndDrop(DriverUtil.findElement(btOrange),DriverUtil.findElement(btCenter)).build().perform();
    }

}
