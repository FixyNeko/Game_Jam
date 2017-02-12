package fr.gagoi.game.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import fr.gagoi.game.core.Game;
import fr.gagoi.game.graphics.Drawable;
import fr.gagoi.launcher.Launcher;

public class Player implements Drawable, KeyListener {

	public static int CHARACTER_RICH = 0;
	public static int[][] base_resources = { { 100, 100, 100, 100, 100 }, { 50, 50, 50, 50, 50 }, };

	private String name;
	private int id;
	private boolean isPlaying = true, isCarding = true;
	private ResourceList resources;

	private int[] cards = new int[6];
	private int[][] cardsPos = { { 1096, 42 }, { 1246, 42 }, { 1096, 254 }, { 1246, 254 }, { 1096, 466 },
			{ 1246, 466 } };

	public Player(int playerId, int character, String name) {
		this.id = playerId;
		this.name = name;
		this.resources = new ResourceList();
		for (int i = 0; i < cards.length - 1; i++)
			cards[i] = new Random().nextInt(Launcher.CARDS.length);
		for (int i = 0; i < base_resources[character].length; i++)
			this.resources.setResource(i, base_resources[character][i]);
		Game.GAME.getDisplay().getCanvas().getDrawables().add(this);
		Game.GAME.getDisplay().getCanvas().addKeyListener(this);
	}

	public ResourceList getResourceList() {
		return resources;
	}

	public String getName() {
		return name;
	}

	public boolean addCard(int c) {
		for (int i = 0; i < cards.length; i++)
			if (cards[i] == -1) {
				cards[i] = c;
				return true;
			}
		return false;
	}

	public int getId() {
		return id;
	}

	public boolean isPlaying() {
		return isPlaying;
	}

	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	@Override
	public void draw(Graphics g) {
		if (Game.GAME.getPlayersTurn() == id) {
			g.setColor(Color.BLACK);
			g.drawString(getName(), 5, 20);
			for (int i = 0; i < cards.length; i++)
				if (getCard(i) != -1)
					g.drawImage(Launcher.cardsTextures[getCard(i)], cardsPos[i][0], cardsPos[i][1], null);
		}
	}

	public int getCard(int j) {
		return cards[j];
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (Game.GAME.getPlayersTurn() == id)
			switch (e.getKeyCode()) {
			case KeyEvent.VK_NUMPAD7:
				if (getCard(0) != -1) {
					isCarding = false;
					Launcher.CARDS[getCard(0)].onUse();
					cards[0] = -1;
				}
				return;
			case KeyEvent.VK_NUMPAD8:
				if (getCard(1) != -1) {
					isCarding = false;
					Launcher.CARDS[getCard(1)].onUse();
					cards[1] = -1;
				}
				return;
			case KeyEvent.VK_NUMPAD4:
				if (getCard(2) != -1) {
					isCarding = false;
					Launcher.CARDS[getCard(2)].onUse();
					cards[2] = -1;
				}
				return;
			case KeyEvent.VK_NUMPAD5:
				if (getCard(3) != -1) {
					isCarding = false;
					Launcher.CARDS[getCard(3)].onUse();
					cards[3] = -1;
				}
				return;
			case KeyEvent.VK_NUMPAD1:
				if (getCard(4) != -1) {
					isCarding = false;
					Launcher.CARDS[getCard(4)].onUse();
					cards[4] = -1;
				}
				return;
			case KeyEvent.VK_NUMPAD2:
				if (getCard(5) != -1) {
					isCarding = false;
					Launcher.CARDS[getCard(5)].onUse();
					cards[5] = -1;
				}
				return;
			case KeyEvent.VK_ENTER:
				System.out.println("tet");
				if (!isCarding) {
					isPlaying = false;
				}
				return;
			}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	public boolean isCarding() {
		return isCarding;
	}

	public void setCarding(boolean b) {
		this.isCarding = b;
	}

}
