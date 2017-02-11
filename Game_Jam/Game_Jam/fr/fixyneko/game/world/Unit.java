package fr.fixyneko.game.world;

public class Unit {

	int attack, life;
	int posX, posY;
	int unitType;

	public Unit(int a, int l, int x, int y, int uT) {
		this.attack = a;
		this.life = l;
		this.posX = x;
		this.posY = y;
		this.unitType = uT;
	}
	
	void update(){
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
}
