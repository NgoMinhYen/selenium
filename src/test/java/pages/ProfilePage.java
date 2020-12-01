package pages;

import core.DriverUtil;
import org.openqa.selenium.By;

public class ProfilePage extends BasePage{
    By txtUserName = By.xpath("//input[@name='name']");
    By txtEmail = By.xpath("//input[@name='email']");
    By txtResult = By.xpath("//div[@id='form-container']//following-sibling::pre");
    By btnNextSection = By.xpath("//a[@class='btn btn-block btn-info']");
    By rdConsole = By.xpath("//input[@type='radio']");
    By txtResultPage2 = By.xpath("//div[@id='form-container']//following-sibling::pre");
    By btnNextSection2 = By.xpath("//a[@class='btn btn-block btn-info']");
    By btnSubmit = By.xpath("//button[@type='submit']");

    public void addProfile(String userName, String email) {
        DriverUtil.waitVisibilityOfElementLocated(txtUserName, normalTime);
        DriverUtil.sendKey(txtUserName, userName);
        DriverUtil.sendKey(txtEmail, email);
    }

    public String getTextResult() {
        return DriverUtil.getText(txtResult).trim();
    }

    public void clickNextSectionOnProfile() {
        DriverUtil.click(btnNextSection);
    }

    public void choiceRadioButton(String value) {
        DriverUtil.waitForElementNotChange(rdConsole, normalTime);
        DriverUtil.clickRadio(rdConsole, "value", value);
    }

    public String getTextResult2() {
        return DriverUtil.getText(txtResultPage2).trim();
    }

    public void clickNextSectionOnInterests() {
        DriverUtil.click(btnNextSection2);
    }

    public void clickSubmit() {
        DriverUtil.waitVisibilityOfElementLocated(btnSubmit, normalTime);
        DriverUtil.click(btnSubmit);
    }
}
