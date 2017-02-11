package fr.gagoi.game.core;

import fr.gagoi.game.graphics.Display;

public class Game implements Runnable {

	public static Game GAME;

	@SuppressWarnings("unused")
	private final Display display;
	private boolean isRunning = true;

	public Game() {
		this.display = new Display();
	}

	@Override
	public void run() {
		// TODO : Mettre du tour par tour.
		while (isRunning) {
			update();
		}
	}

	public void update() {

	}
	
	public static void main(String args[]) {
		GAME = new Game();
	}
}
