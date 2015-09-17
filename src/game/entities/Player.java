package game.entities;

import game.maps.Map;
import game.resources.Images;
import game.resources.Sounds;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.List;
import java.util.Random;

public class Player {
	
	public static final int WIDTH = 30;
	public static final int HEIGHT = 40;
	
	private static Random rand = new Random();
	
	private int speed;
	private int range;
	private int maxBombs;
	private int currentBombs;
	private boolean infiniteBombs;
	
	//movement variables
	private Map map;
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	
	private int life;
	private boolean mayweather;
	
	private Image[] img;
	private int frameCounter;
		
	private int xPos;
	private int yPos;
	
	public Player(Map map, int xPos, int yPos, boolean b) {
		this.map = map;
		this.xPos = xPos;
		this.yPos = yPos;
		this.speed = 3;
		this.mayweather = b;
		this.range = 4;
		this.maxBombs = 1;
		this.currentBombs = 0;
		this.life = 3;
		this.infiniteBombs = false;
		this.img = new Image[9];
		this.frameCounter = 0;
		initImage();
	}
	
	private void initImage() {
		if(mayweather) {
			img[0] = Images.MAY_0;
			img[1] = Images.MAYUP_0;
			img[2] = Images.MAYUP_1;
			img[3] = Images.MAYDOWN_0;
			img[4] = Images.MAYDOWN_1;
			img[5] = Images.MAYLEFT_0;
			img[6] = Images.MAYLEFT_1;
			img[7] = Images.MAYRIGHT_0;
			img[8] = Images.MAYRIGHT_1;
		} else {
			img[0] = Images.PAC_0;
			img[1] = Images.PACUP_0;
			img[2] = Images.PACUP_1;
			img[3] = Images.PACDOWN_0;
			img[4] = Images.PACDOWN_1;
			img[5] = Images.PACLEFT_0;
			img[6] = Images.PACLEFT_1;
			img[7] = Images.PACRIGHT_0;
			img[8] = Images.PACRIGHT_1;
		}
	}
	
	public void addLife() {
		life += 1;
	}
	
	public void addMaxBombs() {
		maxBombs += 1;
	}
	
	public void addRange() {
		range += 1;
	}
	
	public void decreaseRange() {
		range -= 1;
	}
	
	public void render(Graphics g) {
		g.drawImage(img[frameCounter], xPos, yPos, null);
	}
	
	public void setUp(boolean b) {
		up = b;
	}
	
	public void setDown(boolean b) {
		down = b;
	}
	
	public void setLeft(boolean b) {
		left = b;
	}
	
	public void setRight(boolean b) {
		right = b;
	}
	
	public int getLife() {
		return this.life;
	}
	
	public int getXPos(){
		return xPos;
	}
	
	public int getYPos(){
		return yPos;
	}
	
	public void update() {
		//movement
		if(up) {
			if(frameCounter == 1 || frameCounter == 0) frameCounter = 2;
			else if(frameCounter == 2 || frameCounter != 1) frameCounter = 1;
			if(map.getTileAt(xPos, yPos-speed) == Map.GROUND && map.getTileAt(xPos+Player.WIDTH, yPos-speed) == Map.GROUND && !map.isWall(xPos, yPos-speed) && !map.isBomb(xPos, yPos-speed, this))
				yPos -= speed;
		}
		if(down) {
			if(frameCounter == 3 || frameCounter == 0) frameCounter = 4;
			else if(frameCounter == 4 || frameCounter != 3) frameCounter = 3;
			if(map.getTileAt(xPos, yPos+speed+Player.HEIGHT) == Map.GROUND && map.getTileAt(xPos+Player.WIDTH, yPos+speed+Player.HEIGHT) == Map.GROUND && !map.isWall(xPos, yPos+speed+Player.HEIGHT) && !map.isWall(xPos, yPos+speed+Player.HEIGHT) && !map.isBomb(xPos, yPos+speed+Player.HEIGHT, this))
				yPos += speed;
		}
		if(left) {
			if(frameCounter == 5 || frameCounter == 0) frameCounter = 6;
			else if(frameCounter == 6 || frameCounter != 5) frameCounter = 5;
			if(map.getTileAt(xPos-speed, yPos) == Map.GROUND && map.getTileAt(xPos-speed, yPos+Player.HEIGHT) == Map.GROUND && !map.isWall(xPos-speed, yPos) && !map.isBomb(xPos-speed, yPos, this))
				xPos -= speed;
		}
		if(right) {
			if(frameCounter == 7 || frameCounter == 0) frameCounter = 8;
			else if(frameCounter == 8 || frameCounter != 7) frameCounter = 7;
			if(map.getTileAt(xPos+speed+Player.WIDTH, yPos) == Map.GROUND && map.getTileAt(xPos+speed+Player.WIDTH, yPos+Player.HEIGHT) == Map.GROUND && !map.isWall(xPos+speed+Player.WIDTH, yPos) && !map.isWall(xPos+speed+Player.WIDTH, yPos+Player.HEIGHT) && !map.isBomb(xPos+speed+Player.WIDTH/2, yPos, this))
				xPos += speed;
		}
	}
	
	public void dropBomb() {
		//System.out.println(map.getTileAt(xPos, yPos+Player.HEIGHT));
		if(infiniteBombs) {
			if(map.getTileAt(xPos+Player.WIDTH/2, yPos+Player.HEIGHT/2) == Map.GROUND) {
			int x = map.getXCoor(xPos+Player.WIDTH/2);
			int y = map.getYCoor(yPos+Player.HEIGHT/2);
			//if (!map.isBombAlready(x,y))
				map.addBomb(new Bomb(x, y, range), this);
				Sounds.playDropbomb();
			//System.out.println("The bomb has been planted.");
			}
		} else {
			if(currentBombs < maxBombs) {
				if(map.getTileAt(xPos+Player.WIDTH/2, yPos+Player.HEIGHT/2) == Map.GROUND) {
					int x = map.getXCoor(xPos+Player.WIDTH/2);
					int y = map.getYCoor(yPos+Player.HEIGHT/2);
					//if (!map.isBombAlready(x,y))
						map.addBomb(new Bomb(x, y, range), this);
						Sounds.playDropbomb();
					//System.out.println("The bomb has been planted.");
					currentBombs += 1;
				}
			}
		}
	}
	
	public int getRange() {
		return range;
	}
	
	public int getMaxBombs(){
		return maxBombs;
	}
	
	public boolean isMayweather(){
		return this.mayweather;
	}
	
	public void bombExploded() {
		currentBombs -= 1;
	}
	
	public void decreaseLife() {
		life -= 1;
	}
	
	public boolean isDead() {
		if (life < 1) return true;
		else return false;
	}
	
	public void respawn() {
		boolean found = false;
		int index, max, x, y;
		List<Point> ground = map.getGround();
		max = ground.size();
		while(!found) {
			index = rand.nextInt(max);
			x = (int) ground.get(index).getX();
			y = (int) ground.get(index).getY();
			if(!map.isBomb(x, y, this) && map.getPlayerAt(x, y) == null) {
				xPos = x+2;
				yPos = y+1;
				found = true;
			}
		}
	}
	
}