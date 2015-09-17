package game.panels;

import game.Game;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WinnerPanel extends JPanel {

	private Image bg;
	
	public WinnerPanel() {
		super();
		setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
	}
	
	public void setWinner(Image bg) {
		this.bg = bg;
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);
	}

}
