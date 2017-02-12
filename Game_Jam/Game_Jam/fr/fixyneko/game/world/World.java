package fr.fixyneko.game.world;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

	private Case[][] cases;
	private Vector<Unit> units = new Vector<Unit>();

	private int scl;

	private boolean scroll = false;
	private double prevMouseX = 0, prevMouseY = 0;
	private int camX = 0, camY = 0;

	private int resources[] = { 50, 50, 50, 50 };

	private int casesNum = 5;
	private int unitsNum = 5;

	public int pointerX = -1;
	public int pointerY = -1;

	private BufferedImage HUD;
	private BufferedImage[] sprites = new BufferedImage[casesNum + unitsNum];

	public Unit unitSelected;

	public World(int width, int height, int scl) {
		this.cases = new Case[width][height];
		this.scl = scl;

		init();
		initSprites();

		Game.GAME.getDisplay().getCanvas().getDrawables().add(this);
		Game.GAME.getDisplay().getCanvas().addMouseListener(this);
	}

	private void init() {
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
			HUD = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		}
	}

	private void initSprites() {
		try {
			sprites[0] = ImageIO.read(getClass().getResourceAsStream("/resources/textures/world/" + "case_void.png"));
			sprites[1] = ImageIO.read(getClass().getResourceAsStream("/resources/textures/world/" + "case_wood.png"));
			sprites[2] = ImageIO.read(getClass().getResourceAsStream("/resources/textures/world/" + "case_food.png"));
			sprites[3] = ImageIO.read(getClass().getResourceAsStream("/resources/textures/world/" + "case_ore.png"));
			sprites[4] = ImageIO.read(getClass().getResourceAsStream("/resources/textures/world/" + "case_city.png"));
			sprites[casesNum + 0] = ImageIO
					.read(getClass().getResourceAsStream("/resources/textures/units/" + "pecore.png"));
			sprites[casesNum + 1] = ImageIO
					.read(getClass().getResourceAsStream("/resources/textures/units/" + "soldat.png"));
			sprites[casesNum + 2] = ImageIO
					.read(getClass().getResourceAsStream("/resources/textures/units/" + "tank.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addUnit(Unit u) {
		units.add(u);
	}

	public void removeUnit(Unit u) {
		units.removeElement(u);
	}

	public Vector<Unit> getUnits(Player p) {
		Vector<Unit> u = new Vector<Unit>();
		for (int i = 0; i < units.size(); i++)
			if (units.get(i).getPlayer() == p)
				u.add(units.get(i));
		return u;
	}

	public Vector<Case> getCases(Player p) {
		Vector<Case> u = new Vector<Case>();
		for (int x = 0; x < cases.length; x++)
			for (int y = 0; y < cases[x].length; y++)
				if (cases[x][y].getPlayer() == p)
					u.add(cases[x][y]);
		return u;
	}
	
	public void productiveCases() {
		for(Unit u:units){
			Case c = cases[u.getX()][u.getY()];
			int prod = (int) Math.min(50F, c.getResources().getResource(c.getType()));
			c.getResources().addResource(c.getType(), prod);
		}
	}

	@Override
	public void draw(Graphics g1) {
		Graphics2D g = (Graphics2D) g1;
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

		for (int x = 0; x < cases.length; x++)
			for (int y = 0; y < cases[x].length; y++)
				if (((x + 1) * scl - camX > 0) && (x * scl - camX) < 774 && ((y + 1) * scl - camY) > 0
						&& (y * scl - camY) < 770)
					g.drawImage(sprites[cases[x][y].getType()], x * scl - camX + 313, y * scl - camY, null);

		for (int i = 0; i < units.size(); i++) {
			int x = units.get(i).getX();
			int y = units.get(i).getY();
			if (((x + 1) * scl - camX > 0) && (x * scl - camX) < 774 && ((y + 1) * scl - camY) > 0
					&& (y * scl - camY) < 770) {
				g.drawImage(sprites[units.get(i).getType() + casesNum], units.get(i).getX() * scl - camX + 313,
						units.get(i).getY() * scl - camY, null);
				switch (units.get(i).getPlayer().getId()) {
				case 0:
					g.setColor(Color.RED);
					break;
				case 1:
					g.setColor(Color.YELLOW);
					break;
				}
				g.setStroke(new BasicStroke(15F));
				g.drawRect(units.get(i).getX() * scl - camX + 313, units.get(i).getY() * scl - camY, scl / 20,
						scl / 20);
			}
		}

		if (unitSelected != null) {
			g.setStroke(new BasicStroke(2F));
			g.setColor(Color.BLUE);
			g.drawRect(unitSelected.getX() * scl - camX + 313, unitSelected.getY() * scl - camY, scl, scl);
		}

		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(3F));
		g.drawRect(pointerX * scl - camX + 313, pointerY * scl - camY, scl, scl);

		if (unitSelected != null) {
			switch (Game.GAME.getPlayersTurn()) {
			case 0:
				g.setColor(Color.RED);
				break;
			case 1:
				g.setColor(Color.YELLOW);
				break;
			}
			g.setStroke(new BasicStroke(2F));
			g.drawRect(unitSelected.getX() * scl - camX + 313, unitSelected.getY() * scl - camY, scl / 20, scl / 20);
		}

		g.drawImage(HUD, 0, 0, null);
	}

	@SuppressWarnings("unused")
	@Override
	public void mouseClicked(MouseEvent e) {
		pointerX = e.getX() * 1400 / Game.GAME.getDisplay().getWidth() + camX - 313;
		pointerY = e.getY() * 800 / Game.GAME.getDisplay().getHeight() + camY;

		pointerX /= 64;
		pointerY /= 64;

		Unit unitClicked = null;

		for (int i = 0; i < units.size(); i++) {
			int deltaX = units.get(i).getX() - pointerX;
			int deltaY = units.get(i).getY() - pointerY;
			if (units.get(i).getX() == pointerX && units.get(i).getY() == pointerY) {
				unitClicked = units.get(i);
				break;
			}
		} // find object clicked

		if (unitClicked != null && unitSelected != null && unitClicked == unitSelected)
			unitSelected = null;
		else if (unitClicked == null && unitSelected != null && Math.hypot(pointerX - unitSelected.getX(),
				pointerY - unitSelected.getY()) <= unitSelected.getMaxMove()) {
			// clicked on map with unit selected
			unitSelected.setNextX(pointerX);
			unitSelected.setNextY(pointerY);

		} else if ((unitSelected == null)
				|| ((unitClicked != null) && (unitClicked.getPlayer().getId() == Game.GAME.getPlayersTurn())))
			unitSelected = unitClicked; // clicked on a new unit
		else if ((unitClicked != null) && (unitClicked.getPlayer().getId() != Game.GAME.getPlayersTurn())) {
			// ATTACK!!!
			unitClicked.takeHit(unitSelected.getAttack());
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
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}