package fr.gagoi.game.cards;

public class Card implements  Cloneable {

	public String getImage() {
		return null;
	}

	public void onUse() {
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
