package fr.gagoi.game.cards;

import java.awt.Graphics;
import java.awt.Image;

import fr.gagoi.game.core.Game;

public class Card_Vacances implements Card {

	public Card_Vacances() {
	}
	
	@Override
	public void draw(Graphics g) {
		
	}

	@Override
	public String getImage() {
		return "/cartes/lois/vacances.jpg";
	}

	@Override
	public void onUse() {
		Game.GAME.getPlayer(Game.GAME.getPlayersTurn()).getResourceList().multiplyResource(4,(1.2f));
		Game.GAME.getPlayer(Game.GAME.getPlayersTurn()).getResourceList().multiplyResource(3,(0.8f));
	}

}
