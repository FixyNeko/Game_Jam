package fr.gagoi.game.cards;

import fr.gagoi.game.core.Game;

public class Card_Deforestation extends Card {

	@Override
	public String getImage() {
		return "/cartes/ressources/deforestation.jpg";
	}

	@Override
	public void onUse() {
		Game.GAME.getPlayer(Game.GAME.getPlayersTurn()).getResourceList().addResource(0, 300);
	}

}
