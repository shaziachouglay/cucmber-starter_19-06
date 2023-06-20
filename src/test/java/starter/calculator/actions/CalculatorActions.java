package starter.calculator.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import starter.calculator.domain.MathsOperation;

import static starter.calculator.actions.CalculatorForm.*;

public class CalculatorActions extends UIInteractionSteps {

    @Step("Enters {0} and clicks Go")
    public void calculate(MathsOperation operation) {
        $(LEFT_OPERAND).sendKeys(operation.getLeftOperand());
        $(OPERATOR).selectByVisibleText(operation.getOperator());
        $(RIGHT_OPERAND).sendKeys(operation.getRightOperand());
        $(GO_BUTTON).click();
        waitForAngularRequestsToFinish();
    }

    public String result() {
        return $(RESULT).getText();
    }
}
