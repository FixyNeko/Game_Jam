package fr.gagoi.game.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Vector;

@SuppressWarnings("serial")
public class ScreenCanvas extends Canvas {

	private BufferedImage img;
	private Vector<Drawable> drawables;

	public ScreenCanvas() {
		img = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
		drawables = new Vector<>();
	}

	public void render() {
		Graphics g = img.getGraphics();
		g.clearRect(0, 0, 800, 800);

		if(!drawables.isEmpty())
			for (Drawable drawable : drawables) 
				drawable.draw(g);
			
		getGraphics().drawImage(img, 0, 0, null);
	}
}
