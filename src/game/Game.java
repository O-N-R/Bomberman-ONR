package game;

import game.maps.Map;
import game.panels.AboutPanel;
import game.panels.GamePanel;
import game.panels.HelpPanel;
import game.panels.SetupPanel;
import game.panels.TitlePanel;
import game.panels.WinnerPanel;
import game.resources.Images;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game implements Runnable {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "Bomberman: Fight of the Century";
	public static final int TILESIZE = 50;

	private JFrame frame;
	private CardLayout cl;
	private TitlePanel title;
	private SetupPanel setup;
	private GamePanel game;
	private AboutPanel about;
	private HelpPanel help;
	private WinnerPanel win;
	
	private Map map;
	
	private Thread thread;
	private boolean running;
	
	public Game() {
		init();
		start();
	}
	
	private void init() {
		Images.load();
		
		frame = new JFrame(Game.TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		Container c = frame.getContentPane();
		c.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		
		cl = new CardLayout();
		c.setLayout(cl);
		
		map = new Map(76, 101);
		
		title = new TitlePanel(this);
		setup = new SetupPanel(this);
		game = new GamePanel(this);
		about = new AboutPanel(this);
		help = new HelpPanel(this);
		win = new WinnerPanel();
		
		c.add(title, "title");
		c.add(setup, "setup");
		c.add(game, "game");
		c.add(about, "about");
		c.add(help, "help");
		c.add(win, "win");
		
		cl.show(c, "title");
		
		thread = new Thread(this);
		this.running = false;
		
		
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public JFrame getFrame() {
		return this.frame;
	}

	@Override
	public void run() {
		double target = 1000000000 / 60;
		long last = System.nanoTime();
		long start;
		double elapsed = 0;
			
		while(running) {
			start = System.nanoTime();
			elapsed += (start - last) / target;
			last = start;
			
			if(elapsed >= 1) {
				game.update();
				game.repaint();
				elapsed -= 1;
			}
		}
	}
	
	public void start() {
		if(!running) {
			this.running = true;
			thread.start();
		}
	}
	
	public void stop() {
		if(running) {
			this.running = false;
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public WinnerPanel getWinnerPanel() {
		return win;
	}
	
	public Map getMap() {
		return map;
	}
	
	public GamePanel getGamePanel() {
		return game;
	}
	
}
