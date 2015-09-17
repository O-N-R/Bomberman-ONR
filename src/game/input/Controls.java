package game.input;

import game.entities.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controls implements KeyListener {

	private Player p1;
	private Player p2;
	
	public Controls(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_C) {
			p1.dropBomb();
		}
		if(code == KeyEvent.VK_M) {
			p2.dropBomb();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		//p1 controls
		if(code == KeyEvent.VK_W) {
			p1.setUp(true);
		}
		if(code == KeyEvent.VK_S) {
			p1.setDown(true);
		}
		if(code == KeyEvent.VK_A) {
			p1.setLeft(true);
		}
		if(code == KeyEvent.VK_D) {
			p1.setRight(true);
		}
		//p2 controls
		if(code == KeyEvent.VK_UP) {
			p2.setUp(true);
		}
		if(code == KeyEvent.VK_DOWN) {
			p2.setDown(true);
		}
		if(code == KeyEvent.VK_LEFT) {
			p2.setLeft(true);
		}
		if(code == KeyEvent.VK_RIGHT) {
			p2.setRight(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W) {
			p1.setUp(false);
		}
		if(code == KeyEvent.VK_S) {
			p1.setDown(false);
		}
		if(code == KeyEvent.VK_A) {
			p1.setLeft(false);
		}
		if(code == KeyEvent.VK_D) {
			p1.setRight(false);
		}
		if(code == KeyEvent.VK_C) {
			p1.dropBomb();
		}
		//p2 controls
		if(code == KeyEvent.VK_UP) {
			p2.setUp(false);
		}
		if(code == KeyEvent.VK_DOWN) {
			p2.setDown(false);
		}
		if(code == KeyEvent.VK_LEFT) {
			p2.setLeft(false);
		}
		if(code == KeyEvent.VK_RIGHT) {
			p2.setRight(false);
		}
		if(code == KeyEvent.VK_M) {
			p2.dropBomb();
		}
	
	}

}
