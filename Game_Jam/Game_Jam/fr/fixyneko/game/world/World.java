package fr.fixyneko.game.world;

import java.awt.Graphics;
import java.util.Random;

import fr.gagoi.game.core.Game;
import fr.gagoi.game.graphics.Drawable;

public class World implements Drawable {

	Case[][] cases;
	int scl;
	int gameX = 800;
	int gameY = 800;

	int ressources[] = { 10, 10, 10, 10, 10 };

	public World(int x, int y, int scl_) {
		// cases = new Case[x][y];
		scl = scl_;
		Game.GAME.getDisplay().getCanvas().getDrawables().add(this);
	}

	void init() {
		for (int i = 0; i < ressources.length; i++) {
			int x;
			int y;
			
			do {
				x = new Random().nextInt(gameX - 1);
				y = new Random().nextInt(gameY - 1);
			} while (cases[x][y] == null);
			
			cases[x][y] = new Case(i);
		}
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
