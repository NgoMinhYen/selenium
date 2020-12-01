package pages;

import core.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class AutoCompletePage extends BasePage {
    By btnWidgets = By.xpath("//div[@class='accordion']/div[4]");
    By btnAutoComplete = By.xpath("//span[contains(.,'Auto Complete')]//parent::li");
    By btnInputText = By.xpath("//input[@id='autoCompleteMultipleInput']");
    By menuList = By.xpath("//div[@class='auto-complete__menu-list auto-complete__menu-list--is-multi css-11unzgr']//div");
    By lblColor = By.xpath("//div[@class='css-12jo7m5 auto-complete__multi-value__label']");
    By btnRemoveColor = By.xpath("//div[@class='css-xb97g8 auto-complete__multi-value__remove']");
    By btnSingleColor = By.xpath("//input[@id='autoCompleteSingleInput']");
    By txtSingleColor = By.xpath("//div[@class='auto-complete__single-value css-1uccc91-singleValue']");

    public void choiceColorInAutoComplete(List<String> listColor) {
        DriverUtil.click(btnWidgets);
        DriverUtil.click(btnAutoComplete);
        for (String color : listColor) {
            DriverUtil.sendKey(btnInputText, color);
            List<WebElement> optionsToSelect = DriverUtil.findElements(menuList);
            for (WebElement option : optionsToSelect) {
                System.out.println(option);
                if (option.getText().equals(color)) {
                    System.out.println("selected:" + color);
                    option.click();
                    break;
                }
            }
            DriverUtil.waitingTime(1);
        }

    }

    public List<String> checkColorReturn() {
        List<WebElement> listColorReturn = DriverUtil.findElements(lblColor);
        List<String> colorReturn = new ArrayList<String>();
        for (WebElement color : listColorReturn) {
            colorReturn.add(color.getText());
        }
        return colorReturn;

    }

    public void removeColorAndCheckListColorAfterRemove(String color) {
        List<WebElement> listColorReturn = DriverUtil.findElements(lblColor);
        for (int i = 0; i < listColorReturn.size(); i++) {
            if (listColorReturn.get(i).getText().equals(color)) {
                DriverUtil.click(By.xpath(String.format("(//div[@class='css-xb97g8 auto-complete__multi-value__remove'])[%d+1]", i)));
            }
        }
        DriverUtil.waitingTime(1);
        List<WebElement> listColorAfter = DriverUtil.findElements(By.xpath("//div[@class='css-1rhbuit-multiValue auto-complete__multi-value']"));
        List<String> colorReturn = new ArrayList<String>();
        for (WebElement colorAfter : listColorAfter) {
            colorReturn.add(colorAfter.getText());
        }
        Assert.assertFalse(listColorReturn.contains(color));

    }

    public void inputSingleColorName(String color) {
        DriverUtil.sendKey(btnSingleColor, color);
        Assert.assertTrue(DriverUtil.getText(txtSingleColor).contains(color));
    }

}
