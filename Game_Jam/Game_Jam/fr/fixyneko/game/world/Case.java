package fr.fixyneko.game.world;

import java.util.Random;

import fr.gagoi.game.utils.Player;
import fr.gagoi.game.utils.ResourceList;

public class Case {

	public static final int TYPE_GRASS = 0;
	public static final int TYPE_WOOD = 1;
	public static final int TYPE_FOOD = 2;
	public static final int TYPE_ORE = 3;
	public static final int TYPE_CITY = 4;

	private ResourceList resource;
	private int resType;
	private Player player = new Player(-1, 0, "NPC");

	public Case(int resType) {
		this.resType = resType;
		this.resource = new ResourceList();
		this.resource.setResource(resType, new Random().nextInt(11) * 50 + 800);
	}

	public ResourceList getResources() {
		return this.resource;
	}
	
	public int getType() {
		return this.resType;
	}
	
	public void setPlayer(Player p) {
		this.player = p;
	}
	
	public Player getPlayer() {
		return this.player;
	}
}
