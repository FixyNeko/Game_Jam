package fr.fixyneko.game.world;

import fr.gagoi.game.utils.Player;

public class Unit {
	
	public static final int TYPE_PAYSAN = 0;
	public static final int TYPE_SOLDAT = 1;
	public static final int TYPE_TANK = 2;

	int attack, life;
	int posX, posY;
	int unitType;
	Player player;

	public Unit(int attack, int life, int x, int y, int unitType, Player player) {
		this.attack = attack;
		this.life = life;
		this.posX = x;
		this.posY = y;
		this.unitType = unitType;
		this.player = player;
	}
	
	public void update(){
	}

	public int getType() {
		return this.unitType;
	}

	public int getX() {
		return this.posX;
	}

	public int getY() {
		return this.posY;
	}
	
	public int getAttack(){
		return this.attack;
	}
	
	public int getLife() {
		return this.life;
	}
	
	public Player getPlayer() {
		return this.player;
	}
}
