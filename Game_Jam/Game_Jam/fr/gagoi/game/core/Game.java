package fr.gagoi.game.core;

import fr.fixyneko.game.world.World;
import fr.gagoi.game.graphics.Display;
import fr.gagoi.game.utils.Player;

public class Game implements Runnable {

	public static Game GAME;

	private final Display display;
	private boolean isRunning = true;
	private final Thread t;

	private Player p1, p2;
	private int xOffset, yOffset;
	private int playersTurn;

	public Game() {
		this.display = new Display();
		t = new Thread(this);
		t.start();
	}

	public Display getDisplay() {
		return display;
	}

	@Override
	public void run() {
		// TODO : Mettre du tour par tour.
		World world = new World(50, 50, 64);
		p1 = new Player(0, 0, "Player 1");
		p2 = new Player(1, 0, "Player 2");
		update();
	}

	public void update() {
		playersTurn = (playersTurn + 1) % 2;
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

	public int getPlayersTurn() {
		return playersTurn;
	}

	public Player getPlayer(int id) {
		if (id == 0)
			return p1;
		return p2;
	}
}
