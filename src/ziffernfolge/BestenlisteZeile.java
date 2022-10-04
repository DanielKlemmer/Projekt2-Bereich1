/****************************************
Projekt: Ziffernreihen Spiel 
File: BestenlisteZeile.java
Author: Daniel Klemmer
Last changed: 02.08.2022
****************************************/

package ziffernfolge;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class BestenlisteZeile extends JPanel{
	
	//JPanel zeile = new JPanel();
	JLabel nameLabel = new JLabel("");
	JLabel zeitLabel = new JLabel("");
	JLabel zahlenLabel = new JLabel("");
	
	public BestenlisteZeile(int x, int y, int b, int l) {
		this.setLayout(null);
		this.setVisible(false);
		this.setBounds(x, y, b, l);
		this.setLayout(new GridLayout(1, 3, 0, 0));		
		this.add(nameLabel);
		this.add(zeitLabel);
		this.add(zahlenLabel);
	}

	/**
	 * Zeigt ein Ergebnis der Bestenliste an. 
	 * @param ergebnis
	 */
	public void zeige_an(Ergebnis ergebnis) {
		nameLabel.setText(ergebnis.name);
		zeitLabel.setText(Integer.toString(ergebnis.zeit));
		zahlenLabel.setText(Integer.toString(ergebnis.ziffernanzahl));
		this.setVisible(true);
	}
}
