package fr.gagoi.game.cards;

import java.awt.Image;

import fr.gagoi.game.graphics.Drawable;

public interface Card extends Drawable {

	public Image getImage();
	
	public void onUse();
}
