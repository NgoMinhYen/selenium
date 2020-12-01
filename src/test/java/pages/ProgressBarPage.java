package pages;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import core.DriverUtil;
import org.openqa.selenium.By;

public class ProgressBarPage extends BasePage {
    By btnStartAndStop = By.id("startStopButton");
    By getValueProgressBar = By.xpath("//div[@role='progressbar']");

    public void startProgressBar(int value) {
        DriverUtil.click(btnStartAndStop);
        String getValue = "";
        for (int i = 1; i <= 10; i++) {
            DriverUtil.waitingTime(i);
            getValue = DriverUtil.findElement(getValueProgressBar).getAttribute("aria-valuenow");
            if (Integer.parseInt(getValue) >= value) {
                DriverUtil.click(btnStartAndStop);
                DriverUtil.waitForElementNotChange(getValueProgressBar, normalTime);

                break;
            }
        }
        System.out.println("kkk:" + DriverUtil.getText(getValueProgressBar));
    }
}
