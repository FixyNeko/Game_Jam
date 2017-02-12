package fr.gagoi.game.cards;

import java.awt.Graphics;
import java.awt.Image;

import fr.gagoi.game.core.Game;

public class Card_Dictature extends Card {

	public Card_Dictature() {
	}
	
	@Override
	public void draw(Graphics g) {
		
	}

	@Override
	public String getImage() {
		return "/cartes/lois/dictature.jpg";
	}

	@Override
	public void onUse() {
		//PLUS DE PERTE DE POPULARITE PENDANT 10 TOURS.
	}

}
