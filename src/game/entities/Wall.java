package game.entities;

import java.awt.Graphics;
import java.awt.Image;

public class Wall {

	private int xPos;
	private int yPos;
	private Image img;
	
	public Wall(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public void render(Graphics g) {
		/*switch(type) {
			case BOXING: 
				g.drawImage(Images.WALL_1, xPos, yPos, null);
				break;
			case GARDEN: 
				g.drawImage(Images.WALL_2, xPos, yPos, null);
				break;
			case PAN: 
				g.drawImage(Images.WALL_3, xPos, yPos, null);
				break;
		}*/
		g.drawImage(img, xPos, yPos, null);
	}
	
	public void updateImage(Image img) {
		this.img = img;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
}
