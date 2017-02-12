package fr.gagoi.launcher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import fr.gagoi.game.cards.Card;
import fr.gagoi.game.cards.Card_Boucherie;
import fr.gagoi.game.cards.Card_Declaration;
import fr.gagoi.game.cards.Card_Deforestation;
import fr.gagoi.game.cards.Card_Dictature;
import fr.gagoi.game.cards.Card_Manifestation;
import fr.gagoi.game.cards.Card_PartiUnique;
import fr.gagoi.game.cards.Card_Paysan;
import fr.gagoi.game.cards.Card_PlusProfond;
import fr.gagoi.game.cards.Card_ReussiteEco;
import fr.gagoi.game.cards.Card_Soldat;
import fr.gagoi.game.cards.Card_Tank;
import fr.gagoi.game.cards.Card_Vacances;

public class Launcher extends JFrame {
	private static final Card[] CARDS = { new Card_Boucherie(), new Card_Declaration(), new Card_Deforestation(),
			new Card_Dictature(), new Card_Manifestation(), new Card_PartiUnique(), new Card_Paysan(),
			new Card_PlusProfond(), new Card_ReussiteEco(), new Card_Soldat(), new Card_Tank(), new Card_Vacances() };


	public JButton but_play, but_quit;
	
	public Launcher LAUNCHER;

	public Launcher() {
		setTitle("Game Laucher");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null);
		but_play = new JButton("Play");
		but_quit = new JButton("Quit");

		but_play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		but_quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		but_play.setBounds(100, 50, 300, 50);
		but_quit.setBounds(100, 400, 300, 50);

		getContentPane().add(but_play);
		getContentPane().add(but_quit);
		
		
		setVisible(true);
		LAUNCHER = this;
	}

	public static void main(String args[]) {
		new Launcher();
	}
}
