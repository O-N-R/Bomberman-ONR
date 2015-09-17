package game.entities;

import game.resources.Images;

import java.awt.Graphics;

public class Bomb {
	
	private int xPos;
	private int yPos;
	private int counter;
	private int range;
	
	public Bomb(int xPos, int yPos, int range) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.range = range;
	}
	
	public void render(Graphics g) {
		if(counter >= 25 && counter < 50) g.drawImage(Images.BOMB_1, xPos, yPos, null);
		else if(counter >= 50 && counter < 75) g.drawImage(Images.BOMB_2, xPos, yPos, null);
		else if(counter >= 75 && counter < 100) g.drawImage(Images.BOMB_1, xPos, yPos, null);
		else if(counter >= 100 && counter < 125) g.drawImage(Images.BOMB_2, xPos, yPos, null);
		else if(counter >= 125 && counter < 150) g.drawImage(Images.BOMB_1, xPos, yPos, null);
		else g.drawImage(Images.BOMB_2, xPos, yPos, null);
	}
	
	public void update() {
		counter += 1;
	}
	
	public int getCounter() {
		return counter;
	}
	
	public int getRange() {
		return range;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
}
