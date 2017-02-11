package fr.gagoi.game.cards;

import java.awt.Graphics;
import java.awt.Image;

import fr.gagoi.game.core.Game;

public class Card_PlusProfond implements Card {

	public Card_PlusProfond() {
	}
	
	@Override
	public void draw(Graphics g) {
		
	}

	@Override
	public Image getImage() {
		return null;
	}

	@Override
	public void onUse() {
		Game.GAME.getPlayer(Game.GAME.getPlayersTurn()).getResourceList().addResource(2, 250);
	}

}
