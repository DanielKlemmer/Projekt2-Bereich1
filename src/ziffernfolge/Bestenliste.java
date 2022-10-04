/****************************************
Projekt: Ziffernreihen Spiel 
File: Bestenliste.java
Author: Daniel Klemmer
Last changed: 02.08.2022
****************************************/

package ziffernfolge;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class Bestenliste extends JPanel{
	
	private JPanel liste = new JPanel();
	private JPanel namenseingabe = new JPanel();
	private JPanel listeHeader = new JPanel();
	private Ergebnis ergebnis;
	private JTextField nameTextfeld = new JTextField();
	
	private Steuerung steuerung; 
	private Ergebnisliste ergebnisliste = new Ergebnisliste();
	private BestenlisteZeile[] zeilen = new BestenlisteZeile[10];
	
	public Bestenliste(Steuerung s) {	
		this.setSize(300, 300);
		this.add(namenseingabe);
		this.setLayout(null);
		namenseingabe.setBounds(0, 100, 270, 33);
		
		JLabel nameLabel = new JLabel("Name:");
		namenseingabe.add(nameLabel);
		
		namenseingabe.add(nameTextfeld);
		nameTextfeld.setColumns(10);
		
		JButton eingabeButton = new JButton("Eingabe");
		eingabeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nameTextfeld.getText().length() > 0) {
					name_eingegeben(e);
				}
			}
		});
		namenseingabe.add(eingabeButton);
		namenseingabe.setVisible(false);
		
		// Header 
		listeHeader.setBounds(0, 0, 200, 20);
		listeHeader.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel nameHeader = new JLabel("Name");
		listeHeader.add(nameHeader);
		
		JLabel zeitHeader = new JLabel("Dauer");
		listeHeader.add(zeitHeader);
		
		JLabel punkteHeader = new JLabel("Punkte");
		listeHeader.add(punkteHeader);
		
		liste.add(listeHeader);
		listeHeader.setVisible(false);
		
		steuerung = s;
		this.setVisible(false);
	}

	/**
	 * Namenseingabe bestätigt in der GUI. Ergebnis erstellen und der Ergebnisliste hinzufügen.
	 * @param Event
	 */
	public void name_eingegeben(MouseEvent Event) {
		namenseingabe.setVisible(false);
		ergebnis.name = nameTextfeld.getText();
		ergebnisliste.speichere(ergebnis);
		steuerung.name_eingegeben();
	}
	
	/**
	 * Klicken auf einen Button startet das neue Spiel. 
	 * @param Event
	 */
	public void neues_Spiel(MouseEvent Event) {
		liste.setVisible(false);
		this.remove(liste);
		steuerung.neues_Spiel();
	}
	
	/**
	 * Erzeugt ein neues Ergebnis für die Ergebnisliste.
	 * @param folgenlaenge
	 * @param spielzeit
	 */
	public void neues_Ergebnis(int folgenlaenge, int spielzeit) {
		ergebnis = new Ergebnis(" ", spielzeit, folgenlaenge);
	}
	
	/**
	 * Lässt den Spieler seinen Namen eingeben (Textbox und Bestätigungsbutton).
	 */
	public void aktiviere_Namenseingabe() {
		// initialisieren des Textfeldes
		nameTextfeld.setText("");
		namenseingabe.setVisible(true);
	}
	
	/**
	 * Anzeige der Bestenliste mit den 10 besten Spielern. 
	 */
	public void zeige_Liste_an() {
		this.setLayout(null);
		liste.setLayout(null);
		
		ergebnisliste.start();
		int i = 0;
		while(!ergebnisliste.ende() && i < 10) {
			zeilen[i] = new BestenlisteZeile(0, ((i+1)*20), 200, 20);
			zeilen[i].zeige_an(ergebnisliste.aktuelles_Element());
			liste.add(zeilen[i]);
			ergebnisliste.weiter();
			i++;
		}

		JButton neuesSpiel = new JButton("neues Spiel");
		neuesSpiel.setBounds(50, ((i+1)*20), 100, 20);
		neuesSpiel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				liste.remove(neuesSpiel);
				neues_Spiel(e);
			}
		});
		liste.add(neuesSpiel);
		this.add(liste);
	
		liste.setBounds(10, 10, 300, ((i+2)*20));
		listeHeader.setVisible(true);
		liste.setVisible(true);
	}
	
	/**
	 * Legt fest ob das Fenster sichtbar ist oder nicht. 
	 * true: Fenster ist sichtbar. 
	 * false: Fenster ist nicht sichtbar. 
	 * @param wert
	 */
	public void sichtbar(boolean wert) {
		this.setVisible(wert);
	}
}
