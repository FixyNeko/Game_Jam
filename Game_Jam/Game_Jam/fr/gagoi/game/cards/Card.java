package fr.gagoi.game.cards;

import java.awt.Graphics;

import fr.gagoi.game.graphics.Drawable;

public class Card implements Drawable, Cloneable {

	public String getImage() {
		return null;
	}
	
	public void onUse() {
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
}
