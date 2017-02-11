package fr.gagoi.game.cards;

import java.awt.Graphics;
import java.awt.Image;

import com.sun.glass.ui.GestureSupport;

import fr.gagoi.game.core.Game;

public class Card_Declaration implements Card {

	public Card_Declaration() {
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
		Game.GAME.getPlayer(Game.GAME.getPlayersTurn()).getResourceList().multiplyResource(0,(0.9f));
		//SUPPRIME TOUTES LES UNITES DE LA MAP.
	}

}
