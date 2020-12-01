package core;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class DriverUtil {
    public static WebDriver webDriver;

    public static Actions getActions() {
        return new Actions(getWebDriver());
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        DriverUtil.webDriver = webDriver;
    }

    public static WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public static void setWebDriverWait(WebDriverWait webDriverWait) {
        DriverUtil.webDriverWait = webDriverWait;
    }

    public static WebDriverWait webDriverWait;

    public static void initDriver(ahihi driverType) {

        switch (driverType) {
            case IE:
                System.setProperty("webdriver.ie.driver",
                        "src/main/resources/IEDriverServer.exe");
                webDriver = new InternetExplorerDriver();

                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver",
                        "src/main/resources/chromedriver.exe");
                webDriver = new ChromeDriver();

                break;
            case FIRE_FOX:
                System.setProperty("webdriver.gecko.driver",
                        "src/main/resources/geckodriver.exe");
                webDriver = new FirefoxDriver();
                break;
            default:

        }

    }

    public static void maximizeWindow() {
        webDriver.manage().window().maximize();
    }

    public static void navigateTo(String link) {
        webDriver.navigate().to(link);
    }

    public static WebElement findElement(By by) {
        return webDriver.findElement(by);
    }

    public static List<WebElement> findElements(By by) {
        return webDriver.findElements(by);
    }

    public static void close() {
        webDriver.close();
    }

    public static void quit() {
        webDriver.quit();
    }

    public static void sendKey(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public static void sendKey(By by, int number) {
        String aa = String.valueOf(number);
        findElement(by).sendKeys(aa);
    }

    public static void click(By by) {
        findElement(by).click();

    }

    public static void clickRadio(By by, String attribute, String value) {
        for (int i = 0; i < findElements(by).size(); i++) {
            if (findElements(by).get(i).getAttribute(attribute).equalsIgnoreCase(value)) {
                findElements(by).get(i).click();
            }
        }

    }

    public static void clickRadio(By by, String value) {
        clickRadio(by, "value", value);
    }

    public static void waitForAlert(int waitConditionLocator) {
        webDriverWait = new WebDriverWait(webDriver, waitConditionLocator);
        webDriverWait.until(ExpectedConditions.alertIsPresent());
    }

    public static void waitVisibilityOfElementLocated(By by, int waitConditionLocator) {
        webDriverWait = new WebDriverWait(webDriver, waitConditionLocator);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void visibilityOf(WebElement element, int waitConditionLocator) {
        webDriverWait = new WebDriverWait(webDriver, waitConditionLocator);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementNotChange(By by, int waitConditionLocator) {
        webDriverWait = new WebDriverWait(webDriver, waitConditionLocator);
        webDriverWait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                WebElement e = webDriver.findElement(by);
                Point oldP = e.getLocation();
                waitingMiliSeconds(200);
                Point newP = e.getLocation();
                return oldP.equals(newP);
            }
        });
    }

    public static void iii() {

    }

    public static void w(By by, int waitConditionLocator) {
        webDriverWait = new WebDriverWait(webDriver, waitConditionLocator);

    }

    public static void getSize(By by) {
        findElement(by).getSize();
    }

    public static boolean isSelected(By by) {
        return findElement(by).isSelected();
    }

    public static boolean isDisplayed(By by) {
        return findElement(by).isDisplayed();
    }

    public static String getText(By by) {
        return findElement(by).getText();
    }


    public static void getAttribute(By by, String s) {
        findElement(by).getAttribute(s);
    }

    public static void clear(By by) {
        findElement(by).clear();
    }

    public static String getCssValue(By by, String s) {
        return findElement(by).getCssValue(s);
    }

    public static String alert() {
        return webDriver.switchTo().alert().getText();
    }

    public static void waitingTime(int time) {
        waitingMiliSeconds(time * 1000);
    }

    public static void waitingMiliSeconds(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void selectByVisibleText(By by, String text) {
        Select cbCalculator = new Select(findElement(by));
        cbCalculator.selectByVisibleText(text);
    }

    public static void check(By by) {
        List<WebElement> list = DriverUtil.findElements(by);
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).isSelected()) {
                list.get(i).click();
            }
        }

    }

    public static void uncheck(By by) {
        List<WebElement> list = DriverUtil.findElements(by);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected()) {
                list.get(i).click();
            }
        }
    }

    public static void swichToIframe(By by) {
        webDriver.switchTo().frame(findElement(by));
    }

    public static void swichToDefaut() {
        webDriver.switchTo().defaultContent();
    }

    public static String randomValue(List<WebElement> listValue) {
        ArrayList<String> arrayValue = new ArrayList<>();
        Random random = new Random();
        for (WebElement selectValue : listValue) {
            arrayValue.add(selectValue.getText());
        }
        System.out.println("OOOO: " + arrayValue.get(random.nextInt(arrayValue.size())));
        return arrayValue.get(random.nextInt(arrayValue.size()));
    }


    public static String randomString(int len) {
        String AB = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    public static String randomNumber(int len) {
        String number = "0123456789";
        Random rnd = new Random();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            res.append(number.charAt(rnd.nextInt(number.length())));
        }
        String telephoneNumber = "84" + res;
        System.out.println("KKKK: " + telephoneNumber);
        return telephoneNumber;

    }


}
