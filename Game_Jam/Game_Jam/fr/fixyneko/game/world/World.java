package fr.fixyneko.game.world;

import java.awt.Graphics;

import fr.gagoi.game.graphics.Drawable;

public class World implements Drawable{

	Case[][] cases;
	
	public World(int x, int y) {
		cases = new Case[x][y];
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
