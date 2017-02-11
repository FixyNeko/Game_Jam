package fr.gagoi.game.core;

import fr.gagoi.graphics.Display;

public class Game implements Runnable {

	public static Game GAME;
	
	private final Display display;

	public Game() {
		this.display = new Display();
	}

	@Override
	public void run() {
		
	}

	public static void main(String args[]) {
		GAME = new Game();
	}
}
