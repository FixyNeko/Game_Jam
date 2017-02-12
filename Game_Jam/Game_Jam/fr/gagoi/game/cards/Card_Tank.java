package fr.gagoi.game.cards;

import fr.fixyneko.game.world.Unit;
import fr.gagoi.game.core.Game;

public class Card_Tank extends Card {

	public Card_Tank() {
	}

	@Override
	public String getImage() {
		return "/cartes/unites/tank.jpg";
	}

	@Override
	public void onUse() {
		Game.GAME.getWorld().addUnit(new Unit(5, 4, Game.GAME.getWorld().pointerX, Game.GAME.getWorld().pointerY, 2, 1, Game.GAME.getPlayer(Game.GAME.getPlayersTurn())));
		Game.GAME.getPlayer(0).getResourceList().removeResource(2, 200);
		Game.GAME.getPlayer(0).getResourceList().removeResource(3, 250);
	}

}
