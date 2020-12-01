package pages;

import core.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;

public class ProtractorPage extends BasePage {
    By txnStore = By.xpath("//input[@ng-model='data.root']");
    By listProdIncludedNotDisabled = By.xpath("//input[not(@disabled) and @ng-model='prod.included']");
    By listCheckBox = By.xpath("//input[@type='checkbox']");
    By listDisabled = By.xpath("//input[@disabled]//parent::h4");
    By chkGarageImprovement = By.xpath("//h3[contains(.,' Garage Improvement ')]//following-sibling::ul//input");
    By liCategories = By.xpath("//li[@ng-repeat='cat in division.categories']");

    public void getTextCheckBoxChosen() {
        DriverUtil.waitVisibilityOfElementLocated(txnStore, normalTime);
        List<WebElement> list = DriverUtil.findElements(listCheckBox);

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).isSelected()) {
                DriverUtil.getText(By.xpath(String.format("(//input[@type='checkbox'])[%d+1]/parent::h4", i)));
                System.out.println("AA: " + DriverUtil.getText(By.xpath(String.format("(//input[@type='checkbox'])[%d+1]/parent::h4", i))));
            }
        }
    }

    public void getTextCheckBoxChosen2() {
        DriverUtil.waitVisibilityOfElementLocated(txnStore, normalTime);
        List<WebElement> list = DriverUtil.findElements(listCheckBox);

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).isSelected()) {
                DriverUtil.getText(By.xpath(String.format("(//input[@type='checkbox'])[%d+1]/parent::h4", i)));
                System.out.println("AA: " + DriverUtil.getText(By.xpath(String.format("(//input[@type='checkbox'])[%d+1]/parent::h4", i))));
            }
        }
    }


    public void getTextDesable() {
        List<WebElement> list = DriverUtil.findElements(listDisabled);
        for (WebElement webElement : list) {
            System.out.println("AAA###: " + webElement.getText());
        }
    }

    public void getTextNotSelected() {
        List<WebElement> list = DriverUtil.findElements(listProdIncludedNotDisabled);
        for (int i = 0; i < list.size(); i++) {
            if (!(list.get(i).isSelected())) {
                DriverUtil.getText(By.xpath(String.format("(//input[not(@disabled) and @ng-model='prod.included'])[%d+1]/parent::h4", i)));
                System.out.println("####: " + DriverUtil.getText(By.xpath(String.format("(//input[not(@disabled) and @ng-model='prod.included'])[%d+1]/parent::h4", i))));

            }
        }
    }

    public void checkGarageImplement() {
        DriverUtil.check(chkGarageImprovement);
    }

    public boolean isSelected(String text) {
        By ckIntoGarage = By.xpath(String.format("//h4[contains(.,'%s')]/input[@type='checkbox']", text));
        return DriverUtil.isSelected(ckIntoGarage);
    }

    public void getTextHaveTowSelected() {
        List<WebElement> listCategories = DriverUtil.findElements(liCategories);

        for (int i = 0; i < listCategories.size(); i++) {
            List<WebElement> listChk = listCategories.get(i).findElements(By.xpath(".//input[@ng-model='prod.included']"));
            int count = 0;
            for (int j = 0; j < listChk.size(); j++) {
                if (listChk.get(j).isSelected()) {
                    count++;
                }
            }
            if (count >= 2) {
                System.out.println("aaaa: "+ listCategories.get(i).findElement(By.xpath(".//h3")).getText());
            }

        }
    }

}
