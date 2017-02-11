package fr.fixyneko.game.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import fr.gagoi.game.utils.ResourceList;

public class Case {

	public static final int TYPE_WOOD = 0;
	public static final int TYPE_FOOD = 1;
	public static final int TYPE_ORE = 2;
	public static final int TYPE_CITY = 3;

	private ResourceList resource = null;
	private BufferedImage img;

	public Case(int resType) {
		this.resource = new ResourceList();
		this.resource.setResource(resType, new Random().nextInt(11) * 50 + 800);

		String path = "case_void.png";
		switch (resType) {
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
		}

		try {
			img = ImageIO.read(getClass().getResourceAsStream("/resources/textures/world/" + path));
		} catch (IOException e) {
			img = new BufferedImage(64, 64, BufferedImage.TYPE_INT_RGB);
			Graphics g = img.getGraphics();
			g.setColor(Color.RED);
			g.fillRect(0, 0, 64, 64);
			e.printStackTrace();
		}
	}

	public ResourceList getType() {
		return this.resource;
	}

	public Image getImage() {
		// TODO Auto-generated method stub
		return img;
	}

}
