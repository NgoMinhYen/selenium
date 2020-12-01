package pages;

import core.DriverUtil;
import core.Month;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class DatePickerPage extends BasePage {
    By btnInput = By.xpath("//input[@id='datePickerMonthYearInput']");
    By btnMonth = By.xpath("//select[@class='react-datepicker__month-select']");
    By btnYear = By.xpath("//select[@class='react-datepicker__year-select']");
    By btnDateAndTime = By.id("dateAndTimePickerInput");
    By btnSelectMonth = By.xpath("//select[@class='react-datepicker__month-select']");
    By btnSelectYears = By.xpath("//select[@class='react-datepicker__year-select']/option");
    By btnDateAndYear = By.id("datePickerMonthYearInput");

    public void inputDatePicker(String date) {
        DriverUtil.click(btnInput);
        DriverUtil.click(btnSelectMonth);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH);
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy", Locale.ENGLISH);
        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("dd", Locale.ENGLISH);
        LocalDate ld = LocalDate.parse(date, dtf);
        String month_name = dtf2.format(ld);
        String year_name = dtf3.format(ld);
        String day_name = dtf4.format(ld);
        DriverUtil.click(By.xpath(String.format("//option[contains(.,'%s')]", month_name)));
        List<WebElement> listYear = DriverUtil.findElements(btnSelectYears);
        for (WebElement yearInput : listYear) {
            if (yearInput.getText().equals(year_name)) {
                yearInput.click();
            }
        }
        DriverUtil.waitingTime(1);
        DriverUtil.click(By.xpath(String.format("//div[@id='datePickerMonthYear']//div[@role='listbox']/div/div[contains(.,'%s')and (not(contains(@class,'outside-month')))]", day_name)));
        String elementval = DriverUtil.findElement(btnDateAndYear).getAttribute("value");
        System.out.println("JJJ:" + elementval);
//        String date = convertMonth.getMonth() + "/" + convertDay(day) + "/" + year;
//        System.out.println("LLL:" + date);
//        Assert.assertEquals(elementval, date);
    }

    public String convertDay(int day) {
        String dd = String.valueOf(day);
        if (day < 10) {
            dd = String.format("0%s", day);
        }
        return dd;
    }

    public void inputDateAndTime(String time) {
        DriverUtil.click(btnDateAndTime);
//        DriverUtil.click(By.xpath("//span[@class='react-datepicker__month-read-view--down-arrow']"));
        DriverUtil.click(By.xpath(String.format("//ul[@class='react-datepicker__time-list']/li[contains(.,'%s')]", time)));

    }

}
