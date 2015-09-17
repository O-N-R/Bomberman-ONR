package game.events;

import java.awt.Graphics;

public abstract class TileEvent {
	
	protected int xPos;
	protected int yPos;
	protected int counter;
	
	public TileEvent(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.counter = 0;
	}
	
	public abstract void render(Graphics g);
	
	public void update() {
		counter += 1;
	}
	
	public int getCounter() {
		return counter;
	}
	
}
