package fr.gagoi.game.graphics;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Vector;

import fr.gagoi.game.core.Game;

@SuppressWarnings("serial")
public class ScreenCanvas extends Canvas {

	private BufferedImage img;
	private Vector<Drawable> drawables;

	public ScreenCanvas() {
		img = new BufferedImage(1400, 800, BufferedImage.TYPE_INT_RGB);
		drawables = new Vector<>();
	}

	public void render() {
		Graphics g = img.getGraphics();
		g.clearRect(0, 0, 1400, 800);

		if (!drawables.isEmpty())
			for (Drawable drawable : drawables)
				drawable.draw(g);
		getGraphics().drawImage(img.getScaledInstance(Game.GAME.getDisplay().getWidth(), Game.GAME.getDisplay().getHeight(), BufferedImage.SCALE_SMOOTH), 0, 0, null);
	}

	public Vector<Drawable> getDrawables() {
		return drawables;
	}
}
