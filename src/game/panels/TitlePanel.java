package game.panels;

import game.Game;
import game.input.LabelButton;
import game.resources.Images;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TitlePanel extends JPanel {
	
	private LabelButton play, about, help, exit;
	
	public TitlePanel(Game game) {
		
		setLayout(new BorderLayout());
		
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
		buttons.setPreferredSize(new Dimension(150, 300));
		play = new LabelButton(game, new ImageIcon(Images.PLAY_BUTTON), new ImageIcon(Images.PLAY_BUTTON2), "play");
		play.addMouseListener(play);
		//play.setPreferredSize(new Dimension(135, 58));
		help = new LabelButton(game, new ImageIcon(Images.HELP_BUTTON), new ImageIcon(Images.HELP_BUTTON2), "help");
		help.addMouseListener(help);
		//help.setPreferredSize(new Dimension(135, 58));
		about = new LabelButton(game, new ImageIcon(Images.ABOUT_BUTTON), new ImageIcon(Images.ABOUT_BUTTON2), "about");
		about.addMouseListener(about);
		//about.setPreferredSize(new Dimension(135, 58));
		exit = new LabelButton(game, new ImageIcon(Images.EXIT_BUTTON), new ImageIcon(Images.EXIT_BUTTON2), "exit");
		exit.addMouseListener(exit);
		//exit.setPreferredSize(new Dimension(135, 58));
		
		buttons.add(play);
		buttons.add(help);
		buttons.add(about);
		buttons.add(exit);
		
		JPanel top = new JPanel();
		top.setPreferredSize(new Dimension(235, 195));
		JPanel left = new JPanel();
		left.setPreferredSize(new Dimension(300, 300));
		JPanel right = new JPanel();
		right.setPreferredSize(new Dimension(300, 300));
		JPanel bottom = new JPanel();
		bottom.setPreferredSize(new Dimension(800, 60));
		
		top.setOpaque(false);
		left.setOpaque(false);
		right.setOpaque(false);
		bottom.setOpaque(false);
		buttons.setOpaque(false);
		
		play.addMouseListener(play);
		about.addMouseListener(about);
		help.addMouseListener(help);
		exit.addMouseListener(exit);
		
		add(top, BorderLayout.NORTH);
		add(buttons, BorderLayout.CENTER);
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);
		add(bottom, BorderLayout.SOUTH);
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Images.TITLEBG, 0, 0, null);
	}

}
