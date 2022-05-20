package gameCode;
import javax.swing.*;

public class TimeDaub {
	private int countdown;
	private JLabel theDaub;
	
	private int onWho;
	
	private Game game;
	
	public TimeDaub(Game g, int target) {
		countdown = (int) Math.random()*4 + 3;
		theDaub = new JLabel("daub");
		game = g;
		g.allTimeDaubs.add(this);
		onWho = target;
	}
	
	public void doCountdown() {
		countdown --;
	}
	
	public int getCountdown() {
		return countdown;
	}
	
	public void rotatePlayer() {
		onWho += 1;
		if (onWho >= game.getPlayers().size()) {
			onWho = 0;
		}
	}
}
