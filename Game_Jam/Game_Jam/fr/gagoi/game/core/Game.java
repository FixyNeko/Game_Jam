package fr.gagoi.game.core;

import fr.fixyneko.game.world.Unit;
import fr.fixyneko.game.world.World;
import fr.gagoi.game.cards.Card;
import fr.gagoi.game.graphics.Display;
import fr.gagoi.game.utils.Player;

public class Game implements Runnable {

	public static Game GAME;

	private final Display display;
	private boolean isEnded = false;
	private final Thread t;

	private Player p1, p2;
	private int xOffset, yOffset;
	private int playersTurn, turnStape;
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
		deck = new Card[50];
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 5; j++)
				getPlayer(i).addCard(deck[j + i * 5]);
		p1 = new Player(0, 0, "Player 1");
		p2 = new Player(1, 0, "Player 2");

		while (!isEnded)
			update();
	}

	public void update() {
		getPlayer(playersTurn).setPlaying(true);
		for (int i = 0; i < deck.length; i++) {
			if (deck[i] != null) {
				getPlayer(playersTurn).addCard(deck[i]);
				break;
			}
		}

		while (getPlayer(playersTurn).isPlaying())
			;

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

	public static void main(String args[]) {
		GAME = new Game();
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
