package pages;

import core.Button;
import core.DriverUtil;
import core.Elements;
import core.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class SignupGlobeDrPage {
    private final Button btnSignUp = new Button(By.xpath("//button[contains(@class,'btn-sign-up')]"));
    private final TextBox txtUserName = new TextBox(By.id("UserName"));
    private final TextBox txtPassword = new TextBox(By.id("Password"));
    private final TextBox txtName = new TextBox(By.id("Name"));

    public void selectSignup() {
        Elements.waitForElemetClickAble(btnSignUp, 10);
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", btnSignUp.getWebElement());
        btnSignUp.click();
    }

    public void signUp(String phoneNumber, String pass, String name) {
        selectSignup();
        Elements.waitingTime(10);
        txtUserName.sendKeys(phoneNumber);
        txtPassword.sendKeys(pass);
        txtName.sendKeys(name);
    }

    public void endPage() {
        DriverUtil.waitingTime(5);
        DriverUtil.quit();
    }
}
