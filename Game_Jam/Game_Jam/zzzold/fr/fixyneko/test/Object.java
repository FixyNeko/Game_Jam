package fr.fixyneko.test;

import java.awt.Polygon;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Object extends Polygon {

	private float x;
	private float y;
	ArrayList<Triangle> tri;

	Vect pos, vel;

	private float rot, rotVel;
	private float rotInertia;

	public Object(float x, float y) {
		tri = new ArrayList<Triangle>(1);
		tri.set(0, new Triangle());

		pos = new Vect(0, 0);
		vel = new Vect(0, 0);

		rot = 0;
		rotVel = 0;
		rotInertia = 0;
	}

	public void update(float dt) {
		pos.add(vel.scale(dt));
		rot += rotVel / rotInertia * dt;
	}

	public void applyForce(Vect f) {
		vel.add(f);
	}
	
	public void applyMoment(float m) {
		rotVel += m;
	}

	public void show() {
		for (Triangle tri : tri) {
			tri.show(true);
		}
	}

}
