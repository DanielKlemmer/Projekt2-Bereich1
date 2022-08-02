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
	 * Setzt das nächste Ergebnis als aktuelles Element. 
	 */
	public void weiter() {
		i++;
	}
	
	/**
	 * Prüft ob die Liste am letzten Ergebnis angekommen ist. 
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
	 * Gibt das aktuelle Ergebnis zurück.
	 * @return Ergebnis
	 */
	public Ergebnis aktuelles_Element() {
		Ergebnis erg = new Ergebnis("Daniel", 13333338, 13333338);
		return erg;
	}
	
}
