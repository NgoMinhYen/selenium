package test;

import core.DriverUtil;
import core.Month;
import core.ahihi;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DatePickerPage;

public class DatePicker {
    DatePickerPage datePickerPage = new DatePickerPage();

    @BeforeMethod
    public void setBaseUrl() {
        DriverUtil.initDriver(ahihi.CHROME);
        DriverUtil.maximizeWindow();
        DriverUtil.navigateTo("https://demoqa.com/date-picker");
    }

    @Test
    public void datePicker() {
        datePickerPage.inputDatePicker("2020-03-26");
//        datePickerPage.inputDateAndTime("17:30");
    }

    @AfterMethod
    public void endPage() {
        DriverUtil.waitingTime(5);
        DriverUtil.quit();

    }
}
