package fr.gagoi.game.core;

import java.util.Random;

import fr.fixyneko.game.world.Unit;
import fr.fixyneko.game.world.World;
import fr.gagoi.game.cards.Card;
import fr.gagoi.game.graphics.Display;
import fr.gagoi.game.utils.Player;
import fr.gagoi.launcher.Launcher;

public class Game implements Runnable {

	public static Game GAME;

	private final Display display;
	private boolean isEnded = false;
	private final Thread t;

	private Player p1, p2;
	private int xOffset, yOffset;
	private int playersTurn;
	private Card[] deck;
	private World world;

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
		world = new World(50, 50, 64);
		p1 = new Player(0, 0, "Player 1");
		p2 = new Player(1, 0, "Player 2");
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 4; j++)
				getPlayer(i).addCard(new Random().nextInt(Launcher.CARDS.length));
		while (!isEnded)
			update();
	}

	public void update() {
		getPlayer(playersTurn).setPlaying(true);
		getPlayer(playersTurn).setCarding(true);
		getPlayer(playersTurn).addCard(new Random().nextInt(Launcher.CARDS.length));

		while (getPlayer(playersTurn).isPlaying() || getPlayer(playersTurn).isCarding()){
		}

		for (Unit u : getWorld().getUnits(getPlayer(playersTurn)))
			u.update();

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

	public int getPlayersTurn() {
		return playersTurn;
	}

	public Card[] getDeck() {
		return deck;
	}

	public Player getPlayer(int id) {
		if (id == 0)
			return p1;
		return p2;
	}

	public World getWorld() {
		return world;
	}

	public void checkEnd() {

	}
}
