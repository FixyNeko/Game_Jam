package fr.gagoi.game.cards;

import fr.fixyneko.game.world.Unit;
import fr.gagoi.game.core.Game;

public class Card_Paysan extends Card {

	public Card_Paysan() {
	}

	@Override
	public String getImage() {
		return "/cartes/unites/paysan.jpg";
	}

	@Override
	public void onUse() {
		Game.GAME.getWorld().addUnit(new Unit(1, 1, Game.GAME.getWorld().pointerX, Game.GAME.getWorld().pointerY, 0, 1, Game.GAME.getPlayer(Game.GAME.getPlayersTurn())));
		Game.GAME.getPlayer(0).getResourceList().removeResource(1, 50);
	}

}
