package fr.fixyneko.game.world;

import java.awt.Graphics;

import fr.gagoi.game.graphics.Drawable;

public class World implements Drawable {

	Case[][] cases;
	int scl;
	int gameX = 800;
	int gameY = 800;

	public World(int x, int y) {
		cases = new Case[x][y];
		scl = Math.min(gameX/x, gameY/y);
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
