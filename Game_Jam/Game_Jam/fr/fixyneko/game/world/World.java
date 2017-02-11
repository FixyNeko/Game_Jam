package fr.fixyneko.game.world;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import javax.imageio.ImageIO;

import fr.gagoi.game.core.Game;
import fr.gagoi.game.graphics.Drawable;
import fr.gagoi.game.utils.Player;

public class World implements Drawable, MouseListener {

	public static final int TYPE_GRASS = 0;
	public static final int TYPE_WOOD = 1;
	public static final int TYPE_FOOD = 2;
	public static final int TYPE_ORE = 3;
	public static final int TYPE_CITY = 4;

	Case[][] cases;
	Vector<Unit> units = new Vector<Unit>();

	int scl;

	boolean scroll = false;
	double prevMouseX = 0, prevMouseY = 0;
	int camX = 0, camY = 0;

	int resources[] = { 50, 50, 50, 50 };

	int casesNum = 5;
	int unitsNum = 5;

	BufferedImage HUD;
	BufferedImage[] sprites = new BufferedImage[casesNum + unitsNum];

	public World(int x, int y, int scl_) {
		cases = new Case[x][y];
		scl = scl_;
		init();
		initSprites();

		units.add(new Unit(10, 10, 5, 5, 0, new Player()));// pop a unit

		Game.GAME.getDisplay().getCanvas().getDrawables().add(this);
		Game.GAME.getDisplay().getCanvas().addMouseListener(this);
	}

	void init() {
		for (int x = 0; x < cases.length; x++) {
			for (int y = 0; y < cases[x].length; y++) {
				cases[x][y] = new Case(0);
			}
		} // make world all grass

		for (int i = 0; i < resources.length; i++) {
			for (int n = 0; n < resources[i]; n++) {
				int x;
				int y;

				do {
					x = new Random().nextInt(cases.length);
					y = new Random().nextInt(cases[0].length);
				} while (cases[x][y] == null);

				cases[x][y] = new Case(i);
			}
		} // put ressources randomly in specified amounts on world (overwrite)

		try {
			HUD = ImageIO.read(getClass().getResourceAsStream("/resources/textures/gui/HUD.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			HUD = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		}
	}

	void initSprites() {
		try {
			sprites[1] = ImageIO.read(getClass().getResourceAsStream("/resources/textures/world/" + "case_wood.png"));
			sprites[2] = ImageIO.read(getClass().getResourceAsStream("/resources/textures/world/" + "case_food.png"));
			sprites[3] = ImageIO.read(getClass().getResourceAsStream("/resources/textures/world/" + "case_ore.png"));
			sprites[4] = ImageIO.read(getClass().getResourceAsStream("/resources/textures/world/" + "case_city.png"));
			sprites[0] = ImageIO.read(getClass().getResourceAsStream("/resources/textures/world/" + "case_void.png"));
		} catch (Exception e) {
		}

		try {
			sprites[0 + casesNum] = ImageIO
					.read(getClass().getResourceAsStream("/resources/textures/units/" + "pecore.png"));
			// sprites[1 + casesNum] =
			// ImageIO.read(getClass().getResourceAsStream("/resources/textures/units/"
			// + "case_void.png"));
			// sprites[2 + casesNum] =
			// ImageIO.read(getClass().getResourceAsStream("/resources/textures/units/"
			// + "case_void.png"));
			// sprites[3 + casesNum] =
			// ImageIO.read(getClass().getResourceAsStream("/resources/textures/units/"
			// + "case_void.png"));
			// sprites[4 + casesNum] =
			// ImageIO.read(getClass().getResourceAsStream("/resources/textures/units/"
			// + "case_void.png"));
		} catch (Exception e) {
		}

	}

	void addUnit(Unit u) {
		units.add(u);
	}

	void removeUnit(Unit u) {
		units.removeElement(u);
	}

	public Vector<Unit> getUnits(Player p) {
		Vector<Unit> u = new Vector<Unit>();
		for (int i = 0; i < u.size(); i++) {
			if(u.get(i).getPlayer() == p)
				u.add(u.get(i));
		}
		return u;
	}
	public Vector<Case> getCases(Player p) {
		Vector<Unit> u = new Vector<Unit>();
		for (int i = 0; i < u.size(); i++) {
			if(u.get(i).getPlayer() == p)
				u.add(u.get(i));
		}
		return u;
	}

	int pointerX = 0;
	int pointerY = 0;

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

		double curMouseX = MouseInfo.getPointerInfo().getLocation().getX();
		double curMouseY = MouseInfo.getPointerInfo().getLocation().getY();

		if (this.scroll) {
			double deltX = curMouseX - prevMouseX;
			double deltY = curMouseY - prevMouseY;
			camX -= deltX;
			camY -= deltY;
			camX = Math.max(0, Math.min(camX, cases.length * scl - 750));
			camY = Math.max(0, Math.min(camY, cases[0].length * scl - 750));
		}

		prevMouseX = curMouseX;
		prevMouseY = curMouseY;

		for (int x = 0; x < cases.length; x++) {
			for (int y = 0; y < cases[x].length; y++) {
				if (((x + 1) * scl - camX > 0) && (x * scl - camX) < 774 && ((y + 1) * scl - camY) > 0
						&& (y * scl - camY) < 770) {
					g.drawImage(sprites[cases[x][y].getType()], x * scl - camX + 313, y * scl - camY, null);
				}
			}
		}

		for (int i = 0; i < units.size(); i++) {
			int x = units.get(i).getX();
			int y = units.get(i).getY();
			if (((x + 1) * scl - camX > 0) && (x * scl - camX) < 774 && ((y + 1) * scl - camY) > 0
					&& (y * scl - camY) < 770) {
				if (units != null)
					g.drawImage(sprites[units.get(i).getType() + casesNum - 1], units.get(i).getX() * scl - camX + 313,
							units.get(i).getY() * scl - camY, null);
			}
		}

		g.drawImage(HUD, 0, 0, null);

		g.drawRect(pointerX * scl - camX + 313, pointerY * scl - camY, 50, 50);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		pointerX = e.getX();
		pointerY = e.getY();

		pointerX = pointerX * 1400 / Game.GAME.getDisplay().getWidth() + camX - 313;
		pointerY = pointerY * 800 / Game.GAME.getDisplay().getHeight() + camY;

		System.out.println(pointerX / 64);

		for (int i = 0; i < units.size(); i++) {
			int deltaX = units.get(i).getX() - e.getX();
			int deltaY = units.get(i).getY() - e.getY();
			if (deltaX > 0 && deltaX < scl && deltaY > 0 && deltaY < scl) {

			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.scroll = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.scroll = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
