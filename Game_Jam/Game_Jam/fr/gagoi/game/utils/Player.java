package fr.gagoi.game.utils;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import fr.gagoi.game.cards.Card;
import fr.gagoi.game.graphics.Drawable;

public class Player implements Drawable {

	public static int CHARACTER_RICH = 0;
	public static int[][] base_resources = { { 100, 100, 100, 100, 100 }, { 50, 50, 50, 50, 50 }, };

	private String name;
	private int id;
	private boolean isPlaying = true;
	private ResourceList resources;

	int cardsNum = 6;
	Card[] cards = new Card[cardsNum];
	int[][] cardsPos = {{0,10},{50,10},{100,10},{150,10},{200,10},{250,10}};

	BufferedImage[] drawTextures = new BufferedImage[cardsNum + 1 + 1 + 1];

	public Player(int playerId, int character, String name) {
		this.id = playerId;
		this.name = name;
		// this.deck = new DeckCard[] { new DeckCard(0), new DeckCard(1), new
		// DeckCard(2), new DeckCard(3),
		// new DeckCard(4), new DeckCard(5) };
		// this.slot = new CardSlot(0);

		for (int i = 0; i < cardsNum; i++) {
			cards[i] = null;
		}

		this.resources = new ResourceList();
		for (int i = 0; i < base_resources[character].length; i++)
			this.resources.setResource(i, base_resources[character][i]);

	}

	public ResourceList getResourceList() {
		return resources;
	}

	public String getName() {
		return name;
	}

	public boolean addCard(Card c) {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == null) {
				try {
					cards[i] = (Card) c.clone();
				} catch (CloneNotSupportedException e) {
				}

				c = null;
				break;

			}
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
		for (int i = 0; i < cards.length; i++) {
			
		}
	}

}
