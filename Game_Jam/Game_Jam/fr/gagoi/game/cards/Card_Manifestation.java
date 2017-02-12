package fr.gagoi.game.cards;

import fr.gagoi.game.core.Game;

public class Card_Manifestation extends Card {

	@Override
	public String getImage() {
		return "/cartes/lois/manifestation.jpg";
	}

	@Override
	public void onUse() {
		Game.GAME.getPlayer(Game.GAME.getPlayersTurn()).getResourceList().multiplyResource(4,(0.8f));
	}

}
