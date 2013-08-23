package timer;

import java.util.Timer;

import javax.swing.*;

public class ClockUi extends JFrame {
	TimeCounter tc;
	Timer timer = new Timer();
	
	public ClockUi(){
		this.setSize(400, 300);
		
		int min = Integer.parseInt(JOptionPane.showInputDialog("Input Minute:"));
		int sec = Integer.parseInt(JOptionPane.showInputDialog("Input Second:"));
		int milli = ((min*60)+sec)*1000;
		tc = new TimeCounter(milli);
		tc.setSizeLabel(150);
		timer.schedule(tc, 0, 1000);
		this.add(tc.getTimeLabel());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
