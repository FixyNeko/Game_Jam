package fr.gagoi.game.cards;

import fr.gagoi.game.core.Game;

public class Card_Vacances extends Card {


	@Override
	public String getImage() {
		return "/cartes/lois/vacances.jpg";
	}

	@Override
	public void onUse() {
		Game.GAME.getPlayer(Game.GAME.getPlayersTurn()).getResourceList().multiplyResource(4,(1.2f));
		Game.GAME.getPlayer(Game.GAME.getPlayersTurn()).getResourceList().multiplyResource(3,(0.8f));
	}

}
