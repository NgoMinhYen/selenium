package pages;

import core.DriverUtil;
import org.openqa.selenium.By;

public class GlobeDrPage extends BasePage {
    By dbSignIn = By.xpath("//a[@translate='signIn']");

    public void Login(String name, String passWord) {
        DriverUtil.click(dbSignIn);

    }
}
