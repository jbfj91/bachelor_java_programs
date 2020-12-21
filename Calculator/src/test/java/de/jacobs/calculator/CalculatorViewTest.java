package de.jacobs.calculator;

import org.junit.Test;

import javax.swing.*;

import java.util.List;

import static org.junit.Assert.*;

public class CalculatorViewTest {

    @Test
    public void buttonGenerationTest() {
        CalculatorView testView = new CalculatorView();
        List<JButton> buttons = testView.getButtons();

        assertEquals(16,buttons.size());
        assertEquals("8",buttons.get(8).getText());
    }

}