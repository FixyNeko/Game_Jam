package fr.gagoi.game.utils;

import java.awt.Graphics;

import fr.gagoi.game.cards.Card;
import fr.gagoi.game.core.Game;
import fr.gagoi.game.graphics.Button;

public class DeckCard extends Button {

	private static int[][] pos = { { 1093, 42 }, { 1243, 42 }, { 1093, 254 }, { 1243, 254 }, { 1093, 466 }, { 1243, 466 } };
	
	private Card card;

	public DeckCard(int slot) {
		super(pos[slot][0], pos[slot][1], 150, 210, "");
		Game.GAME.getDisplay().getCanvas().getDrawables().add(this);
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public void action() {
		card.onUse();
		setCard(null);
	}
	
	@Override
	public void draw(Graphics g) {
		if(card!=null)
			super.draw(g);
	}
}
