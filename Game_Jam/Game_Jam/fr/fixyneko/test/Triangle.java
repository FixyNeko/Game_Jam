package fr.fixyneko.test;

import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

@SuppressWarnings("serial")
public class Triangle extends Polygon {

	int n = 3;
	Vect[] pos = new Vect[n];

	public Triangle() {

		this.npoints = n;

		for (int i = 0; i < this.npoints; i++) {
			double a = new Random().nextFloat() * Math.PI;
			float x = (float) Math.cos(a);
			float y = (float) Math.sin(a);
			pos[i].setX(x);
			pos[i].setY(y);
		}
		updateShape(pos);
	}

	public void draw(Graphics g) {
		this.draw(g);
	}

	public void show(boolean b) {
		if (b) {
			// TODO add triangle to draw list if !in
		} else {
			// TODO remove triangle from draw list if in
		}
	}

	public void updateShape(Vect[] v) {
		while (this.npoints < v.length) {
			this.npoints++;
			this.addPoint(0, 0);
		}

		this.npoints = v.length;
		for (int i = 0; i < v.length; i++) {
			this.xpoints[i] = (int) v[i].getX();
			this.ypoints[i] = (int) v[i].getY();
		}
	}

}
