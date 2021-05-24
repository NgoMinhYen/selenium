package pages;

import core.*;
import dataObject.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class TextBoxPage extends BasePage {
    public GeneralPage menuTools = new GeneralPage();
    Button btnElement = new Button(By.xpath("//div[@class='element-group'][1]"));
    Button btnTextBox = new Button(By.xpath("//div[@class='element-group'][1]//li[@id='item-0']"));
    Button btnFullName = new Button(By.id("userName"));
    Button btnEmail = new Button(By.id("userEmail"));
    Button btnCurrentAddress = new Button(By.id("currentAddress"));
    Button btnPermanentAddress = new Button(By.id("permanentAddress"));
    Button btnSubmit = new Button(By.id("submit"));
    String elementOutPut = "//div[@id='output']//p[@id='%s']";
    Label lbOutputName = new Label(By.xpath(String.format(elementOutPut, "name")));
    Label lbOutputEmail = new Label(By.xpath(String.format(elementOutPut, "email")));
    Label lbOutputCurrentAddress = new Label(By.xpath(String.format(elementOutPut, "currentAddress")));
    Label lbOutputPermanentAddress = new Label(By.xpath(String.format(elementOutPut, "permanentAddress")));
    Label lbOutput = new Label(By.id("output"));

    public void inputInTextBox(User user) {
        btnElement.click();
        btnTextBox.click();
        DriverUtil.waitingTime(normalTime);
        btnFullName.sendKeys(user.getName());
        btnEmail.sendKeys(user.getMail());
        btnCurrentAddress.sendKeys(user.getCurrentAddress());
        btnPermanentAddress.sendKeys(user.getPermanentAddress());
        btnSubmit.click();

    }



    public String getOutput(){
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", lbOutputName.getWebElement());
        return lbOutput.getText();
    }



    public String getOutputName() {
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", lbOutputName.getWebElement());
        return lbOutputName.getText();
    }

    public String getOutputEmail() {
        return lbOutputEmail.getText();
    }

    public String getOutputCurrentAddress() {
        return lbOutputCurrentAddress.getText();
    }

    public String getOutputPermanentAddress() {
        return lbOutputPermanentAddress.getText();
    }

}
