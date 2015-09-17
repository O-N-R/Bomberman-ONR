package game.panels;

import game.Game;
import game.input.LabelButton;
import game.resources.Images;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class SetupPanel extends JPanel {

	//reference to Game instance
	private Game game;
	
	private JPanel top;
	private JPanel left;
	private JPanel right;
	private JPanel start;
	private JPanel gameMode;
	private LabelButton back;
	private LabelButton mode1;
	private LabelButton mode2;
	private LabelButton mode3;
	private LabelButton random;
	private LabelButton startButton;
	
	public SetupPanel(Game g) {
		super();
		this.game = g;
		this.setLayout(new BorderLayout());
		
		this.top = new JPanel();
		this.top.setPreferredSize(new Dimension(300, 300));
		this.top.setOpaque(false);
		
		this.left = new JPanel();
		this.left.setPreferredSize(new Dimension(300, 300));
		this.left.setOpaque(false);
		this.right = new JPanel();
		this.right.setPreferredSize(new Dimension(300, 300));
		this.right.setOpaque(false);
		
		this.start = new JPanel();
		this.start.setLayout(new FlowLayout());
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(250,180));
		panel1.setOpaque(false);
		this.start.setPreferredSize(new Dimension(250,245));
		this.start.setOpaque(false);
		
		this.startButton = new LabelButton(game, new ImageIcon(Images.STARTGAME), new ImageIcon(Images.STARTGAME2), "startButton");
		this.startButton.addMouseListener(this.startButton);
		
		this.start.add(panel1);
		this.start.add(this.startButton);
		
		this.gameMode = new JPanel();
		this.gameMode.setLayout(new FlowLayout());
		this.gameMode.setPreferredSize(new Dimension(800,230));
		this.gameMode.setOpaque(false);
		
		this.mode1 = new LabelButton(game, game.getMap(), new ImageIcon(Images.MODE1), new ImageIcon(Images.MODE1_2), "mode1");
		this.mode1.addMouseListener(this.mode1);
		
		this.mode2 = new LabelButton(game, game.getMap(), new ImageIcon(Images.MODE2), new ImageIcon(Images.MODE2_2), "mode2");
		this.mode2.addMouseListener(this.mode2);
		
		this.mode3 = new LabelButton(game, game.getMap(), new ImageIcon(Images.MODE3), new ImageIcon(Images.MODE3_2), "mode3");
		this.mode3.addMouseListener(this.mode3);
		
		this.random = new LabelButton(game, game.getMap(), new ImageIcon(Images.RANDMODE), new ImageIcon(Images.RANDMODE2), "random");
		this.random.addMouseListener(this.random);
		
		this.back = new LabelButton(game, new ImageIcon(Images.BACK), new ImageIcon(Images.BACK2), "back");
		this.back.addMouseListener(this.back);
		
		this.gameMode.add(this.mode1);
		this.gameMode.add(this.mode2);
		this.gameMode.add(this.mode3);
		this.gameMode.add(this.random);
		this.gameMode.add(this.back);
		this.add(this.left, BorderLayout.WEST);
		this.add(this.right, BorderLayout.EAST);
		this.add(this.gameMode, BorderLayout.SOUTH);
		this.add(this.start, BorderLayout.CENTER);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawImage(Images.SETUPBG, 0,0, null);
	}

}
