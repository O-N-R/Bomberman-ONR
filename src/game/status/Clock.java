package game.status;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clock implements ActionListener{
	
	private int counter;
	private int minutes;
	private int seconds;
	private MatchTimer mt;
	
	public Clock(int counter, MatchTimer mt) {
		this.counter = counter;
		this.mt = mt;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		minutes = counter/60;
		seconds = counter - minutes*60;
		
		mt.update(minutes,seconds/10,seconds%10);
		if(counter == 0) {
			mt.getTimer().stop();
		}
		counter -= 1;
	}
	
	public int getCounter() {
		return counter;
	}
}
