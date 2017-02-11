package fr.gagoi.game.cards;

import java.awt.Graphics;
import java.awt.Image;

import fr.fixyneko.game.world.Unit;

public class Card_Soldat implements Card {

	public Card_Soldat() {
	}
	
	@Override
	public void draw(Graphics g) {
		
	}

	@Override
	public String getImage() {
		return "/cartes/unites/soldat.jpg";
	}

	@Override
	public void onUse() {
		new Unit(2, 2, 5, 5, 1);
	}

}
