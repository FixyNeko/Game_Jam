package fr.gagoi.game.cards;

import fr.fixyneko.game.world.Unit;
import fr.gagoi.game.core.Game;

public class Card_Tank extends Card {

<<<<<<< Upstream, based on branch 'master' of https://github.com/FixyNeko/Game_Jam/
	public Card_Tank() {
	}

	@Override
	public void draw(Graphics g) {

	}
=======
>>>>>>> dcc0321 Correction de toutes les saloperies de Louis.

	@Override
	public String getImage() {
		return "/cartes/unites/tank.jpg";
	}

	@Override
	public void onUse() {
		Game.GAME.getWorld().addUnit(new Unit(5, 4, 5, 5, 2, 1, Game.GAME.getPlayer(Game.GAME.getPlayersTurn())));
	}

}
