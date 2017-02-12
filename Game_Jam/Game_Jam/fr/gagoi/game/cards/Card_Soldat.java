package fr.gagoi.game.cards;

import fr.fixyneko.game.world.Unit;
import fr.gagoi.game.core.Game;

public class Card_Soldat extends Card {

	public Card_Soldat() {
	}

	@Override
	public String getImage() {
		return "/cartes/unites/soldat.jpg";
	}

	@Override
	public void onUse() {
		Game.GAME.getWorld().addUnit(new Unit(2, 2, Game.GAME.getWorld().pointerX, Game.GAME.getWorld().pointerY, 1, 1, Game.GAME.getPlayer(Game.GAME.getPlayersTurn())));
		Game.GAME.getPlayer(0).getResourceList().removeResource(1, 100);
		Game.GAME.getPlayer(0).getResourceList().removeResource(2, 50);
	}

}