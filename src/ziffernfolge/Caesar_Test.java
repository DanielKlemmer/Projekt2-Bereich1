/****************************************
Projekt: Ziffernreihen Spiel 
File: Caesar_Test.java
Author: Daniel Klemmer
Last changed: 02.08.2022
****************************************/

package ziffernfolge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Caesar_Test {

	@Test
	void test() {
		Caesar krypto = new Caesar();
		
		// Komprimierter Text mit Sonderzeichen 
		String schluessel = "A";
		StringBuffer text = new StringBuffer();
		
		text.insert(0, "H#4#a#7#l#2#o#4#:#1#3#1#4#4#3#4#\n#1# ");
		String orgText = text.toString();
		assertEquals(orgText, text.toString());
		
		krypto.Schluessel(schluessel);
		krypto.verschluesseln(text);
		assertEquals("Ia5aba8ama3apa5a\na2a4a2a5a5a4a5a#a2aA", text.toString(), "Verschlüsselung fehlgeschlagen");
		
		krypto.entschluesseln(text);
		assertEquals("H#4#a#7#l#2#o#4#:#1#3#1#4#4#3#4#\n#1# ", text.toString(), "Entschlüsselung fehlgeschlagen");
		
		

	}

}
