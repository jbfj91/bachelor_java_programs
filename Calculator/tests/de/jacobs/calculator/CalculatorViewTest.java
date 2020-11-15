package de.jacobs.calculator;

import org.junit.Test;

import javax.swing.*;

import java.util.List;

import static org.junit.Assert.*;

public class CalculatorViewTest {

    @Test
    public void getButtons() throws Exception {
        CalculatorView testView = new CalculatorView();

        List<JButton> buttons = testView.getButtons();

        assertEquals(16,buttons.size());
        assertEquals( "0",buttons.get(1).getText());
    }

    @Test
    public void update() {
    }
}