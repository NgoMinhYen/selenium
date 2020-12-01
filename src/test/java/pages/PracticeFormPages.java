package pages;

import core.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PracticeFormPages extends BasePage {
    By btnElements = By.xpath("//h5[contains(.,'Forms')]");
    By tbnForms = By.xpath("//div[@class='header-wrapper'][contains(.,'Forms')]");
    By tbnPracticeFrom = By.xpath("//span[contains(.,'Practice Form')]");
    By txtName = By.id("firstName");
    By txtLastName = By.id("lastName");
    By txtEmail = By.id("userEmail");
    By txtDateOfBrith = By.id("dateOfBirthInput");
    By btnSelectMonth = By.xpath("//select[@class='react-datepicker__month-select']");
    By btnSelectYears = By.xpath("//select[@class='react-datepicker__year-select']/option");
    String raGender = "//label[contains(.,'%s')]";
    By txtUserNumber = By.id("userNumber");
    By txtSubject = By.id("subjectsContainer");
    String raHobbies = "//label[contains(.,'%s')]";
    By btnInputSubject = By.id("subjectsInput");
    By lblAutoSubject = By.xpath("//div[@class='subjects-auto-complete__menu-list subjects-auto-complete__menu-list--is-multi css-11unzgr']/div");
    By btnSelectPicture = By.id("uploadPicture");
    By txtAddress = By.id("currentAddress");
    By btnState = By.id("state");
    String selectState = "//div[@class=' css-11unzgr']/div[contains(.,'%s')]";
    By btnSubmit = By.id("submit");
    By btnCity = By.id("city");
    String selectCity = "//div[@class=' css-11unzgr']/div[contains(.,'%s')]";
    By table = By.xpath("//div[@class='table-responsive']//tbody//td");

    public void clickGender(String gender) {
        DriverUtil.click(By.xpath(String.format(raGender, gender)));
    }

    public void clickHobbies(List<String> listHobbies) {
        for (String hobby : listHobbies) {
            DriverUtil.click(By.xpath(String.format(raHobbies, hobby)));
            DriverUtil.waitingTime(1);
        }

    }

    public void selectSubject(List<String> listSubject) {
        for (String subject : listSubject) {
            DriverUtil.sendKey(btnInputSubject, subject);
            List<WebElement> optionsToSelect = DriverUtil.findElements(lblAutoSubject);
            for (WebElement option : optionsToSelect) {
                if (option.getText().equals(subject)) {
                    option.click();
                    break;
                }
            }
            DriverUtil.waitingTime(1);
        }
    }

    public void clickState(String state) {
        DriverUtil.click(By.xpath(String.format(selectState, state)));
    }

    public void clickCity(String city) {
        DriverUtil.click(By.xpath(String.format(selectCity, city)));
    }

    public void clickDate(String date) {
        System.out.println("JJJ: " + date);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH);
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy", Locale.ENGLISH);
        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("dd", Locale.ENGLISH);
        LocalDate ld = LocalDate.parse(date, dtf);
        String month_name = dtf2.format(ld);
        String year_name = dtf3.format(ld);
        String day_name = "0" + dtf4.format(ld);
        DriverUtil.click(txtDateOfBrith);
        DriverUtil.click(btnSelectMonth);
        DriverUtil.click(By.xpath(String.format("//option[contains(.,'%s')]", month_name)));
        List<WebElement> listYear = DriverUtil.findElements(btnSelectYears);
        for (WebElement yearInput : listYear) {
            if (yearInput.getText().equals(year_name)) {
                yearInput.click();
            }
        }
        DriverUtil.click(By.xpath(String.format("//div[@id='dateOfBirth-wrapper']//div[@role='listbox']/div/div[contains(@class,'%s')and (not(contains(@class,'outside-month')))]", day_name)));
    }

    public void openPracticeFormPage() {
        DriverUtil.click(btnElements);
        DriverUtil.click(tbnForms);
        DriverUtil.click(tbnPracticeFrom);
    }

    public void inputName(String name) {
        DriverUtil.sendKey(txtName, name);

    }

    public void inputLastName(String lastName) {
        DriverUtil.sendKey(txtLastName, lastName);
    }

    public void inputEmail(String email) {
        DriverUtil.sendKey(txtEmail, email);
    }

    public void selectGender(String gender) {
        clickGender(gender);
    }

    public void inputMobileNumber(String userNumber) {
        DriverUtil.sendKey(txtUserNumber, userNumber);
    }

    public void inputSubject(List<String> listSubject) {
        DriverUtil.click(txtSubject);
        selectSubject(listSubject);
    }

    public void selectHobbies(List<String> listHobbies) {
        DriverUtil.waitingTime(1);
        clickHobbies(listHobbies);
    }

    public void selectPicture(String picture) {
        DriverUtil.sendKey(btnSelectPicture, picture);
    }

    public void inputAddress(String address) {
        DriverUtil.sendKey(txtAddress, address);
    }

    public void selectDateOfBirth(String date) {
        JavascriptExecutor jl = (JavascriptExecutor) DriverUtil.webDriver;
        jl.executeScript("arguments[0].scrollIntoView();", DriverUtil.findElement(btnSubmit));
        clickDate(date);
    }

    public void selectState(String state) {
        DriverUtil.click(btnState);
        DriverUtil.waitVisibilityOfElementLocated(By.xpath(String.format(selectState, state)), normalTime);
        clickState(state);
    }

    public void selectCity(String city) {
        DriverUtil.click(btnCity);
        DriverUtil.waitVisibilityOfElementLocated(By.xpath(String.format(selectCity, city)), normalTime);
        clickCity(city);

    }

    public void submit() {
        DriverUtil.click(btnSubmit);
        DriverUtil.waitingTime(5);

    }


    public void inputStudentRegistrationForm(String name, String lastName, String email, String gender, String userNumber,
                                             List<String> listSubject, List<String> listHobbies, String picture, String address, String date,
                                             String state, String city) {
        inputName(name);
//        inputLastName(lastName);
        inputEmail(email);
        selectGender(gender);
        inputMobileNumber(userNumber);
        inputSubject(listSubject);
        selectHobbies(listHobbies);
        selectPicture(picture);
        inputAddress(address);
        selectDateOfBirth(date);
        selectState(state);
        selectCity(city);

    }

    public void checkResultStudentRegistrationForm(String text) {
        List<WebElement> listValues = DriverUtil.findElements(table);
        List<String> result = new ArrayList<>();
        for (WebElement value : listValues) {
            result.add(value.getText());
        }
        System.out.println("kkk: " + result);
        System.out.println("kkk:" + text);
        Assert.assertTrue(result.contains(text));
    }

    public void checkBorderColorAndIconWhenInputValueFail() {
        String colorExpected = "rgb(220, 53, 69)";
        String iconEcpected = "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='12' height='12' fill='none' stroke='%23dc3545' viewBox='0 0 12 12'%3e%3ccircle cx='6'" +
                " cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")";
        String colorActual = DriverUtil.getCssValue(txtLastName, "border-color");
        String iconActual = DriverUtil.getCssValue(txtLastName, "background-image");
        System.out.println("KKKK: " + iconActual);
        System.out.println("LLLL: " + colorActual);
        Assert.assertEquals(colorActual, colorExpected);
        Assert.assertEquals(iconActual, iconEcpected);
    }

}
