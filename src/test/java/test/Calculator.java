package test;

import core.DriverUtil;
import core.ahihi;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CalculatorPage;

import java.text.DecimalFormat;

public class Calculator {
    CalculatorPage calculatorPage = new CalculatorPage();

    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    @BeforeMethod
    public void setBaseUrl() {
        DriverUtil.initDriver(ahihi.CHROME);
        DriverUtil.maximizeWindow();
        DriverUtil.navigateTo("http://www.way2automation.com/angularjs-protractor/calc/");
    }

    @DataProvider(name = "data")
    public static Object[][] dataProfile() {
        return new Object[][]{
                { random(1,100), "-", random(1,100)},
                {random(1,100), "+", random(1,100)},
                {random(1,100), "*", random(1,100)},
                {random(1,100), "/", random(1,100)}
        };
    }

    @Test(dataProvider = "data")
    public void calculator(int firstNumber, String type, int secondNumber) {

        DecimalFormat format = new DecimalFormat();
        format.setMinimumFractionDigits(0);
        format.setMaximumFractionDigits(15);
        format.setGroupingUsed(false);


        calculatorPage.calculator(firstNumber, type, secondNumber);

        String expected = String.format("%d %s %d", firstNumber, type, secondNumber);
        System.out.println("aaaa: " + expected);
        Assert.assertEquals(calculatorPage.getExpression(), expected);
        double result = calculatorPage.checkResult(firstNumber, secondNumber, type);

        Assert.assertEquals(calculatorPage.result(), format.format(result));

    }

    @AfterMethod
    public void endPage() {

        DriverUtil.quit();

    }

}
