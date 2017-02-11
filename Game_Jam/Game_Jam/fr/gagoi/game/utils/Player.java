package fr.gagoi.game.utils;

public class Player {

	public static int CHARACTER_RICH = 0;

	public static int[][] base_resources = { { 100, 100, 100, 100, 100 }, { 50, 50, 50, 50, 50 }, };

	private String name;
	private int id;
	private DeckCard[] deck;
	private ResourceList resources;

	public Player(int playerId, int character, String name) {
		this.id = playerId;
		this.name = name;
		this.deck=new DeckCard[]{new DeckCard(0),new DeckCard(1),new DeckCard(2),new DeckCard(3),new DeckCard(4),new DeckCard(5)};
		this.resources = new ResourceList();
		for (int i = 0; i < base_resources[character].length; i++)
			this.resources.setResource(i, base_resources[character][i]);
	}

	public String getName() {
		return name;
	}

}
