/****************************************
Projekt: Ziffernreihen Spiel 
File: Caesar.java
Author: Daniel Klemmer
Last changed: 02.08.2022
****************************************/

package ziffernfolge;

public class Caesar implements Kryptomethode{
	
	private int shift = 0;
	private char lookup[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', 
							 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
							 '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', '\n', '#'};
	
	@Override
	public void Schluessel(String wert) {
		shift = (Character.toLowerCase(wert.charAt(0)) - 'a') + 1;		
	}

	@Override
	public void verschluesseln(StringBuffer text) {
		int cpos = 0;
		// Suche des Chars in der lookup um die Position herauszufinden 
		for(int i = 0; i < text.length(); i++) {
			boolean posFound = false;
			for(int p = 0; p < lookup.length; p++) {
				if(lookup[p] == text.charAt(i)) {
					cpos = p; 
					posFound = true; 
					break;
				}
			}
			// Wenn kein Character passt wird es zu einem Leerzeichen
			if(posFound == false) {
				cpos = 26; 
			}
			
			// berechnen der neuen Position
			cpos = (cpos + shift) % lookup.length;
			text.setCharAt(i, lookup[cpos]);
		}
	}

	@Override
	public void entschluesseln(StringBuffer text) {
		int cpos = 0;
		for(int i = 0; i < text.length(); i++) {
			boolean posFound = false;
			// Suche des Chars in der lookup um die Position herauszufinden 
			for(int p = 0; p < lookup.length; p++) {
				if(lookup[p] == text.charAt(i)) {
					cpos = p; 
					posFound = true; 
					break;
				}
			}
			// Wenn kein Character passt wird es zu einem Leerzeichen
			if(posFound == false) {
				cpos = 26; 
			}
			
			// berechnen alten Position
			if(cpos - shift < 0) {
				cpos = ((cpos - shift) % lookup.length) + lookup.length;
			}
			else {
				cpos = Math.abs((cpos - shift) % lookup.length);
			}
			text.setCharAt(i, lookup[cpos]);
		}
	}

}
