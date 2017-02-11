package fr.fixyneko.game.world;

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
	public static final int TYPE_GOLD = 3;
	public static final int TYPE_POPULARITY = 4;

	private ResourceList resource;
	private BufferedImage img;

	public Case(int resType) {
		this.resource = new ResourceList();
		this.resource.setResource(resType, new Random().nextInt(11) * 50 + 800);

		
		
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/resources/textures/"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Image getImage() {
		// TODO Auto-generated method stub
		return img;
	}

}
