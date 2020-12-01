package pages;

import core.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Converter;

public class SliderPage extends BasePage {

    public void moveSlider(int percent) {
        DriverUtil.click(By.xpath("//div[@class='accordion']/div[4]"));
        DriverUtil.click(By.xpath("//span[contains(.,'Slider')]//parent::li"));
        WebElement slider = DriverUtil.findElement(By.xpath("//div[@id='sliderContainer']//input[@type='range']"));
        int width = slider.getSize().getWidth();
        int height = slider.getSize().getHeight();
        Actions move = new Actions(DriverUtil.getWebDriver());
        move.clickAndHold(slider).moveByOffset(-(width / 2), 0).
                moveByOffset((int) Math.floor((width * percent)/100), height/2);
        move.release().build().perform();
        DriverUtil.waitingTime(3);
        String value = DriverUtil.findElement(By.id("sliderValue")).getAttribute("value");
        System.out.println("JJJ:" + value);
        System.out.println("HHHH: " + slider.getLocation());
        System.out.println("KKKK: " + slider.getSize().getWidth());
    }
}
