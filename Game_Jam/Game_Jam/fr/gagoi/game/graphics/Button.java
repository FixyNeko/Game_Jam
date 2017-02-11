package fr.gagoi.game.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import fr.gagoi.game.core.Game;

public class Button implements Drawable, MouseListener {

	private int x, y, width, height;
	private BufferedImage texture;

	public Button(int x, int y, int width, int height, String texture_name) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		try {
			this.texture = ImageIO.read(getClass().getResourceAsStream("/resources/textures/" + texture_name));
		} catch (IOException e) {
			this.texture = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = texture.getGraphics();
			g.setColor(Color.RED);
			g.fillRect(0, 0, width, height);
			e.printStackTrace();
		}
		Game.GAME.getDisplay().getCanvas().getDrawables().add(this);
		Game.GAME.getDisplay().getCanvas().addMouseListener(this);
	}

	public Button(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.texture = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		Game.GAME.getDisplay().getCanvas().getDrawables().add(this);
		Game.GAME.getDisplay().getCanvas().addMouseListener(this);
	}

	// A override pour ajouter action.
	public void action() {

	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(texture, x, y, null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Point p = e.getPoint();
		if ((x <= p.getX() && x + width >= p.getX() && y <= p.getY() && y + height <= p.getY()))
			action();
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
