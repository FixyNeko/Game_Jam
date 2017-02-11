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
	}

	public void render() {
		System.out.println(this.hasFocus());
		Graphics g = img.getGraphics();
		g.clearRect(0, 0, 800, 800);
		g.setColor(Color.BLUE);
		g.fillRect(20, 20, 250, 250);
		getGraphics().drawImage(img, 0, 0, null);
	}
}
