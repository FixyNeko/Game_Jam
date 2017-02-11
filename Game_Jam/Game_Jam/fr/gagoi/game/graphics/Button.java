package fr.gagoi.game.graphics;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Button implements Drawable{

	private int x, y, width, height;

	public Button(int x, int y, int width, int height, String texture_name) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		try {
			BufferedImage img =ImageIO.read(getClass().getResourceAsStream("/resources/textures/" + texture_name));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean contain(Point2D p) {
		return (x <= p.getX() && x + width >= p.getX() && y <= p.getY() && y + height <= p.getY());
	}

	public void onClick() {
		
	}
	
	@Override
	public void draw(Graphics g) {
	}
}
