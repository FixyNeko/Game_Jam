package fr.gagoi.game.core;

import fr.fixyneko.game.world.World;
import fr.gagoi.game.graphics.Display;

public class Game implements Runnable {

	public static Game GAME;

	private final Display display;
	private boolean isRunning = true;

	private int xOffset, yOffset;

	public Game() {
		this.display = new Display();
	}

	public Display getDisplay() {
		return display;
	}

	@Override
	public void run() {
		// TODO : Mettre du tour par tour.
		while (isRunning) {
			update();
		}
	}

	public void update() {
		new World(4,4,64);
	}

	public int getXOffset() {
		return this.xOffset;
	}

	public int getYOffset() {
		return this.yOffset;
	}

	public void setXOffset(int x) {
		this.xOffset = x;
	}

	public void setYOffset(int y) {
		this.yOffset = y;
	}

	public static void main(String args[]) {
		GAME = new Game();
	}
}
