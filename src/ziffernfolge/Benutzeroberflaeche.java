/****************************************
Projekt: Ziffernreihen Spiel 
File: Benutzeroberflaeche.java
Author: Daniel Klemmer
Last changed: 02.08.2022
****************************************/

package ziffernfolge;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Benutzeroberflaeche extends JFrame {
	private static final int abstand = 10;
	private JPanel contentPane;
	private Spielkonsole spielkonsole = new Spielkonsole();
	private Steuerung steuerung = new Steuerung(spielkonsole);
	private Bestenliste bestenliste = new Bestenliste(steuerung);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Benutzeroberflaeche frame = new Benutzeroberflaeche();
					frame.setVisible(true);
					frame.steuerung.spiel_gestartet();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Benutzeroberflaeche() {
		setTitle("Ziffernfolge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		spielkonsole.melde_an(steuerung);
		steuerung.melde_an(bestenliste);
		spielkonsole.setLocation(abstand, abstand);
		contentPane.add(spielkonsole);
		bestenliste.setLocation(abstand, abstand);
		contentPane.add(bestenliste);
	}
}
