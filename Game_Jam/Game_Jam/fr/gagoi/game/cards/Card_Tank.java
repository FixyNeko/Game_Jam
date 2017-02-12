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
		Game.GAME.getWorld().addUnit(new Unit(5, 4, 5, 5, 2, 1, Game.GAME.getPlayer(Game.GAME.getPlayersTurn())));
	}

}
