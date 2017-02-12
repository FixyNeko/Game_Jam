package fr.gagoi.game.cards;

import fr.fixyneko.game.world.Unit;
import fr.gagoi.game.core.Game;

public class Card_Paysan extends Card {
<<<<<<< Upstream, based on branch 'master' of https://github.com/FixyNeko/Game_Jam/

	public Card_Paysan() {
	}

	@Override
	public void draw(Graphics g) {

	}
=======
>>>>>>> dcc0321 Correction de toutes les saloperies de Louis.

	@Override
	public String getImage() {
		return "/cartes/unites/paysan.jpg";
	}

	@Override
	public void onUse() {
		Game.GAME.getWorld().addUnit(new Unit(1, 1, 5, 5, 0, 1, Game.GAME.getPlayer(Game.GAME.getPlayersTurn())));
	}

}
