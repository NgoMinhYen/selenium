package pages;

import core.Button;
import core.Label;
import core.RadioButton;
import org.openqa.selenium.By;

public class RadioButtonPage extends BasePage {
    Button btnElement = new Button(By.xpath("//div[@class='element-group'][1]"));
    Button btnTextBox = new Button(By.xpath("//div[@class='element-group'][1]//li[@id='item-2']"));
    RadioButton rdYes = new RadioButton(By.xpath("//label[@for='yesRadio']"));
    RadioButton rdImpressive = new RadioButton(By.id("impressiveRadio"));
    Label lbText = new Label(By.xpath("//span[@class='text-success']"));

    public void clickRadioButton() {
        btnElement.click();
        btnTextBox.click();
        if (rdYes.isSelected() == false) {
            rdYes.click();
        }
    }
    public String getTextAfterClick(){
       return lbText.getText();
    }
}
