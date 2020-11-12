package de.jacobs;

import java.awt.*;
import javax.swing.*;
import java.util.Vector;


/**
 * Stellt die Oberfläche eines Taschenrechners mit Eingabe- und Darstellungsmöglichkeiten.
 * @author jacob
 * (code aus unit 7 skript)
 *	@version 1.0
 */
public class TRView extends JFrame {

	/**
	 * Datenfeld des Taschenrechner Klasse de.jacobs.TRView
	 * Erstellung eines Displays
	 */
	private JTextField display = new JTextField();
	{
		this.display.setEditable(false);
		this.display.setSize(200, 60);
	}

	/*
	 * Datenfeld in Form einer Liste in dem alle Tasten des Taschenrechners
	 * abgelegt werden Die Tasten werden in diesem Programm ueber den
	 * entsprechenden Index angesprochen.
	 */
	public Vector<JButton> buttons = new Vector<>();
	{
		buttons.add(new JButton ("0")); // Index 0
		buttons.add(new JButton ("1")); // Index 1
		buttons.add(new JButton ("2")); // Index 2
		buttons.add(new JButton ("3")); // Index 3
		buttons.add(new JButton ("4")); // Index 4
		buttons.add(new JButton ("5")); // Index 5
		buttons.add(new JButton ("6")); // Index 6
		buttons.add(new JButton ("7")); // Index 7
		buttons.add(new JButton ("8")); // Index 8
		buttons.add(new JButton ("9")); // Index 9
		buttons.add(new JButton ("+")); // Index 10
		buttons.add(new JButton ("-")); // Index 11
		buttons.add(new JButton ("*")); // Index 12
		buttons.add(new JButton ("/")); // Index 13
		buttons.add(new JButton ("=")); // Index 14
		buttons.add(new JButton ("C")); // Index 15
	}

	/*
	 * Datenfelder des Views die auf das Modelobjekt und Controllerobjekt des TR
	 * verweisen
	 */
	protected TRModel model = new TRModel();
	protected TRControl controller = new TRControl(this, model);

	
	
	/**
	 * Konstruktor zum Anlegen eines Viewobjekts eines Taschenrechners. Der
	 * Konstruktor platziert alle Bedienelemente und "verlinkt" diese mit einem
	 * Controller
	 **/
	public TRView() {
		super("Taschenrechner");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		Panel tastenpanel = new Panel();
		GridLayout gbLayout = new GridLayout(4, 4);
		gbLayout.setHgap(5);
		gbLayout.setVgap(5);
		tastenpanel.setLayout(gbLayout);

		// Zeile 1 des Bedienpanels des TR wird angelegt
		tastenpanel.add(this.buttons.get(1));
		tastenpanel.add(this.buttons.get(2));
		tastenpanel.add(this.buttons.get(3));
		tastenpanel.add(this.buttons.get(10));

		// Zeile 2 des Bedienpanels des TR wird angelegt
		tastenpanel.add(this.buttons.get(4));
		tastenpanel.add(this.buttons.get(5));
		tastenpanel.add(this.buttons.get(6));
		tastenpanel.add(this.buttons.get(11)); // Minus

		// Zeile 3 des Bedienpanels des TR wird angelegt
		tastenpanel.add(this.buttons.get(7));
		tastenpanel.add(this.buttons.get(8));
		tastenpanel.add(this.buttons.get(9));
		tastenpanel.add(this.buttons.get(12)); // Mal

		// Zeile 4 des Bedienpanels des TR wird angelegt
		tastenpanel.add(this.buttons.get(15));
		tastenpanel.add(this.buttons.get(0));
		tastenpanel.add(this.buttons.get(14));
		tastenpanel.add(this.buttons.get(13));

		// Display des TR in die erste Zeile setzen. Das Bedienpanel direkt
		// darunter
		this.add(display, BorderLayout.NORTH);
		this.add(tastenpanel, BorderLayout.CENTER);

		// Alle Tasten des Rechners mit dem Controllerobjekt verknuepfen
		for (JButton b : buttons) b.addActionListener(controller);
	}

	/**
	 * Diese Methode wird vom Controller aufgerufen, wenn der View aufdatiert
	 * werden soll.
	 */
	 public void update() { 
	 String result = model.getResult(); 
	 String operator = model.getOperator();
	 String operand = model.getOperand(); 
	 String error = (model.getError().equals("") ? "" : (model.getError() + "!!!"));
	 display.setText(result + operator + operand + error); 
	 }
}
