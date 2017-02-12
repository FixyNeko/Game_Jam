package fr.fixyneko.game.world;

import fr.gagoi.game.core.Game;
import fr.gagoi.game.utils.Player;

public class Unit {

	public static final int TYPE_PAYSAN = 0;
	public static final int TYPE_SOLDAT = 1;
	public static final int TYPE_TANK = 2;

	private int attack, life;
	private int posX, posY;
	private int unitType;
	private int maxMove;
	private Player player;

	private int nextX;
	private int nextY;

	public Unit(int attack, int life, int x, int y, int unitType, int maxMove, Player player) {
		this.attack = attack;
		this.life = life;
		this.posX = x;
		this.posY = y;
		this.nextX = x;
		this.nextY = y;
		this.unitType = unitType;
		this.maxMove = maxMove;
		this.player = player;
	}

	public void update() {
		this.posX = this.nextX;
		this.posY = this.nextY;

		if (this.life <= 0)
			Game.GAME.getWorld().removeUnit(this);
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

	public int getAttack() {
		return this.attack;
	}

	public int getLife() {
		return this.life;
	}

	public void takeHit(int damages) {
		this.life -= damages;
	}

	public Player getPlayer() {
		return this.player;
	}

	public double getMaxMove() {
		return this.maxMove;
	}

	public void setNextX(int pointerX) {
		this.nextX = pointerX;
	}

	public void setNextY(int pointerY) {
		this.nextY = pointerY;
	}
}
