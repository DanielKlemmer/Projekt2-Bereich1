/****************************************
Projekt: Ziffernreihen Spiel 
File: BestenlisteTest.java
Author: Daniel Klemmer
Last changed: 02.08.2022
****************************************/

package ziffernfolge;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class BestenlisteTest extends JFrame {

	private JPanel contentPane;
	private boolean v = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BestenlisteTest frame = new BestenlisteTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BestenlisteTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Spielkonsole spielkonsole = new Spielkonsole();
		int abstand = 10;
		int x = 2 * abstand + Spielkonsole.breite + 16;
		int y = 2 * abstand + Spielkonsole.hoehe + 36;
		System.out.println(x);
		System.out.println(y);
		
		setBounds(100, 100, 685, 425);
		
		Steuerung steuerung = new Steuerung(spielkonsole);
		Bestenliste bestenliste = new Bestenliste(steuerung);
		bestenliste.setLocation(5, 5);
		steuerung.melde_an(bestenliste);
		
		bestenliste.neues_Ergebnis(10, 20);
		
		contentPane.setLayout(null);
		
		contentPane.add(bestenliste);
		
		JButton visibleBtn = new JButton("Show Window");
		visibleBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (v) {
					v = false;
					bestenliste.sichtbar(v);
				}
				else {
					v = true;
					bestenliste.sichtbar(v);
				}
			}
		});
		visibleBtn.setBounds(491, 53, 116, 23);
		contentPane.add(visibleBtn);
		
		JButton showName = new JButton("Show Name");
		showName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				spielkonsole.sichtbar(false);
				bestenliste.sichtbar(true);
				bestenliste.aktiviere_Namenseingabe();
			}
		});
		showName.setBounds(491, 116, 116, 23);
		contentPane.add(showName);
		
		JButton showListe = new JButton("Show Liste");
		showListe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bestenliste.sichtbar(true);
				bestenliste.zeige_Liste_an();
			}
		});
		showListe.setBounds(491, 174, 116, 23);
		contentPane.add(showListe);
	}
}
