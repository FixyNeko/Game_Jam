package fr.gagoi.game.cards;

import java.awt.Graphics;

import fr.fixyneko.game.world.Unit;
import fr.gagoi.game.core.Game;

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
		Game.GAME.getWorld().addUnit(new Unit(1, 1, 5, 5, 0, Game.GAME.getPlayer(Game.GAME.getPlayersTurn())));
	}

}
