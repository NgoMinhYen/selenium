package pages;

import core.*;
import org.openqa.selenium.By;

public class WebTablesPage extends BasePage {
    GeneralPage generalPage = new GeneralPage();
    Button btnAdd = new Button(By.id("addNewRecordButton"));
    TextBox txtFirstName = new TextBox(By.id("firstName"));
    TextBox txtLastName = new TextBox(By.id("lastName"));
    TextBox txtEmail = new TextBox(By.id("userEmail"));
    TextBox txtAge = new TextBox(By.id("age"));
    TextBox txtSalary = new TextBox(By.id("salary"));
    TextBox txtDepartment = new TextBox(By.id("department"));
    Button btnSubmit = new Button(By.id("submit"));
    String table = "//*[@role='row']/*[.='%s']/following-sibling::*[.='%s']/following-sibling::*[.='%s']/following-sibling::*[.='%s']/following-sibling::*[.='%s']/following-sibling::*[.='%s']";

    public void addNewMemberForWebTables(String firstName, String lastName, String email, String age, String salary, String department) {
        generalPage.openMenuGroup("Elements", "Web Tables");
        btnAdd.click();
        //DriverUtil.waitingTime(normalTime);
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtEmail.sendKeys(email);
        txtAge.sendKeys(age);
        txtSalary.sendKeys(salary);
        txtDepartment.sendKeys(department);
        btnSubmit.click();
        //DriverUtil.waitingTime(10);

    }

    public boolean isDisplayedRow(String firstName, String lastName, String email, String age, String salary, String department) {
        Label row = new Label(By.xpath(String.format(table, firstName, lastName, age, email, salary, department)));
        return row.isDisplayed();

    }
}
