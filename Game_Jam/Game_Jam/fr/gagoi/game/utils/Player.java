package fr.gagoi.game.utils;

import fr.gagoi.game.cards.Card;
import fr.gagoi.game.graphics.Button;

public class Player {

	public static int CHARACTER_RICH = 0;
	public static int[][] base_resources = { { 100, 100, 100, 100, 100 }, { 50, 50, 50, 50, 50 }, };

	private String name;
	private int id;
	private boolean isPlaying = true;
	private DeckCard[] deck;
	private CardSlot slot;
	private ResourceList resources;
	private Button end;

	public Player(int playerId, int character, String name) {
		this.id = playerId;
		this.name = name;
//		this.deck = new DeckCard[] { new DeckCard(0), new DeckCard(1), new DeckCard(2), new DeckCard(3),
//				new DeckCard(4), new DeckCard(5) };
//		this.slot = new CardSlot(0);
		
		this.resources = new ResourceList();
		for (int i = 0; i < base_resources[character].length; i++)
			this.resources.setResource(i, base_resources[character][i]);
		end = new Button(1116, 695, 255, 90){
			@Override
			public void action() {
				setPlaying(false);
			}
		};
	}

	public ResourceList getResourceList() {
		return resources;
	}

	public String getName() {
		return name;
	}

	public boolean addCard(Card c) {
		for (int i = 0; i < deck.length; i++) {
			if (deck[i].getCard() == null) {
				deck[i].setCard(c);
				c = null;
				return true;
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

}
