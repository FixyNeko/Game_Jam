package fr.gagoi.game.utils;

import java.awt.Graphics;

import fr.gagoi.game.cards.Card;
import fr.gagoi.game.core.Game;
import fr.gagoi.game.graphics.Drawable;

public class Player implements Drawable {

	public static int CHARACTER_RICH = 0;

	public static int[][] base_resources = { { 100, 100, 100, 100, 100 }, { 50, 50, 50, 50, 50 }, };

	private String name;
	private int id;
	private Card[] inventory;
	private ResourceList resources;

	public Player(int playerId, int character, String name) {
		this.id = playerId;
		this.name = name;
		this.inventory = new Card[6];
		this.resources = new ResourceList();
		for (int i = 0; i < base_resources[character].length; i++)
			this.resources.setResource(i, base_resources[character][i]);
		Game.GAME.getDisplay().getCanvas().getDrawables().add(this);
	}

	@Override
	public void draw(Graphics g) {
		if (Game.GAME.getPlayersTurn() == id)
			for (int i = 0; i < inventory.length; i++) {
				Card card = inventory[i];
				if (card != null)
					g.drawImage(card.getTexture(), i % 2, i / 2, null);
			}
	}

	public String getName() {
		return name;
	}

}
