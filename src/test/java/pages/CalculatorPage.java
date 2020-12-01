package pages;

import core.Calculator;
import core.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage extends BasePage {
    By btnFirst = By.xpath("//input[@ng-model='first']");
    By btnOperator = By.xpath("//select[@ng-model='operator']");
    By btnSecond = By.xpath("//input[@ng-model='second']");
    By btnGo = By.id("gobutton");
    By expression = By.xpath("//tr[1]/td[2]");
    By result = By.xpath("//tr[1]/td[last()]");


    public void calculator(int first, String type, int second) {
        DriverUtil.waitVisibilityOfElementLocated(btnFirst, normalTime);
        DriverUtil.sendKey(btnFirst, first);
        DriverUtil.selectByVisibleText(btnOperator,type);
        DriverUtil.sendKey(btnSecond, second);
        DriverUtil.click(btnGo);
    }

    public String result() {
       return DriverUtil.getText(result).trim();
}

    public String getExpression() {
        DriverUtil.waitVisibilityOfElementLocated(expression, normalTime);
        return DriverUtil.getText(expression);
    }

    public double checkResult(double number1, double number2, String type) {
        double kq = 0;
        switch (type) {
            case "+":
                kq = number1 + number2;
                break;
            case "-":
                kq = number1 - number2;
                break;
            case "*":
                kq = number1 * number2;
                break;
            case "/":
                kq = number1 / number2;
                break;
            case "%":
                kq = number1 % number2;
                break;
            default:
        }
        return kq;
    }


    String calculation = "";

    public String calculatorType(String type) {

        switch (type) {
            case "+":
                calculation = "ADDITION";
                break;
            case "%":
                calculation = "MODULO";
                break;
            case "/":
                calculation = "DIVISION";
                break;
            case "-":
                calculation = "SUBTRACTION";
                break;
            case "*":
                calculation = "MULTIPLICATION";
                break;
            default:

        }
        return calculation;
    }

}

