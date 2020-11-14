package de.jacobs;

public class CalculatorMain {

    /**
     * Zum Start des Taschenrechner Programms
     * @author jacob
     */
    public static void main(String[] args) {
        TRView tr = new TRView();
        tr.setSize(300, 300);
        tr.setVisible(true);
        tr.setResizable(false);
    }
}
