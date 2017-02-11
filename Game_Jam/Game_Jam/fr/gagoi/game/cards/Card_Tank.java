package fr.gagoi.game.cards;

import java.awt.Graphics;
import java.awt.Image;

import fr.fixyneko.game.world.Unit;

public class Card_Tank implements Card {

	public Card_Tank() {
	}
	
	@Override
	public void draw(Graphics g) {
		
	}

	@Override
	public String getImage() {
	 return "/cartes/unites/tank.jpg";
	}

	@Override
	public void onUse() {
		new Unit(5, 4, 5, 5, 2);
	}

}
