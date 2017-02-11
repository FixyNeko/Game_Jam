package fr.gagoi.game.utils;

public class ResourceList {

	public static final int TYPE_WOOD = 0;
	public static final int TYPE_FOOD = 1;
	public static final int TYPE_ORE = 2;
	public static final int TYPE_GOLD = 3;
	public static final int TYPE_POPULARITY = 4;

	private float wood, food, ore, gold, popularity;

	public float getResource(int type) {
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

	public void setResource(int type, float val) {
		switch (type) {
		case TYPE_WOOD:
			this.wood = val;
			return;
		case TYPE_FOOD:
			this.food = val;
			return;
		case TYPE_ORE:
			this.ore = val;
			return;
		case TYPE_GOLD:
			this.gold = val;
			return;
		case TYPE_POPULARITY:
			this.popularity = val;
			return;
		}
	}

	public void addResource(int type, float val) {
		setResource(type, getResource(type) + val);
	}

	public void removeResource(int type, float val) {
		setResource(type, getResource(type) - val);
	}
	
	public void multiplyResource(int type, float val) {
		setResource(type, getResource(type) * val);
	}
}
