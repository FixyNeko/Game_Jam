package fr.gagoi.game.cards;

import fr.gagoi.game.core.Game;

public class Card_Tueur extends Card {

	@Override
	public String getImage() {
		return "/cartes/unites/tueur.jpg";
	}

	@Override
	public void onUse() {
		Game.GAME.setEnd(true);
	}

}
