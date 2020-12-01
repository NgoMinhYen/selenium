package pages;

import core.DriverUtil;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    By txtUserName = By.id("username");
    By txtPassword = By.id("password");
    By txtReName = By.id("formly_1_input_username_0");
    By btnLogin = By.xpath("//button[@class='btn btn-danger']");
    By txtHome = By.xpath("//p[contains(.,\"You're logged in!!\")]");

    public void login(String userName, String pass, String name) {
        DriverUtil.waitVisibilityOfElementLocated(txtUserName, normalTime);
        DriverUtil.sendKey(txtUserName, userName);
        DriverUtil.sendKey(txtPassword, pass);
        DriverUtil.sendKey(txtReName, name);
        DriverUtil.click(btnLogin);
    }

    public String getTextHome() {
        DriverUtil.waitVisibilityOfElementLocated(txtHome, normalTime);
       return DriverUtil.getText(txtHome);
    }

}
