package fr.gagoi.game.utils;

public class ResourceList {

	public static final int TYPE_WOOD = 0;
	public static final int TYPE_FOOD = 1;
	public static final int TYPE_ORE = 2;
	public static final int TYPE_GOLD = 3;
	public static final int TYPE_POPULARITY = 4;

	private int wood, food, ore, gold, popularity;

	public int getResource(int type) {
		switch (type) {
		case TYPE_WOOD:
			return wood;
		case TYPE_FOOD:
			return food;
		case TYPE_ORE:
			return ore;
		case TYPE_GOLD:
			return gold;
		case TYPE_POPULARITY:
			return popularity;
		default:
			return 0;
		}
	}

}
