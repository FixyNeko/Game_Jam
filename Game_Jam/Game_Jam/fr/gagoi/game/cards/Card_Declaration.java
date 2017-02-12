package fr.gagoi.game.cards;

import fr.gagoi.game.core.Game;

public class Card_Declaration extends Card {

	@Override
	public String getImage() {
		return "/cartes/lois/declaration_de_guerre.jpg";
	}

	@Override
	public void onUse() {
		Game.GAME.getPlayer(Game.GAME.getPlayersTurn()).getResourceList().multiplyResource(0,(0.9f));
		Game.GAME.getPlayer(Game.GAME.getPlayersTurn()).getResourceList().multiplyResource(1,(0.9f));
		Game.GAME.getPlayer(Game.GAME.getPlayersTurn()).getResourceList().multiplyResource(2,(0.9f));
		Game.GAME.getPlayer(Game.GAME.getPlayersTurn()).getResourceList().multiplyResource(3,(0.9f));
		//SUPPRIME TOUTES LES UNITES DE LA MAP.
	}

}
