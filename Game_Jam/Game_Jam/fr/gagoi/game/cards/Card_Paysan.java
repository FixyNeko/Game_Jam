package fr.gagoi.game.cards;

import java.awt.Graphics;
import java.awt.Image;

public class Card_Paysan implements Card {

	public Card_Paysan() {
	}
	
	@Override
	public void draw(Graphics g) {
		
	}

	@Override
	public String getImage() {
		return "/cartes/unites/paysan.jpg";
	}

	@Override
	public void onUse() {
		//AJOUTE UN PAYSAN SUR LA MAP AVEC 1 D'ATTAQUE ET 1 DE VIE.
	}

}
