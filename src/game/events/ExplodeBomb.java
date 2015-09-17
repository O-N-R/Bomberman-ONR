package game.events;

import game.Game;
import game.entities.Player;
import game.entities.Wall;
import game.maps.Map;
import game.resources.Images;
import game.resources.Sounds;

import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

public class ExplodeBomb extends TileEvent {

	private Map map;
	private int range, counterUp, counterDown, counterLeft, counterRight;
	
	public ExplodeBomb(Map map, int xPos, int yPos, int range) {
		super(xPos, yPos);
		this.range = range;
		this.map = map;
		
		Player p;
		List<Wall> walls = map.getWalls();
		p = map.getPlayerAt(xPos, yPos);
		Sounds.playExplosion();
		if(p != null) {
			p.decreaseLife();
			Sounds.playDeath();
			p.respawn();
		}
		
		Wall wall;
		boolean disableUp = false, disableDown = false, disableLeft = false, disableRight = false;
		for(int i = 1; i <= range; i += 1) {
			
			if(map.getTileAt(xPos+1, yPos-(i*Game.TILESIZE)+1) == Map.POST)		disableUp = true;

			if ((xPos+1) > 726 || (yPos+(i*Game.TILESIZE)+1) > 550)	{}
			else if(map.getTileAt(xPos+1, yPos+(i*Game.TILESIZE)+1) == Map.POST)	disableDown = true;

			if(map.getTileAt(xPos-(i*Game.TILESIZE)+1, yPos+1) == Map.POST)		disableLeft = true;
			
			if ((xPos+(i*Game.TILESIZE)+1) > 726 || (yPos+1) > 550){}
			else if(map.getTileAt(xPos+(i*Game.TILESIZE)+1, yPos+1) == Map.POST)	disableRight = true;

			
			
			if (!disableUp){
				if(map.isWall(xPos, yPos-(i*Game.TILESIZE))) { //up
					wall = map.getWallAt(xPos, yPos-(i*Game.TILESIZE));
					walls.remove(wall);
					map.addPickup(wall.getXPos(), wall.getYPos());
					map.addGround(new Point(wall.getXPos(), wall.getYPos()));
					counterUp = i;
					disableUp = true;
				} else {
					p = map.getPlayerAt(xPos, yPos-(i*Game.TILESIZE));
					if(p != null) {
						p.decreaseLife();
						Sounds.playDeath();
						p.respawn();
					}
				}
				if (map.isBombAlready(xPos, yPos-(i*Game.TILESIZE))){
					map.blowBomb(xPos, yPos-(i*Game.TILESIZE));
				}
			}
			if (!disableDown){
				if(map.isWall(xPos, yPos+(i*Game.TILESIZE))) { //down
					wall = map.getWallAt(xPos, yPos+(i*Game.TILESIZE));
					walls.remove(wall);
					map.addPickup(wall.getXPos(), wall.getYPos());
					map.addGround(new Point(wall.getXPos(), wall.getYPos()));
					counterDown = i;
					disableDown = true;
				} else {
					p = map.getPlayerAt(xPos, yPos+(i*Game.TILESIZE));
					if(p != null) {
						p.decreaseLife();
						Sounds.playDeath();
						p.respawn();
					}
				}
				/*if (map.isBombAlready(xPos, yPos+(i*Game.TILESIZE))){
					map.blowBomb(xPos, yPos+(i*Game.TILESIZE));
				}*/
			}
			if (!disableLeft){
				if(map.isWall(xPos-(i*Game.TILESIZE), yPos)) { //left
					wall = map.getWallAt(xPos-(i*Game.TILESIZE), yPos);
					walls.remove(wall);
					map.addPickup(wall.getXPos(), wall.getYPos());
					map.addGround(new Point(wall.getXPos(), wall.getYPos()));
					counterLeft = i;
					disableLeft = true;
				} else {
					p = map.getPlayerAt(xPos-(i*Game.TILESIZE), yPos);
					if(p != null) {
						p.decreaseLife();
						Sounds.playDeath();
						p.respawn();
					}
				}
				/*if (map.isBombAlready(xPos-(i*Game.TILESIZE), yPos)){
					map.blowBomb(xPos-(i*Game.TILESIZE), yPos);
				}*/
			}
			if (!disableRight){
				if(map.isWall(xPos+(i*Game.TILESIZE), yPos)) { //right
					wall = map.getWallAt(xPos+(i*Game.TILESIZE), yPos);
					walls.remove(wall);
					map.addPickup(wall.getXPos(), wall.getYPos());
					map.addGround(new Point(wall.getXPos(), wall.getYPos()));
					counterRight = i;
					disableRight = true;
				} else {
					p = map.getPlayerAt(xPos+(i*Game.TILESIZE), yPos);
					if(p != null) {
						p.decreaseLife();
						Sounds.playDeath();
						p.respawn();
					}
				}
				if (map.isBombAlready(xPos+(i*Game.TILESIZE), yPos)){
					map.blowBomb(xPos+(i*Game.TILESIZE), yPos);
				}
			}
			
			/*p = map.getPlayerAt(xPos, yPos-(i*Game.TILESIZE));
			if(p != null) {
				p.decreaseLife();
				Sounds.playDeath();
				p.respawn();
			}
			p = map.getPlayerAt(xPos, yPos+(i*Game.TILESIZE));
			if(p != null) {
				p.decreaseLife();
				Sounds.playDeath();
				p.respawn();
			}
			p = map.getPlayerAt(xPos-(i*Game.TILESIZE), yPos);
			if(p != null) {
				p.decreaseLife();
				Sounds.playDeath();
				p.respawn();
			}
			p = map.getPlayerAt(xPos+(i*Game.TILESIZE), yPos);
			if(p != null) {
				p.decreaseLife();
				Sounds.playDeath();
				p.respawn();
			}*/
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Images.MID_EXPLODE, xPos, yPos, null);
		boolean disableUp = false, disableDown = false, disableLeft = false, disableRight = false;
		
		for(int i = 1; i <= range; i += 1) {
			
			if(map.getTileAt(xPos+1, yPos-(i*Game.TILESIZE)+1) == Map.POST)		disableUp = true;

			if ((xPos+1) > 726 || (yPos+(i*Game.TILESIZE)+1) > 550) 	disableDown = true;
			else if(map.getTileAt(xPos+1, yPos+(i*Game.TILESIZE)+1) == Map.POST)	disableDown = true;
			
			if(map.getTileAt(xPos-(i*Game.TILESIZE)+1, yPos+1) == Map.POST)		disableLeft = true;
			
			if ((xPos+(i*Game.TILESIZE)+1) > 726 || (yPos+1) > 550) disableRight = true;
			else if(map.getTileAt(xPos+(i*Game.TILESIZE)+1, yPos+1) == Map.POST)	disableRight = true;
				
		
			
			
			if (!disableUp){
				if (counterUp == i) 	disableUp = true;
				if(map.getTileAt(xPos+1, yPos-(i*Game.TILESIZE)+1) == Map.GROUND) { //up
					g.drawImage(Images.UD_EXPLODE, xPos, yPos-(i*Game.TILESIZE)-1, null);
				}
			}
			if (!disableDown){
				if (counterDown == i) 	disableDown = true;
				if(map.getTileAt(xPos+1, yPos+(i*Game.TILESIZE)+1) == Map.GROUND) { //down					
					g.drawImage(Images.UD_EXPLODE, xPos, yPos+(i*Game.TILESIZE)+1, null);					
				}
			}
			if (!disableLeft){
				if (counterLeft == i)		disableLeft = true;
				if(map.getTileAt(xPos-(i*Game.TILESIZE)+1, yPos+1) == Map.GROUND) { //left	
					g.drawImage(Images.LR_EXPLODE, xPos-(i*Game.TILESIZE)+1, yPos, null);					
				}
			}
			if (!disableRight){
				if (counterRight == i)	disableRight = true;
				if(map.getTileAt(xPos+(i*Game.TILESIZE)+1, yPos+1) == Map.GROUND) { //right				
					g.drawImage(Images.LR_EXPLODE, xPos+(i*Game.TILESIZE)+1, yPos, null);				
				}
			}
		}
	}	
}
