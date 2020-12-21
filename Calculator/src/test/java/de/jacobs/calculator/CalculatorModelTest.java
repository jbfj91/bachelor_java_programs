package de.jacobs.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorModelTest {

    @Test
    public void additionTest() {
        CalculatorModel testModel = new CalculatorModel();

        testModel.setOperand("2");
        testModel.setOperator("+");
        testModel.setOperand("2");

        testModel.calculate();
        assertEquals( "4.0", testModel.getResult());
    }

    @Test
    public void subtractionTest() {
        CalculatorModel testModel = new CalculatorModel();

        testModel.setOperand("4");
        testModel.setOperator("-");
        testModel.setOperand("2");

        testModel.calculate();
        assertEquals( "2.0", testModel.getResult());
    }

    @Test
    public void multiplicationTest() {
        CalculatorModel testModel = new CalculatorModel();

        testModel.setOperand("2");
        testModel.setOperator("*");
        testModel.setOperand("2");

        testModel.calculate();
        assertEquals( "4.0", testModel.getResult());
    }

    @Test
    public void divisionTest() {
        CalculatorModel testModel = new CalculatorModel();

        testModel.setOperand("5");
        testModel.setOperator("/");
        testModel.setOperand("2");

        testModel.calculate();
        assertEquals( "2.5", testModel.getResult());
    }

    @Test
    public void divisionByZeroExceptionTest() {
        CalculatorModel testModel = new CalculatorModel();

        testModel.setOperand("5");
        testModel.setOperator("/");
        testModel.setOperand("0");

        testModel.calculate();
        assertEquals( "Division by Zero", testModel.getError());

    }
}