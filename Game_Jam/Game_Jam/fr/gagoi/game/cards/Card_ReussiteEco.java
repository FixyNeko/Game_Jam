package fr.gagoi.game.cards;

import java.awt.Graphics;
import java.awt.Image;

import fr.gagoi.game.core.Game;

public class Card_ReussiteEco implements Card {

	public Card_ReussiteEco() {
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
		Game.GAME.getPlayer(Game.GAME.getPlayersTurn()).getResourceList().addResource(3, 200);
	}

}
