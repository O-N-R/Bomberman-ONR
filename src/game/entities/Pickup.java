package game.entities;

import game.resources.Images;
import game.resources.Sounds;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class Pickup {

	private PickupType type;
	private static Random rand = new Random();
	
	private int xPos;
	private int yPos;
	private Image img;
	
	public Pickup(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		randomizeType();
	}
	
	private void randomizeType() {
		int chance = rand.nextInt(44);
		if(chance == 43) {
			type = PickupType.LIFEUP;
			img = Images.LIFEUP_1;
		} else if(chance < 43 && chance >= 33) {
			type = PickupType.ADDBOMBS;
			img = Images.ADDBOMB;
		} else if(chance < 33 && chance >= 23) {
			type = PickupType.RANGEUP;
			img = Images.RANGEUP;
		} else if(chance < 23 && chance >= 13) {
			type = PickupType.RANGEDOWN;
			img = Images.RANGEDOWN;
		} else if(chance < 13) {
			type = PickupType.RANDOM;
			img = Images.RANDOM;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(img, xPos, yPos, null);
	}
	
	public void pickup(Player p) {
		switch(type) {
			case LIFEUP:
				System.out.println(p.getLife());
				if(p.getLife() < 3) {
					p.addLife();
				}
				System.out.println(p.getLife());
				break;
			case ADDBOMBS:
				if(p.getMaxBombs() < 3) {
					p.addMaxBombs();
				}
				break;
			case RANGEUP:
				p.addRange();
				break;
			case RANGEDOWN:
				if(p.getRange() > 1) {
					p.decreaseRange();
				}
				break;
			case RANDOM:
				int chance = rand.nextInt(3);
				if(chance == 0) {
					if(p.getLife() < 3) {
						p.addLife();
					}
				} else if(chance == 1) {
					if(p.getMaxBombs() < 3) {
						p.addMaxBombs();
					}
				} else if(chance == 2) {
					p.addRange();
				} else {
					if(p.getRange() > 1) {
						p.decreaseRange();
					}
				}
				break;
		}
		Sounds.playPowerup();
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
}
