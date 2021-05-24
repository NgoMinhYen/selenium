package test;

import core.DriverUtil;
import core.ahihi;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.WebTablesPage;

public class WebTables {
    WebTablesPage webTablesPage = new WebTablesPage();

    @BeforeMethod
    public void setBaseUrl() {
        DriverUtil.initDriver(ahihi.CHROME);
        DriverUtil.maximizeWindow();
        DriverUtil.navigateTo("https://demoqa.com");
        DriverUtil.implicitlyWait(10);
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] dataProfile() {
        return new Object[][]{{"Ngo", "Yen", "minhyen1311414@gmail.com", "25", "9000000", "xbox"}};
    }

    @Test(dataProvider = "dataProvider")
    public void addDataForTables(String firstName, String lastName, String email, String age, String salary, String department) {
        webTablesPage.addNewMemberForWebTables(firstName, lastName, email, age, salary, department);
        Assert.assertTrue(webTablesPage.isDisplayedRow(firstName, lastName, email, age, salary, department));
    }

    @AfterMethod
    public void endPage() {
        DriverUtil.waitingTime(5);
        DriverUtil.quit();

    }
}
