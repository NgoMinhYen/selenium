package pages;

import core.Button;
import core.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Converter;

public class SliderPage extends BasePage {

    Button btnWidgets = new Button(By.xpath("//div[contains(@class,'top-card')][4]"));
    Button btnSlider = new Button(By.xpath("//span[contains(.,'Slider')]//parent::li"));
    Button slider = new Button(By.xpath("//div[@id='sliderContainer']//input[@type='range']"));
    public void moveSlider(int percent) {
        btnWidgets.click();
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", btnSlider.getWebElement());
        btnSlider.click();
        int width = slider.getSize().getWidth();
        int height = slider.getSize().getHeight();
        System.out.println("jkj: "+width);
        Actions move = new Actions(DriverUtil.getWebDriver());
        move.clickAndHold(slider.getWebElement()).moveByOffset(-(width / 2), 0).
                moveByOffset((width * percent)/100, 0);
        move.release().build().perform();
        DriverUtil.waitingTime(3);
        String value = DriverUtil.findElement(By.id("sliderValue")).getAttribute("value");
        System.out.println("JJJ:" + value);
        System.out.println("HHHH: " + slider.getLocation());
        System.out.println("KKKK: " + slider.getSize().getWidth());
    }
}
