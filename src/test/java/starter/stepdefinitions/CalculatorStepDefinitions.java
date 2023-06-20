package starter.stepdefinitions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.calculator.actions.CalculatorActions;
import starter.calculator.actions.NavigateActions;
import starter.calculator.domain.MathsOperation;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorStepDefinitions {

    @Steps

    NavigateActions navigate;

    @Given("Matt a maths student has opened the calculator")
    public void matt_a_maths_student_has_opened_the_calculator(){
        navigate.toTheCalculatorApplication();
    }
    @DataTableType
    public MathsOperation convert(Map<String,String> tableRow){
       return new MathsOperation(
               tableRow.get("Left Operand"),
               tableRow.get("Operator"),
               tableRow.get("Right Operand")
       );
    }

    @Steps
    CalculatorActions calculator;

    @When("^Matt (?:performs|has performed) the following calculations?:$")
    public void mattPerformsTheFollowingCalculation(List<MathsOperation> operations) {
        operations.forEach(
                operation -> calculator.calculate(operation)
        );
    }

    @Then("he should see a result of {string}")
    public void heShouldSeeAResultOf(String expectedResult) {
        assertThat(calculator.result()).isEqualTo(expectedResult);
    }
}
