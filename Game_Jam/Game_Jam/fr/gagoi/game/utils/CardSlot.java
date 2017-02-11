package fr.gagoi.game.utils;

import fr.gagoi.game.graphics.Button;

public class CardSlot extends Button{
	
	private static int[][] pos = { { 1093, 42 }, { 1243, 42 }, { 1093, 254 }, { 1243, 254 }, { 1093, 466 }, { 1243, 466 } };
	
	public CardSlot(int index) {
		super(pos[index][0], pos[index][1], 150, 210);
	}

}
