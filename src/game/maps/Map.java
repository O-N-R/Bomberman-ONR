package game.maps;

import game.Game;
import game.entities.Bomb;
import game.entities.Pickup;
import game.entities.Player;
import game.entities.Wall;
import game.events.ExplodeBomb;
import game.events.TileEvent;
import game.resources.Images;
import game.resources.Sounds;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {
	
	public static final int WIDTH = 13;
	public static final int HEIGHT = 9;
	public static final int GROUND = 0;
	public static final int POST = 1;
	public static final int BORDER_TOP = 2;
	public static final int BORDER_LEFT = 3;
	public static final int BORDER_RIGHT = 4;
	public static final int BORDER_BOTTOM = 5;
	public static final int BORDER_TOPLEFT = 6;
	public static final int BORDER_TOPRIGHT = 7;
	public static final int BORDER_BOTTOMLEFT = 8;
	public static final int BORDER_BOTTOMRIGHT = 9;
	
	private static Random rand = new Random();
	
	private int xPos;
	private int yPos;
	
	private List<TileEvent> tileEvents;
	private List<Bomb> bombsP1;
	private List<Bomb> bombsP2;
	private List<Wall> walls;
	private List<Pickup> pickups;
	private List<Point> ground;
	private boolean disableMovep1;
	private boolean disableMovep2;
	
	private Player p1;
	private Player p2;
	
	private MapType type;
	private BufferedImage top_img;
	private BufferedImage left_img;
	private BufferedImage right_img;
	private BufferedImage bottom_img;
	private BufferedImage topleft_img;
	private BufferedImage topright_img;
	private BufferedImage bottomleft_img;
	private BufferedImage bottomright_img;
	private BufferedImage ground_img;
	private BufferedImage post_img;
	
	private int[][] tileMap = {
			{6,2,2,2,2,2,2,2,2,2,2,2,7},
			{3,0,0,0,0,0,0,0,0,0,0,0,4},
			{3,0,1,0,1,0,1,0,1,0,1,0,4},
			{3,0,0,0,0,0,0,0,0,0,0,0,4},
			{3,0,1,0,1,0,1,0,1,0,1,0,4},
			{3,0,0,0,0,0,0,0,0,0,0,0,4},
			{3,0,1,0,1,0,1,0,1,0,1,0,4},
			{3,0,0,0,0,0,0,0,0,0,0,0,4},
			{8,5,5,5,5,5,5,5,5,5,5,5,9}
	};
	
	public Map(int xPos, int yPos){
		this.xPos = xPos;
		this.yPos = yPos;
		this.tileEvents = new ArrayList<TileEvent>();
		this.bombsP1 = new ArrayList<Bomb>();
		this.bombsP2 = new ArrayList<Bomb>();
		this.walls = new ArrayList<Wall>();
		this.pickups = new ArrayList<Pickup>();
		this.ground = new ArrayList<Point>();
		addWalls();
		for(int i = 0; i < Map.HEIGHT; i+=1) {
			for(int j = 0; j < Map.WIDTH; j+=1) {
				if(tileMap[i][j] == Map.GROUND && !isWall((j*Game.TILESIZE)+xPos, (i*Game.TILESIZE)+yPos)) {
					ground.add(new Point((j*Game.TILESIZE)+xPos, (i*Game.TILESIZE)+yPos));
				}
			}
		}
		setMapType(MapType.BOXING);
	}
	
	public void setMapType(MapType mp) {
		this.type = mp;
		switch(type) {
			case BOXING:
				top_img = Images.TOP_1;
				topleft_img = Images.TOPLEFT_1;
				topright_img = Images.TOPRIGHT_1;
				left_img = Images.LEFT_1;
				right_img = Images.RIGHT_1;
				bottom_img = Images.BOTTOM_1;
				bottomleft_img = Images.BOTTOMLEFT_1;
				bottomright_img = Images.BOTTOMRIGHT_1;
				ground_img = Images.GROUND_1;
				post_img = Images.POST_1;
				for(int i = 0; i < walls.size(); i += 1) {
					walls.get(i).updateImage(Images.WALL_1);
				}
				break;
			case GARDEN:
				top_img = Images.TOP_2;
				topleft_img = Images.TOPLEFT_2;
				topright_img = Images.TOPRIGHT_2;
				left_img = Images.LEFT_2;
				right_img = Images.RIGHT_2;
				bottom_img = Images.BOTTOM_2;
				bottomleft_img = Images.BOTTOMLEFT_2;
				bottomright_img = Images.BOTTOMRIGHT_2;
				ground_img = Images.GROUND_2;
				post_img = Images.POST_2;
				for(int i = 0; i < walls.size(); i += 1) {
					walls.get(i).updateImage(Images.WALL_2);
				}
				break;
			case PAN:
				top_img = Images.TOP_3;
				topleft_img = Images.TOPLEFT_3;
				topright_img = Images.TOPRIGHT_3;
				left_img = Images.LEFT_3;
				right_img = Images.RIGHT_3;
				bottom_img = Images.BOTTOM_3;
				bottomleft_img = Images.BOTTOMLEFT_3;
				bottomright_img = Images.BOTTOMRIGHT_3;
				ground_img = Images.GROUND_3;
				post_img = Images.POST_3;
				for(int i = 0; i < walls.size(); i += 1) {
					walls.get(i).updateImage(Images.WALL_3);
				}
				break;
		}
	}
	
	public void setP1(Player p) {
		p1 = p;
	}
	
	public void setP2(Player p) {
		p2 = p;
	}
	
	public void addGround(Point p) {
		ground.add(p);
	}
	
	public List<Point> getGround() {
		return ground;
	}
		
	public int getTileAt(int xCoor, int yCoor){
		int x = this.xPos, y = this.yPos, i = 0, j = 0;
		
		while(xCoor > x+Game.TILESIZE) {
			x += Game.TILESIZE;
			i += 1;
		}
		
		while(yCoor > y+Game.TILESIZE) {
			y += Game.TILESIZE;
			j += 1;
		}
		
		return tileMap[j][i];
	}
	
	public int getYCoor(int yPos) {
		int x = 0;
		for(int i = 0; i < Map.HEIGHT; i += 1) {
			if(yPos < (i*Game.TILESIZE)+this.yPos) break;
			x = i;
		}
		//System.out.println((x*Game.TILESIZE)+this.yPos);
		return (x*Game.TILESIZE)+this.yPos;
	}
	
	public int getXCoor(int xPos) {
		int y = 0;
		for(int j = 0; j < Map.WIDTH; j += 1) {
			if(xPos < (j*Game.TILESIZE)+this.xPos) break;
			y = j;
		}
		//System.out.println((y*Game.TILESIZE)+this.xPos);
		return (y*Game.TILESIZE)+this.xPos;
	}
	
	public void render(Graphics g){
		for(int i=0; i<Map.HEIGHT; i+=1){
			for(int j=0; j<Map.WIDTH; j+=1){
				if(tileMap[i][j] == Map.BORDER_TOP){
					g.drawImage(top_img, (j*Game.TILESIZE)+xPos, (i*Game.TILESIZE)+yPos, null);
				}
				if(tileMap[i][j] == Map.BORDER_LEFT){
					g.drawImage(left_img, (j*Game.TILESIZE)+xPos, (i*Game.TILESIZE)+yPos, null);
				}
				if(tileMap[i][j] == Map.BORDER_RIGHT){
					g.drawImage(right_img, (j*Game.TILESIZE)+xPos, (i*Game.TILESIZE)+yPos, null);
				}
				if(tileMap[i][j] == Map.BORDER_BOTTOM){
					g.drawImage(bottom_img, (j*Game.TILESIZE)+xPos, (i*Game.TILESIZE)+yPos, null);
				}
				if(tileMap[i][j] == Map.BORDER_TOPLEFT){
					g.drawImage(topleft_img, (j*Game.TILESIZE)+xPos, (i*Game.TILESIZE)+yPos, null);
				}
				if(tileMap[i][j] == Map.BORDER_TOPRIGHT){
					g.drawImage(topright_img, (j*Game.TILESIZE)+xPos, (i*Game.TILESIZE)+yPos, null);
				}
				if(tileMap[i][j] == Map.BORDER_BOTTOMLEFT){
					g.drawImage(bottomleft_img, (j*Game.TILESIZE)+xPos, (i*Game.TILESIZE)+yPos, null);
				}
				if(tileMap[i][j] == Map.BORDER_BOTTOMRIGHT){
					g.drawImage(bottomright_img, (j*Game.TILESIZE)+xPos, (i*Game.TILESIZE)+yPos, null);
				}
				if(tileMap[i][j] == Map.GROUND){
					g.drawImage(ground_img, (j*Game.TILESIZE)+xPos, (i*Game.TILESIZE)+yPos, null);
				}
				if(tileMap[i][j] == Map.POST){
					g.drawImage(post_img, (j*Game.TILESIZE)+xPos, (i*Game.TILESIZE)+yPos, null);
				}
			}
		}
		if(!tileEvents.isEmpty()) {
			for(int i=0; i<tileEvents.size();i+=1){
				tileEvents.get(i).render(g);
			}
		}
		if(!bombsP1.isEmpty()) {
			for(int i=0; i<bombsP1.size();i+=1){
				bombsP1.get(i).render(g);
			}
		}
		if(!bombsP2.isEmpty()) {
			for(int i=0; i<bombsP2.size();i+=1){
				bombsP2.get(i).render(g);
			}
		}
		if(!walls.isEmpty()) {
			for(int i=0; i<walls.size();i+=1){
				walls.get(i).render(g);
			}
		}
		if(!pickups.isEmpty()) {
			for(int i=0; i<pickups.size();i+=1){
				pickups.get(i).render(g);
			}
		}
	}
	
	public void addPickup(int xPos, int yPos) {
		if(rand.nextInt(9) < 3) {
			pickups.add(new Pickup(xPos, yPos));
		}
	}
	
	public MapType getMapType() {
		return type;
	}
	
	public void addBomb(Bomb bomb, Player p) {
		disableMovep1 = false;
		disableMovep2 = false;
		if (p.isMayweather()){
			bombsP2.add(bomb);
		}
		else {
			bombsP1.add(bomb);
		}
	}
	
	public void addWalls() {
		for(int j = 0; j < Map.HEIGHT; j += 1) {
			for(int i = 0; i < Map.WIDTH; i += 1) {
				if(tileMap[j][i] == Map.GROUND) {
					if(j > 0 && j < 8 && i > 0 && i < 12) {
						if(!((i > 0 && i < 3) && (j > 0 && j < 3)) && !((i > 9 && i < 12) && (j > 5 && j < 8))) walls.add(new Wall((i*Game.TILESIZE)+xPos, (j*Game.TILESIZE)+yPos));
					}
				}
			}
		}
	}
	
	public boolean isWall(int x, int y) {
		if(walls.isEmpty()) {
			return false;
		} else {
			for(int i = 0; i < walls.size(); i += 1) {
				int x2 = walls.get(i).getXPos();
				int y2 = walls.get(i).getYPos();
				if(x >= x2 && x < x2+Game.TILESIZE && y >= y2 && y < y2+Game.TILESIZE) {
					return true;
				}
			}
			return false;
		}
	}
	
	public Player getPlayerAt(int x, int y) {
		int x2 = getXCoor(x);
		int y2 = getYCoor(y);
		
		int p1x = getXCoor(p1.getXPos());
		int p1y = getYCoor(p1.getYPos());
		
		int p2x = getXCoor(p2.getXPos());
		int p2y = getYCoor(p2.getYPos());
		
		if(p1x == x2 && p1y == y2) return p1;
		if(p2x == x2 && p2y == y2) return p2;
		return null;
	}
	
	public boolean isBomb(int x, int y, Player p) {
		if (!(p.isMayweather())){
			if(bombsP2.isEmpty()) {
				return false;
			} else {
				for(int i = bombsP2.size(); i > 0; i -= 1) {
					int x2 = bombsP2.get(i-1).getXPos();
					int y2 = bombsP2.get(i-1).getYPos();
					if(x >= x2 && x < x2+Game.TILESIZE && y >= y2 && y < y2+Game.TILESIZE) {
						if (disableMovep2)	return true;	
						return false;
					}
					else	
						disableMovep2 = true;
				}
			}
		} else {
			if (bombsP1.isEmpty()) {
				return false;
			} else{
				for(int i = bombsP1.size(); i > 0; i -= 1) {
					
					int x2 = bombsP1.get(i-1).getXPos();
					int y2 = bombsP1.get(i-1).getYPos();
					if(x >= x2 && x < x2+Game.TILESIZE && y >= y2 && y < y2+Game.TILESIZE) {
						if (disableMovep1)	return true; 
						return false;
					}
					else	
						disableMovep1 = true; 		
				}	
			}		
		}
		return false;
	}
	
	public boolean isBombAlready(int x, int y) {
		
		if(bombsP1.isEmpty() && bombsP2.isEmpty()) {
			return false;
		} else {
			for(int i = bombsP1.size(); i > 0; i -= 1) {
				int x2 = bombsP1.get(i-1).getXPos();
				int y2 = bombsP1.get(i-1).getYPos();
				if(x >= x2 && x < x2+Game.TILESIZE && y >= y2 && y < y2+Game.TILESIZE) 
					return true;
			}
				
			for(int i = bombsP2.size(); i > 0; i -= 1) {
				int x2 = bombsP2.get(i-1).getXPos();
				int y2 = bombsP2.get(i-1).getYPos();
				if(x >= x2 && x < x2+Game.TILESIZE && y >= y2 && y < y2+Game.TILESIZE) 
					return true;		
			}
		}
		return false;
	}
	
	public void blowBomb(int x, int y){
		for(int i = bombsP1.size(); i > 0; i -= 1) {
			int x2 = bombsP1.get(i-1).getXPos();
			int y2 = bombsP1.get(i-1).getYPos();
			if(x >= x2 && x < x2+Game.TILESIZE && y >= y2 && y < y2+Game.TILESIZE){
				tileEvents.add(new ExplodeBomb(this, bombsP1.get(i-1).getXPos(), bombsP1.get(i-1).getYPos(), bombsP1.get(i-1).getRange()));
				bombsP1.remove(i-1);
				p1.bombExploded();
			}
		}
		
		for(int i = bombsP2.size(); i > 0; i -= 1) {
			int x2 = bombsP2.get(i-1).getXPos();
			int y2 = bombsP2.get(i-1).getYPos();
			if(x >= x2 && x < x2+Game.TILESIZE && y >= y2 && y < y2+Game.TILESIZE){
				tileEvents.add(new ExplodeBomb(this, bombsP2.get(i-1).getXPos(), bombsP2.get(i-1).getYPos(), bombsP2.get(i-1).getRange()));
				bombsP2.remove(i-1);
				p2.bombExploded();
			}
		}
	}
	
	
	public Wall getWallAt(int x, int y) {
		int index = 0;
		for(int i = 0; i < walls.size(); i += 1) {
			int x2 = walls.get(i).getXPos();
			int y2 = walls.get(i).getYPos();
			if(x >= x2 && x < x2+Game.TILESIZE && y >= y2 && y < y2+Game.TILESIZE) {
				index = i;
				break;
			}
		}
		return walls.get(index);
	}
	
	public List<Wall> getWalls() {
		return walls;
	}
	
	
	public void update() {
		if(!tileEvents.isEmpty()) {
			for(int i = 0; i < tileEvents.size(); i += 1) {
				tileEvents.get(i).update();
				if(tileEvents.get(i).getCounter() == 50) {
					tileEvents.remove(i);
				}
			}
		}
		if(!bombsP1.isEmpty()) {
			for(int i=0; i<bombsP1.size();i+=1){
				bombsP1.get(i).update();
				if(bombsP1.get(i).getCounter() >= 150) {
					tileEvents.add(new ExplodeBomb(this, bombsP1.get(i).getXPos(), bombsP1.get(i).getYPos(), bombsP1.get(i).getRange()));
					bombsP1.remove(i);
					Sounds.playExplosion();
					p1.bombExploded();
				}
			}
		}
		if(!bombsP2.isEmpty()) {
			for(int i=0; i<bombsP2.size();i+=1){
				bombsP2.get(i).update();
				if(bombsP2.get(i).getCounter() >= 150) {
					tileEvents.add(new ExplodeBomb(this, bombsP2.get(i).getXPos(), bombsP2.get(i).getYPos(), bombsP2.get(i).getRange()));
					bombsP2.remove(i);
					Sounds.playExplosion();
					p2.bombExploded();
				}
			}
		}
		int px, py, x1, y1, x2, y2;
		if(!pickups.isEmpty()) {
			for(int i=0; i<pickups.size();i+=1){
				px = pickups.get(i).getXPos();
				py = pickups.get(i).getYPos();
				x1 = getXCoor(p1.getXPos());
				x2 = getXCoor(p2.getXPos());
				y1 = getYCoor(p1.getYPos());
				y2 = getYCoor(p2.getYPos());
				if(px == x1 && py == y1) {
					pickups.get(i).pickup(p1);
					pickups.remove(i);
				}
				if(px == x2 && py == y2) {
					pickups.get(i).pickup(p2);
					pickups.remove(i);
				}
			}
		}
	}
}