package de.jacobs;

/**
 * Hält und bestimmt über die für den Taschenrechner relevanten Daten.
 * @author jacob
 * (code aus unit 7 skript) 
 * @version 1.0
 */
public class TRModel {

	/**
	 * Datenfeld der Klasse de.jacobs.TRModel
	 */
	private String result;
	private String operator;
	private String operand;
	private String error;
	
	
	
	
	/**
	 * Fuehrt Berechnungen (Addition, Subtraktion, Division, Multiplikation) 
	 * mit eingegebenen operatoren und results durch.
	 * Faengt Leereingaben und durch null teilen ab.
	 * Am Schluss werden alle Datenfelder zurückgesetzt 
	 */
	public void berechne() {
		try {
			// Resultat, Operator oder Operand liegen nicht vor => tue nichts
			if (this.result.equals("") || this.operator.equals("") || this.operand.equals(""))
				return;

			// Ab hier normale Verarbeitung
			float a = Float.valueOf(this.result);
			float b = Float.valueOf(this.operand);

			if (this.operator.equals("+"))
				this.result = String.valueOf(a + b);
			if (this.operator.equals("-"))
				this.result = String.valueOf(a - b);
			if (this.operator.equals("/")) {
				// Nicht durch Null teilen
				if (b == 0.0)
					throw new Exception("Division by Zero");
				this.result = String.valueOf(a / b);
			}
			if (this.operator.equals("*"))
				this.result = String.valueOf(a * b);

			this.operator = "";
			this.operand = "";
			this.error = "";
		} catch (Exception ex) {
			this.clear();
			this.error = ex.getMessage();
		}
	}
	
	
	/**
	 * Liefert den Operanden des Taschenrechners
	 * @return Stringrepräsentation des Operandenwertes
	 */
	public String getOperand() {
		return this.operand;
	}
	
	/**
	 * Setzt den Operanden des Taschenrechners auf einen neuen Wert
	 * @param val Neueroperandenwert als Zeichenkette
	 */
	public void setOperand(String val) {
		this.operand = val;
		this.error = "";
	}

	/**
	 * Liefert den aktuell gesetzten Operator zurueck
	 * @return alktueller Operator
	 */
	public String getOperator() {
		return this.operator;
	}
	
	/**
	 * Prüft die aktuellen Inhalte von:
	 * result, operator, operand und getError,
	 * und setzt den aktuellen Operator. 
	 * @param op eingehender Operator
	 */
	public void setOperator(String op) {
		// Resultat, Operator und Operand existieren aus vorherigen Eingaben => erstmal 
		// rechnen
		if (!(this.result.equals("") && this.operator.equals("") && 
				this.operand.equals(""))) 
		{
			this.berechne();
		if (!this.getError().equals("")) return;
		// Wenn Fehler aufgetreten, Methode verlassen
		}
		// Es wurde bereits ein Operand eingegeben => diesen zum Resultat machen
		if (!this.operand.equals("")) { this.result = this.operand; this.operand = "";
		}
		// Es liegt kein Resultat vor => Resultat auf Null setzen
		if (this.result.equals("")) this.result = "0";
		this.operator = op;
		this.error = ""; 
		}
	
	
	/**
	 * Liefert den letzten Error Code
	 * Der Error Code ist die leere Zeichenkette, wenn kein
	 * Error vorliegt.
	 * @return Errorcode als Zeichenkette
	 */
	public String getError() {
		return this.error;
	}
	
	
	/**
	 * Setzt den internen Zustand eines Taschenrechners zurueck
	 * result = ""
	 * operand = ""
	 * operator = ""
	 * error = ""
	 */
	public void clear() {
		this.result = "";
		this.operand = "";
		this.operator = "";
		this.error = "";
	}
	
	/**
	 * Liefert den result Eintrag des Taschenrechners
	 * @return Resultwert als Zeichenkette
	 */
	public String getResult() {
		return this.result;
	}
}
