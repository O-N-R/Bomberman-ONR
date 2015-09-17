package game.status;

import game.entities.Player;
import game.resources.Images;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Lives extends JPanel {
	
	private JLabel[] p;
	private int startingLife;
	private int currentLife;
	private Player player;
	
	public Lives(Player player) {
		setPreferredSize(new Dimension(250,100));
		setBackground(Color.WHITE);
		this.player = player;

		p = new JLabel[player.getLife()];	
		for(int i=0; i<player.getLife(); i++) {
			p[i] = new JLabel(new ImageIcon(Images.LIFE_MODE1));
			add(p[i]);
		}
		
		startingLife = player.getLife();
		setOpaque(false);
	}
	
	public void update() {
		currentLife = player.getLife();
		if(startingLife > currentLife) {
			for(int i = 0; i < startingLife; i += 1) {
				remove(p[i]);
			}
			for(int i = 0; i < currentLife; i += 1) {
				add(p[i]);
			}
		} 
	}
}
