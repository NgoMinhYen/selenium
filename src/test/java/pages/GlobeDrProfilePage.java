package pages;

import core.DriverUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GlobeDrProfilePage extends BasePage {
    By signinMenu = By.xpath("//a[@translate='signIn']");
    By txtUserName = By.id("UserName");
    By txtPhone = By.id("Password");
    By btnSelectCountry = By.xpath("//select[@class='form-control ng-untouched ng-pristine ng-valid']/option");
    By btnSignin = By.xpath("//button[@translate='signIn']");
    By btnAccount = By.xpath("//a[@href='/profile/info']");
    String templateSelect = "//label[@translate='%s']/preceding-sibling::select";
    String templateInput = "//label[@translate='%s']/preceding-sibling::input";
    String templateOption = "//label[@translate='%s']/preceding-sibling::select/option";
    By txtDateOfBirth = By.xpath("//input[@placeholder='Dd/mm/yyyy']");
    By btnSate = By.xpath("//div[@class='col-lg-6 col-12 pl0'][6]");
    By btnSelectSate = By.xpath("//div[@class='col-lg-6 col-12 pl0'][6]//select/option");
    By txtImage = By.xpath("//div[@class='por bg-image-model bd-radius-50p hover-container mb15 ofh']");

    public void selectCountryInLoginPage(String country) {
        DriverUtil.waitVisibilityOfElementLocated(By.xpath(String.format(templateOption, "country")), normalTime);
        List<WebElement> listCountry = DriverUtil.findElements(By.xpath(String.format(templateOption, "country")));
        for (WebElement countryName : listCountry) {
            if (countryName.getText().equals(country)) {
                countryName.click();
            }
        }
    }

    public void updateYourName(String name) {
        DriverUtil.waitVisibilityOfElementLocated(By.xpath("//div[@class='form-control mb15'][contains(.,'84347249676')]"), normalTime);
        DriverUtil.clear(By.xpath(String.format(templateInput, "yourName")));
        DriverUtil.sendKey(By.xpath(String.format(templateInput, "yourName")),name);

    }

    public void updateTitle() {
        DriverUtil.clear(By.xpath(String.format(templateInput, "title")));
        DriverUtil.sendKey(By.xpath(String.format(templateInput, "title")), DriverUtil.randomString(4));
    }

    public void updateEmail() {
        String email = DriverUtil.randomString(8) + "@gmail.com";
        DriverUtil.clear(By.xpath(String.format(templateInput, "email")));
        DriverUtil.sendKey(By.xpath(String.format(templateInput, "email")), email);
    }

    public void updateDateOfBirth(String date) {
        DriverUtil.click(txtDateOfBirth);
        DriverUtil.clear(txtDateOfBirth);
        DriverUtil.sendKey(txtDateOfBirth, date);

    }

    public void updateGender() {
        DriverUtil.click(By.xpath(String.format(templateSelect, "gender")));
        List<WebElement> listGender = DriverUtil.findElements(By.xpath(String.format(templateOption, "gender")));
        for (WebElement selectGender : listGender) {
            if (selectGender.getText().equals(DriverUtil.randomValue(listGender))) {
                selectGender.click();
            }
        }
    }


    public void updateVisitCountry() {
        DriverUtil.click(By.xpath(String.format(templateSelect, "visitCountry")));
        List<WebElement> listCountry = DriverUtil.findElements(By.xpath(String.format(templateOption, "visitCountry")));
        String visitCountry = DriverUtil.randomValue(listCountry);
        for (WebElement selectCountry : listCountry) {
            if (selectCountry.getText().equals(visitCountry)) {
                selectCountry.click();
            }
        }

    }

    public void updateCountry() {
        DriverUtil.waitingTime(5);
        DriverUtil.click(By.xpath(String.format(templateSelect, "country")));
        List<WebElement> listCountry = DriverUtil.findElements(By.xpath(String.format(templateOption, "country")));
        String country = DriverUtil.randomValue(listCountry);
        for (WebElement selectCountry : listCountry) {
            if (selectCountry.getText().equals(country)) {
                selectCountry.click();
            }
        }
    }

    public void updateRegionAndState() {
        DriverUtil.waitingTime(5);
//        DriverUtil.waitVisibilityOfElementLocated(btnSate,normalTime);
        DriverUtil.click(btnSate);
        DriverUtil.waitingTime(5);
        List<WebElement> listSate = DriverUtil.findElements(btnSelectSate);
        String state = DriverUtil.randomValue(listSate);
        for (WebElement selectSate : listSate) {
            System.out.println("UUU: "+ selectSate);
            if (selectSate.getText().equals(state)) {
//                DriverUtil.visibilityOf(selectSate,normalTime);
                selectSate.click();
            }
        }
    }

    public void updateCity() {
        DriverUtil.click(By.xpath(String.format(templateSelect, "city")));
        DriverUtil.waitVisibilityOfElementLocated(By.xpath(String.format(templateOption, "city")),normalTime);
        List<WebElement> listCity = DriverUtil.findElements(By.xpath(String.format(templateOption, "city")));
        String city = DriverUtil.randomValue(listCity);
        for (WebElement selectCity : listCity) {
            if (selectCity.getText().equals(city)) {
                selectCity.click();
            }
        }
    }

    public void updatePhoneNumber() {
        DriverUtil.clear(By.xpath(String.format(templateInput, "phoneNumber")));
        DriverUtil.sendKey(By.xpath(String.format(templateInput, "phoneNumber")), DriverUtil.randomNumber(9));

    }

    public void updateWorkPhone() {
        DriverUtil.sendKey(By.xpath(String.format(templateInput, "workPhone")), DriverUtil.randomString(15));
    }

    public void updatePicture() {
        DriverUtil.click(By.xpath("//div[@class='change-img-circle text-center btn-file']"));
        try {
            Runtime.getRuntime().exec("D:\\SourceCode\\myFristScript.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        DriverUtil.waitVisibilityOfElementLocated(By.xpath("//div[@class='center-block']/button[2]"), normalTime);
        DriverUtil.click(By.xpath("//div[@class='center-block']/button[2]"));

    }

    public void getUrlImage() {
        WebElement img = DriverUtil.findElement(txtImage);
        String url = img.getAttribute("style");
        System.out.println("HHHH:" + url);
        String regex = ".+?(\"(.*?)\")";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            File f = new File("D:\\image001.jpg");
            URL myUrl = null;
            try {
                myUrl = new URL(matcher.group(1).substring(1, matcher.group(1).length() - 1));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                FileUtils.copyURLToFile(myUrl, f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void updateAddress(String address) {
        DriverUtil.clear(By.id("address"));
        DriverUtil.sendKey(By.id("address"), address);
        DriverUtil.waitVisibilityOfElementLocated(By.xpath("//div[@class='pac-item'][1]"),normalTime);
        DriverUtil.click(By.xpath("//div[@class='pac-item'][1]"));
    }


    public void loginWithPhoneNumberAndPassword(String phoneNumber, String passWord, String country) {
        DriverUtil.waitVisibilityOfElementLocated(signinMenu, normalTime);
        DriverUtil.click(signinMenu);
        DriverUtil.waitVisibilityOfElementLocated(btnSignin, normalTime);
        DriverUtil.sendKey(txtUserName, phoneNumber);
        DriverUtil.sendKey(txtPhone, passWord);
        selectCountryInLoginPage(country);
        DriverUtil.waitingTime(4);
        DriverUtil.click(btnSignin);

    }

    public void choiceAccountFromDashboard() {
        DriverUtil.waitVisibilityOfElementLocated(btnAccount, normalTime);
        DriverUtil.click(btnAccount);
    }

    public void updateProfile(String phoneNumber, String passWord, String country, String date, String address,String name) {
        loginWithPhoneNumberAndPassword(phoneNumber, passWord, country);
        choiceAccountFromDashboard();
        updateYourName(name);
        updateTitle();
        updateEmail();
        updateDateOfBirth(date);
        updateGender();
        updateVisitCountry();
        updateCountry();
        updateRegionAndState();
        updateCity();
        updatePhoneNumber();
        updateWorkPhone();
        updateAddress(address);
        updatePicture();
    }


}
