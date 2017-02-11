package fr.fixyneko.test;

import java.util.Random;

public class Vect {

	float x, y;

	public Vect() {
		double a = new Random().nextFloat() * Math.PI;
		this.x = (float) Math.cos(a);
		this.y = (float) Math.sin(a);
	}

	public Vect(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Vect add(Vect v) {
		return new Vect(this.x + v.getX(), this.y + v.getY());
	}
	
	public Vect scale(float scl) {
		return new Vect(this.x * scl, this.y * scl);
	}

	public float getX() {
		return this.x;
	}

	public float getY() {
		return this.y;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

}
