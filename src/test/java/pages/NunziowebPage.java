package pages;

import core.DriverUtil;
import org.openqa.selenium.By;

import java.text.DecimalFormat;

public class NunziowebPage extends BasePage {
    By pathIframe = By.xpath("//iframe[@name='oddcouple']");
    By txtCenter = By.xpath("//td/div[@align='center']");

    public void                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            getTextCenter() {
        DriverUtil.waitVisibilityOfElementLocated(pathIframe, normalTime);
        DriverUtil.webDriver.switchTo().frame(DriverUtil.findElement(pathIframe));
        DriverUtil.getText(txtCenter);
        System.out.println("SSSSS: " + DriverUtil.getText(txtCenter));
        DriverUtil.webDriver.switchTo().defaultContent();
    }

}
