package game.panels;

import game.Game;
import game.entities.Player;
import game.input.Controls;
import game.maps.Map;
import game.resources.Images;
import game.status.Lives;
import game.status.MatchTimer;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	private Game game;
	private Map map;
	private Player p1;
	private Lives p1Lives;
	private Player p2;
	private Lives p2Lives;
	
	private MatchTimer mt;
	
	public GamePanel(Game game) {
		this.game = game;
		init();
	}
	
	private void init(){
		map = game.getMap();
		setLayout(new BorderLayout());
		JPanel top = new JPanel();

		top.setPreferredSize(new Dimension(800,100));
		top.setOpaque(false);
		p1 = new Player(map, 128, 152, false);
		p2 = new Player(map, 646, 452, true);
		
		map.setP1(p1);
		map.setP2(p2);
		
		p1Lives = new Lives(p1);
		p2Lives = new Lives(p2);
		
		mt = new MatchTimer(180);
		top.add(p1Lives);
		top.add(mt);
		top.add(p2Lives);
		
		add(top, BorderLayout.NORTH);
		
		setFocusable(true);
		addKeyListener(new Controls(p1, p2));
	}
	
	public MatchTimer getMatchTimer() {
		return mt;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		switch(map.getMapType()) {
			case BOXING:
				g.drawImage(Images.AUDIENCE1_1, 0, 100, null);
				g.drawImage(Images.AUDIENCE1_2, 726, 100, null);
				g.drawImage(Images.BOTTOMBORDER_1, 0, 551, null);
				g.drawImage(Images.TOP_MODE1, 0, 0, null);
				break;
			case GARDEN:
				g.drawImage(Images.AUDIENCE3_1, 0, 100, null);
				g.drawImage(Images.AUDIENCE3_2, 726, 100, null);
				g.drawImage(Images.BOTTOMBORDER_3, 0, 551, null);
				g.drawImage(Images.TOP_MODE3, 0, 0, null);
				break;
			case PAN:
				g.drawImage(Images.AUDIENCE2_1, 0, 100, null);
				g.drawImage(Images.AUDIENCE2_2, 726, 100, null);
				g.drawImage(Images.BOTTOMBORDER_2, 0, 551, null);
				g.drawImage(Images.TOP_MODE2, 0, 0, null);
				break;
		}
		map.render(g);
		p1.render(g);
		p2.render(g);
		p1Lives.repaint();
		p2Lives.repaint();
	}
	
	public void update() {
		if(mt.isFinished()) {
			int life1 = p1.getLife();
			int life2 = p2.getLife();
			if(life1 == life2 || life2 > life1) {
				game.getWinnerPanel().setWinner(Images.WINNER_P2);
			} else {
				game.getWinnerPanel().setWinner(Images.WINNER_P1);
			}
			Container c = game.getFrame().getContentPane();
			CardLayout cl = (CardLayout) c.getLayout();
			cl.show(c, "win");
		}
		if(p1.isDead() || p2.isDead()) {
			Container c = game.getFrame().getContentPane();
			CardLayout cl = (CardLayout) c.getLayout();
			if(p2.isDead()) game.getWinnerPanel().setWinner(Images.WINNER_P1);
			else game.getWinnerPanel().setWinner(Images.WINNER_P2);
			cl.show(c, "win");
		}
		map.update();
		p1.update();
		p2.update();
		p1Lives.update();
		p2Lives.update();
	}
}
