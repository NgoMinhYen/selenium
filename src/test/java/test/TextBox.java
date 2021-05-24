package test;

import core.DriverUtil;
import core.ahihi;
import dataObject.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TextBoxPage;

public class TextBox {
    TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeMethod
    public void setBaseUrl() {
        DriverUtil.initDriver(ahihi.CHROME);
        DriverUtil.maximizeWindow();
        DriverUtil.navigateTo("https://demoqa.com/elements");
        DriverUtil.implicitlyWait(5);
    }

    @DataProvider(name = "dataProfile")
    public static Object[][] dataProfile() {
        return new Object[][]{{"Minh Yên", "minhyen1311414@gmail.com", "606 duong 3 thang 2", "Khanh Hoa"}
        };
    }

    @Test(dataProvider = "dataProfile")
    public void enterAndGetMessage(String name, String email, String currentAddress, String permananetAddess ) {
        User user = new User(name,email,currentAddress,permananetAddess);
        textBoxPage.inputInTextBox(user);
        String expected = String.format("Name:%s\nEmail:%s\nCurrent Address :%s\nPermananet Address :%s", user.getName(), user.getMail(),user.getCurrentAddress(), user.getPermanentAddress());
        System.out.println("jjj: " + expected);
        Assert.assertEquals(textBoxPage.getOutput(), expected.trim());

    }

    @AfterMethod
    public void endPage() {
        DriverUtil.waitingTime(5);
        DriverUtil.quit();
    }
}
