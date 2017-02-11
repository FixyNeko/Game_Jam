package fr.gagoi.game.graphics;

import java.awt.geom.Point2D;

public class Button {

	private int x, y, width, height;

	public Button(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public boolean contain(Point2D p) {
		return (x <= p.getX() && x + width >= p.getX() && y <= p.getY() && y + height <= p.getY());
	}

	public void onClick() {

	}
}
