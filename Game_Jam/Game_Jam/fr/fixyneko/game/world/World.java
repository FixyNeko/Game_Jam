package fr.fixyneko.game.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import fr.gagoi.game.core.Game;
import fr.gagoi.game.graphics.Drawable;

public class World implements Drawable, MouseListener {

	public static final int TUPE_GRASS = 0;
	public static final int TYPE_WOOD = 1;
	public static final int TYPE_FOOD = 2;
	public static final int TYPE_ORE = 3;
	public static final int TYPE_CITY = 4;

	Case[][] cases;
	int scl;

	boolean scroll = false;
	double prevMouseX = 0, prevMouseY = 0;
	int camX = 0, camY = 0;

	int resources[] = { 50, 50, 50, 50 };

	BufferedImage HUD;
	BufferedImage[] sprites = new BufferedImage[5];

	public World(int x, int y, int scl_) {
		cases = new Case[x][y];
		scl = scl_;
		init();
		initSprite();
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

				cases[x][y] = new Case(i + 1);
			}
		} // put ressources randomly in specified amounts on world (overwrite)

		try {
			HUD = ImageIO.read(getClass().getResourceAsStream("/resources/textures/gui/HUD.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			HUD = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		}
	}

	void initSprite() {
		for (int i = 0; i < sprites.length; i++) {
			String path;
			switch (i) {
			case TYPE_WOOD:
				path = "case_wood.png";
				break;
			case TYPE_FOOD:
				path = "case_food.png";
				break;
			case TYPE_ORE:
				path = "case_ore.png";
				break;
			case TYPE_CITY:
				path = "case_city.png";
				break;
			default:
				path = "case_void.png";
			}

			try {
				sprites[i] = ImageIO.read(getClass().getResourceAsStream("/resources/textures/world/" + path));
			} catch (IOException e) {
				sprites[i] = new BufferedImage(64, 64, BufferedImage.TYPE_INT_RGB);
				Graphics g = sprites[i].getGraphics();
				g.setColor(Color.RED);
				g.fillRect(0, 0, 64, 64);
				e.printStackTrace();
			}
		}
	}

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
				if (((x+1) * scl - camX > 0) && (x * scl - camX) < 774 && ((y+1) * scl - camY) > 0 && (y * scl - camY) < 770) {
					g.drawImage(sprites[cases[x][y].getType()], x * scl - camX + 313, y * scl - camY, null);
				}
			}
		}

		g.drawImage(HUD, 0, 0, null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
