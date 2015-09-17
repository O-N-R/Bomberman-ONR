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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



@SuppressWarnings("serial")
public class HelpPanel extends JPanel {
	
	private LabelButton back;
	
	public HelpPanel(Game game) {
		setLayout(new BorderLayout());
		
		JPanel top = new JPanel();
		top.setPreferredSize(new Dimension(800, 25));
		top.setOpaque(false);
		JPanel left = new JPanel();
		left.setPreferredSize(new Dimension(125, 500));
		left.setOpaque(false);
		JPanel right = new JPanel();
		right.setPreferredSize(new Dimension(125, 500));
		JPanel bottom = new JPanel();
		right.setOpaque(false);
		bottom.setPreferredSize(new Dimension(800, 77));
		bottom.setOpaque(false);
		
		JPanel gameGuide = new JPanel();
		JLabel guide = new JLabel(new ImageIcon(Images.GAMEGUIDE));
		JScrollPane jScrollPane = new JScrollPane(gameGuide);
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		gameGuide.setLayout(new FlowLayout());
		gameGuide.add(guide);
	
		back = new LabelButton(game, new ImageIcon(Images.BACK), new ImageIcon(Images.BACK2), "back");
		back.addMouseListener(back);
		
		bottom.add(back);
		
		add(top, BorderLayout.NORTH);
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);
		add(jScrollPane, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawImage(Images.HELP_BG, 0, 0, null);
	}
	
}
