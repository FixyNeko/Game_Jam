package fr.gagoi.game.cards;

import fr.gagoi.game.core.Game;

public class Card_Boucherie extends Card {

	@Override
	public String getImage() {
		return "/cartes/ressources/boucherie.jpg";
	}

	@Override
	public void onUse() {
		Game.GAME.getPlayer(Game.GAME.getPlayersTurn()).getResourceList().addResource(1, 500);
	}

}
