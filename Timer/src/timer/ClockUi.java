package timer;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.*;

public class ClockUi extends JFrame {
	TimeCounter tc;
	Timer timer = new Timer();
	int min, sec;
	int milli = 0;
	JButton restart = new JButton();
	JPanel main = new JPanel();
	JLabel newLabel = new JLabel();
	
	public ClockUi(){
		this.setSize(400, 300);
		newLabel.setText("00:00");
		newLabel.setFont(new Font(newLabel.getName(),Font.PLAIN,150));
		restart.setText("Start");
		
		restart.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (!tc.cancel()){
					tc.cancel();
				}
				milli = setTime();
				tc = new TimeCounter(milli);
				tc.setSizeLabel(150);
				start();
				restart.setText("Restart");
				main.remove(1);
				main.add(tc.getTimeLabel(),BorderLayout.CENTER);
				
			}
			
		});
		tc = new TimeCounter(0);
		main.setLayout(new BorderLayout());
		main.add(restart,BorderLayout.NORTH);
		main.add(newLabel,BorderLayout.CENTER);
		
		this.add(main);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void start(){
		timer.schedule(tc, 0, 1000);
	}
	public int setTime(){
		min = Integer.parseInt(JOptionPane.showInputDialog("Input Minute:"));
		sec = Integer.parseInt(JOptionPane.showInputDialog("Input Second:"));
		return ((min*60)+sec)*1000;
	}
}
