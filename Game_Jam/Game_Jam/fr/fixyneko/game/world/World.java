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

	Case[][] cases;
	int scl;

	boolean scroll = false;
	double prevMouseX = 0, prevMouseY = 0;
	int camX = 0, camY = 0;

	int resources[] = { 10, 10, 10, 10 };
	
	BufferedImage HUD;

	public World(int x, int y, int scl_) {
		cases = new Case[x][y];
		scl = scl_;
		init();
		Game.GAME.getDisplay().getCanvas().getDrawables().add(this);
		Game.GAME.getDisplay().getCanvas().addMouseListener(this);
	}

	void init() {
		for (int x = 0; x < cases.length; x++) {
			for (int y = 0; y < cases[x].length; y++) {
				cases[x][y] = new Case(-1);
			}
		} // make world all grass

		for (int i = 0; i < resources.length; i++) {
			for (int n = 0; n < resources[i]; n++) {
				int x;
				int y;

				do {
					x = new Random().nextInt(cases.length - 1);
					y = new Random().nextInt(cases[0].length - 1);
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

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

		double curMouseX = MouseInfo.getPointerInfo().getLocation().getX();
		double curMouseY = MouseInfo.getPointerInfo().getLocation().getY();
		
		//System.out.println(this.scroll);

		if (this.scroll) {
			double deltX = curMouseX - prevMouseX;
			double deltY = curMouseY - prevMouseY;
			camX -= deltX;
			camY -= deltY;
			camX = Math.max(0, Math.min(camX, cases.length * scl - 800));
			camY = Math.max(0, Math.min(camY, cases[0].length * scl - 750));
		}

		prevMouseX = curMouseX;
		prevMouseY = curMouseY;

		for (int x = 0; x < cases.length; x++) {
			for (int y = 0; y < cases[x].length; y++) {
				g.drawImage(cases[x][y].getImage(), x * scl - camX + 313, y * scl - camY, null);
				g.setColor(Color.BLACK);
				g.drawRect(x * scl - camX + 313, y * scl - camY, scl, scl);
			}
		}
		
		g.drawImage(HUD, 0, 0, null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouse click");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mouse press");
		this.scroll = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouse released");
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
