package chess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Time {
	private JLabel label;
	Timer countdownTimer;
	int Timerem;

	public Time(JLabel passedLabel) {
		countdownTimer = new Timer(1000, new CountdownTimerListener());
		this.label = passedLabel;
		Timerem = JavaChess.timeRemaining;
	}

	public void start() {
		countdownTimer.start();
	}

	public void reset() {
		Timerem = JavaChess.timeRemaining;
	}

	class CountdownTimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int min, sec;
			if (Timerem > 0) {
				min = Timerem / 60;
				sec = Timerem % 60;
				label.setText(
						String.valueOf(min) + ":" + (sec >= 10 ? String.valueOf(sec) : "0" + String.valueOf(sec)));
				Timerem--;
			} else {
				label.setText("Time's up!");
				reset();
				start();
				JavaChess.mainBoard.changeTurn();
			}
		}
	}
}