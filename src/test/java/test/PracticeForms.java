package test;

import common.ConvertDate;
import core.DriverUtil;
import core.ahihi;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PracticeFormPages;

import java.util.Arrays;
import java.util.List;

public class PracticeForms {
    PracticeFormPages practiceFormPages = new PracticeFormPages();
    ConvertDate convertDate = new ConvertDate();

    public String formatSubject(List<String> listSubject) {
        String subject = String.join(", ", listSubject);
        return subject;
    }

    public String formatHobbies(List<String> listHobbies) {
        String hobbies = String.join(", ", listHobbies);
        return hobbies;
    }

    @BeforeMethod
    public void setBaseUrl() {
        DriverUtil.initDriver(ahihi.CHROME);
        DriverUtil.maximizeWindow();
        DriverUtil.navigateTo("https://demoqa.com/");
    }

    @DataProvider(name = "dataProfile")
    public static Object[][] dataProfile() {
        return new Object[][]{{"Yên", "Ngo", "minhyen1311414@gmail.com", "23/05/2020", "Female", "0347249676",
                Arrays.asList("Computer Science", "Accounting", "Physics"), Arrays.asList("Reading", "Music")
                , "74 Ong Ich Khiem", "NCR", "Delhi", "D:/459.jpg"}};
    }

    @DataProvider(name = "inputLastNameHollow")
    public static Object[][] inputLastNameHollow() {
        return new Object[][]{{"Duy", "", "minhyen1311414@gmail.com", "23/05/2020", "Female", "0347249676",
                Arrays.asList("Computer Science", "Accounting", "Physics"), Arrays.asList("Reading", "Music")
                , "74 Ong Ich Khiem", "NCR", "Delhi", "D:/459.jpg"}};
    }


    @Test(dataProvider = "dataProfile", invocationCount = 1)
    public void inputAndCheckStudentRegistrationForm(String name, String lastName, String email, String date, String gender,
                                                     String number, List<String> listSubject, List<String> listHobbies,
                                                     String address, String state, String city, String picture) {

        String stateAndCity = state + " " + city;
        convertDate.convertDateFormat(date);
        practiceFormPages.openPracticeFormPage();
        practiceFormPages.inputStudentRegistrationForm(name, lastName, email, gender, number, listSubject, listHobbies, picture, address, date, state, city);
        practiceFormPages.submit();

        practiceFormPages.checkResultStudentRegistrationForm(convertDate.convertDateFormat(date));
        practiceFormPages.checkResultStudentRegistrationForm(formatSubject(listSubject));
        practiceFormPages.checkResultStudentRegistrationForm(formatHobbies(listHobbies));
        practiceFormPages.checkResultStudentRegistrationForm(stateAndCity);
    }

    @Test(dataProvider = "inputLastNameHollow")
    public void inputLastNameFail(String name, String lastName, String email, String date, String gender,
                                  String number, List<String> listSubject, List<String> listHobbies,
                                  String address, String state, String city, String picture) {

        practiceFormPages.openPracticeFormPage();
        practiceFormPages.inputStudentRegistrationForm(name, lastName, email, gender, number, listSubject, listHobbies, picture, address, date, state, city);
        practiceFormPages.submit();
        practiceFormPages.checkBorderColorAndIconWhenInputValueFail();
    }

    @AfterMethod
    public void endPage() {
        DriverUtil.waitingTime(3);
        DriverUtil.quit();
    }
}
