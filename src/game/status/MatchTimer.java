package game.status;

import game.resources.Images;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class MatchTimer extends JPanel {
	
	private Timer timer;
	private JLabel minutes;
	private JLabel seconds1;
	private JLabel seconds2;
	private JLabel colon;
	private Clock clock;
	private ImageIcon[] digits = new ImageIcon[10];
	
	
	public MatchTimer (int matchTime) {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(250,75));
		minutes = new JLabel();
		seconds1 = new JLabel();
		seconds2 = new JLabel();
		colon = new JLabel();
		
		add(minutes);
		add(colon);
		add(seconds1);
		add(seconds2);
		
		digits[0] = new ImageIcon(Images.DIGIT_0);
		digits[1] = new ImageIcon(Images.DIGIT_1);
		digits[2] = new ImageIcon(Images.DIGIT_2);
		digits[3] = new ImageIcon(Images.DIGIT_3);
		digits[4] = new ImageIcon(Images.DIGIT_4);
		digits[5] = new ImageIcon(Images.DIGIT_5);
		digits[6] = new ImageIcon(Images.DIGIT_6);
		digits[7] = new ImageIcon(Images.DIGIT_7);
		digits[8] = new ImageIcon(Images.DIGIT_8);
		digits[9] = new ImageIcon(Images.DIGIT_9);
		
		
		clock = new Clock(matchTime, this);
		timer = new Timer(1000, clock);
		
		setOpaque(false);
	}
	
	public void update(int m, int s1, int s2){
		colon.setIcon(new ImageIcon(Images.COLON));
		minutes.setIcon(digits[m]);
		seconds1.setIcon(digits[s1]);
		seconds2.setIcon(digits[s2]);
	}
	
	public Timer getTimer() {
		return timer;
	}
	
	public boolean isFinished() {
		if(clock.getCounter() == 0) return true;
		else return false;
	}
	
	public void start() {
		timer.start();
	}
}
