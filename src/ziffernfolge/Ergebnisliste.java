/****************************************
Projekt: Ziffernreihen Spiel 
File: Ergebnisliste.java
Author: Daniel Klemmer
Last changed: 02.08.2022
****************************************/

package ziffernfolge;

// Testimplementierung von Ergebnisliste

public class Ergebnisliste {
	
	/**
	 * Konstruktor
	 */
	
	int i = 0;
	
	// public Ergebnisliste() {}

	/**
	 * Speichert ein ergbenis in die verkettete Liste.
	 * @param ergebnis
	 */
	public void speichere(Ergebnis ergebnis) {
		System.out.println("Ergebnis gespeichert");
	}
	
	/**
	 * Setzt die Liste an den Anfang.
	 */
	public void start() {
		i = 0;
	}
	
	/**
	 * Setzt das n�chste Ergebnis als aktuelles Element. 
	 */
	public void weiter() {
		i++;
	}
	
	/**
	 * Pr�ft ob die Liste am letzten Ergebnis angekommen ist. 
	 * @return true = Liste am Ende, false = Liste nicht am Ende
	 */
	public boolean ende() {
		if(i == 10) {
			return true;
		}
		else {
			return false;
		}		
	}
	
	/**
	 * Gibt das aktuelle Ergebnis zur�ck.
	 * @return Ergebnis
	 */
	public Ergebnis aktuelles_Element() {
		Ergebnis erg;
		switch (i) {
		case 1: {
			erg = new Ergebnis("Alex", 123324, 11232);
			break; 
		}
		case 2: {
			erg = new Ergebnis("Daniel", 13333338, 13333338);
			break; 
		}
		case 3: {
			erg = new Ergebnis("Lukas", 1, 1);
			break; 
		}
		default:
			erg = new Ergebnis("Hanspeter", 213, 212); 
		}
		return erg;
	}
	
}
