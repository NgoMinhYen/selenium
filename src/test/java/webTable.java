

import core.DriverUtil;
import core.ahihi;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import pages.WebTablesPage;
import test.WebTables;

import java.util.Map;

public class webTable {
    WebTablesPage webTablesPage = new WebTablesPage();


    @Given("I open {string}")
    public void iOpen(String url) {
        DriverUtil.initDriver(ahihi.CHROME);
        DriverUtil.maximizeWindow();
        DriverUtil.navigateTo(url);
        DriverUtil.implicitlyWait(10);
    }

//    @And("row is display")
//    public void rowIsDisplay() {
//        Assert.assertTrue(webTablesPage.isDisplayedRow(firstName, lastName, email, age, salary, department));
//    }

    @And("I add data for web table")
    public void iAddDataForWebTable(Map<String,Object> dataTable) {
        webTablesPage.addNewMemberForWebTables(dataTable.get("firstName").toString(),dataTable.get("lastName").toString(),
                dataTable.get("email").toString(),dataTable.get("age").toString(),dataTable.get("salary").toString(),
                dataTable.get("department").toString());
    }

    @And("close page")
    public void closePage() {
        DriverUtil.waitingTime(5);
        DriverUtil.quit();
    }

    @And("row is display")
    public void rowIsDisplay() {

    }

}
