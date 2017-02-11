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

	private ResourceList resource = null;
	private int resType;
	private Player player = new Player(-1, 0, "NPC");

	public Case(int resType) {
		this.resType = resType;
		this.resource = new ResourceList();
		this.resource.setResource(resType, new Random().nextInt(11) * 50 + 800);

//		String path;
//		switch (resType) {
//		case TYPE_WOOD:
//			path = "case_wood.png";
//			break;
//		case TYPE_FOOD:
//			path = "case_food.png";
//			break;
//		case TYPE_ORE:
//			path = "case_ore.png";
//			break;
//		case TYPE_CITY:
//			path = "case_city.png";
//			break;
//		default:
//			path = "case_void.png";
//		}
//
//		try {
//			img = ImageIO.read(getClass().getResourceAsStream("/resources/textures/world/" + path));
//		} catch (IOException e) {
//			img = new BufferedImage(64, 64, BufferedImage.TYPE_INT_RGB);
//			Graphics g = img.getGraphics();
//			g.setColor(Color.RED);
//			g.fillRect(0, 0, 64, 64);
//			e.printStackTrace();
//		}
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

//	public Image getImage() {
//		// TODO Auto-generated method stub
//		return img;
//	}

}
