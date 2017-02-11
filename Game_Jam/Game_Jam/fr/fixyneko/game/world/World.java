package fr.fixyneko.game.world;

import java.awt.Graphics;
import java.util.Random;

import fr.gagoi.game.core.Game;
import fr.gagoi.game.graphics.Drawable;

public class World implements Drawable {

	Case[][] cases;
	int scl;
	// int gameX = 800;
	// int gameY = 800;

	int resources[] = { 10, 10, 10, 10, 10 };

	public World(int x, int y, int scl_) {
		cases = new Case[x][y];
		scl = scl_;
		Game.GAME.getDisplay().getCanvas().getDrawables().add(this);
	}

	void init() {
		for (int x = 0; x < cases.length; x++) {
			for (int y = 0; y < cases[x].length; y++) {
				cases[x][y] = new Case(-1);
			}
		} // make world all grass

		for (int i = 0; i < resources.length; i++) {
			for (int n = 0; n < resources[i]; n++) {
				int x;
				int y;

				do {
					x = new Random().nextInt(cases.length - 1);
					y = new Random().nextInt(cases[0].length - 1);
				} while (cases[x][y] == null);

				cases[x][y] = new Case(i);
			}
		} // put ressources randomly in specified amounts on world (overwrite)
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		for (int x = 0; x < cases.length; x++) {
			for (int y = 0; y < cases[x].length; y++) {
				g.drawImage(cases[x][y].getImage(), x * scl, y * scl, null);
			}
		}
	}

}
