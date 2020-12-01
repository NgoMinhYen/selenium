package test;

import core.DriverUtil;
import core.ahihi;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ProfilePage;

public class Profile {
    ProfilePage loginPage = new ProfilePage();

    @BeforeMethod
    public void setBaseUrl() {
        DriverUtil.initDriver(ahihi.CHROME);
        DriverUtil.maximizeWindow();
        DriverUtil.navigateTo("http://www.way2automation.com/angularjs-protractor/multiform/#/form/profile");
    }

    @DataProvider(name = "dataProfile")
    public static Object[][] dataProfile() {
        return new Object[][]{{"Minh Yên", "minhyen1311414@gmail.com", "xbox"}};
    }

    @Test(dataProvider = "dataProfile", invocationCount = 1)
    public void login(String userName, String email, String value) {
        loginPage.addProfile(userName, email);
        String expected = String.format("{\"name\":\"%s\",\"email\":\"%s\"}", userName, email);
        Assert.assertEquals(loginPage.getTextResult(), expected.trim());
        loginPage.clickNextSectionOnProfile();

        loginPage.choiceRadioButton(value);
        String expected1 = String.format("{\"name\":\"%s\",\"email\":\"%s\",\"type\":\"%s\"}", userName, email, value);
        Assert.assertEquals(loginPage.getTextResult2(), expected1.trim());
        loginPage.clickNextSectionOnInterests();

        loginPage.clickSubmit();
        System.out.println("$$$$: " + loginPage.getTextAlert());
    }

    @AfterMethod
    public void endPage() {
        DriverUtil.waitingTime(3);
        DriverUtil.quit();
    }
}
