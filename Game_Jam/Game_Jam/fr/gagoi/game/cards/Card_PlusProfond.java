package fr.gagoi.game.cards;

import fr.gagoi.game.core.Game;

public class Card_PlusProfond extends Card {

	@Override
	public String getImage() {
		return "/cartes/ressources/plus_profond.jpg";
	}

	@Override
	public void onUse() {
		Game.GAME.getPlayer(Game.GAME.getPlayersTurn()).getResourceList().addResource(2, 250);
	}

}
