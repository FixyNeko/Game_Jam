package fr.gagoi.game.cards;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;

import fr.fixyneko.game.world.Unit;

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
		new Unit(1, 1, 5, 5, 0);
	}

}
