package game.input;

import game.Game;
import game.maps.Map;
import game.maps.MapType;
import game.panels.GamePanel;
import game.resources.Sounds;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class LabelButton extends JLabel implements MouseListener {
	
	private Icon original;
	private Icon hover;
	private String name;
	private Game game;
	private Map map;
	private static Random rand = new Random();
	
	public LabelButton(Game game, Icon original, Icon hover, String name){
		super(original);
		this.hover = hover;
		this.original = original;
		this.name = name;
		this.game = game;
	}
	
	public LabelButton(Game game, Map map, Icon original, Icon hover, String name) {
		super(original);
		this.hover = hover;
		this.original = original;
		this.name = name;
		this.game = game;
		this.map = map;
	}

	@Override
	public void mouseClicked(MouseEvent e) { 
		if (name.equals("startButton")){
			Container c = game.getFrame().getContentPane();
			CardLayout cl = (CardLayout) c.getLayout();
			cl.show(c, "game");
			GamePanel gamePanel = game.getGamePanel();
			gamePanel.requestFocusInWindow();
			gamePanel.getMatchTimer().start();
			Sounds.playSelect();
		}
		
		if (name.equals("back")){
			Container c = game.getFrame().getContentPane();
			CardLayout cl = (CardLayout) c.getLayout();
			cl.show(c, "title");
			Sounds.playSelect();
		}
		
		if (name.equals("play")){
			Container c = game.getFrame().getContentPane();
			CardLayout cl = (CardLayout) c.getLayout();
			cl.show(c, "setup");
			Sounds.playSelect();
		}
		if (name.equals("help")){
			Container c = game.getFrame().getContentPane();
			CardLayout cl = (CardLayout) c.getLayout();
			cl.show(c, "help");
			Sounds.playSelect();
		}
		if (name.equals("about")){
			Container c = game.getFrame().getContentPane();
			CardLayout cl = (CardLayout) c.getLayout();
			cl.show(c, "about");
			Sounds.playSelect();
		}
		if (name.equals("exit")){
			JFrame frame = game.getFrame();
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			Sounds.playSelect();
		}
		if (name.equals("mode1")){
			map.setMapType(MapType.BOXING);
			Sounds.playSelect();	
		}
		if (name.equals("mode2")){
			map.setMapType(MapType.PAN);
			Sounds.playSelect();
		}
		if (name.equals("mode3")){
			map.setMapType(MapType.GARDEN);
			Sounds.playSelect();
		}
		if (name.equals("random")){
			int randMap = rand.nextInt(3);
			if (randMap == 0) map.setMapType(MapType.BOXING);
			else if (randMap == 1) map.setMapType(MapType.PAN);
			else map.setMapType(MapType.GARDEN);
			Sounds.playSelect();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(hover);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(original);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//setIcon(hover);
	}

}
