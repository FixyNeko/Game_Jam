package fr.gagoi.game.cards;

import fr.gagoi.game.core.Game;

public class Card_PartiUnique extends Card {

	@Override
	public String getImage() {
		return "/cartes/lois/parti_unique.jpg";
	}

	@Override
	public void onUse() {
		Game.GAME.getPlayer(Game.GAME.getPlayersTurn()).getResourceList().multiplyResource(4,(1.2f));
	}

}
