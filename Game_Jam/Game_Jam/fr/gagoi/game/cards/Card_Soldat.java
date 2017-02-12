package fr.gagoi.game.cards;

import fr.fixyneko.game.world.Unit;
import fr.gagoi.game.core.Game;

public class Card_Soldat extends Card {
<<<<<<< Upstream, based on branch 'master' of https://github.com/FixyNeko/Game_Jam/

	public Card_Soldat() {
	}

	@Override
	public void draw(Graphics g) {

	}
=======
>>>>>>> dcc0321 Correction de toutes les saloperies de Louis.

	@Override
	public String getImage() {
		return "/cartes/unites/soldat.jpg";
	}

	@Override
	public void onUse() {
		Game.GAME.getWorld().addUnit(new Unit(2, 2, 5, 5, 1, 1, Game.GAME.getPlayer(Game.GAME.getPlayersTurn())));
	}

}
