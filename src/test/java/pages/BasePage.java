package pages;

import core.DriverUtil;

public class BasePage {
    public int normalTime = 40;
    public String getTextAlert(){
        DriverUtil.waitForAlert(normalTime);
        return DriverUtil.alert();
    }


}
