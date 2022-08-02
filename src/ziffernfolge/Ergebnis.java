/****************************************
Projekt: Ziffernreihen Spiel 
File: Ergebnis.java
Author: Daniel Klemmer
Last changed: 02.08.2022
****************************************/

package ziffernfolge;

// Testimplementierung von Ergebnis

public class Ergebnis {

	public String name = "";
	public int zeit = 0;
	public int ziffernanzahl = 0; 
	
	/**
	 * Konstruktor
	 * @param name:         Spielername
	 * @param zeit:         Spielzeit in Sekunden
	 * @param ziffernanzahl: Laenge der Zahlenfolge
	 */
	public Ergebnis(String name, int zeit, int ziffernanzahl) {
		this.name = name; 
		this.zeit = zeit;
		this.ziffernanzahl = ziffernanzahl;
	}
	
	/**
	 * Vergleicht ziffernanzahl zwischen zwei Ergebnissen. 
	 * @return Wenn <0 ist das Objekt kleiner, bei >0 ist es größer bei =0 sind beide gleich. 
	 */
	public int CompareTo(Object object) {
		return 0;
	}

}
