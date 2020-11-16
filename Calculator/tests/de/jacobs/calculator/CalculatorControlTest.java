package de.jacobs.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorControlTest {

    @Test
    public void zahlAnhaengenTest() {
        CalculatorView v = new CalculatorView();
        CalculatorModel m = new CalculatorModel();
        CalculatorControl testController = new CalculatorControl(v,m);
    }
}