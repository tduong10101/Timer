package timer;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.util.TimerTask;

public class TimeCounter extends TimerTask {
	private int totalTime = 0;
	private int curTime = 0;
	final int UNIT = 1000;
	private JLabel time=new JLabel();
	public TimeCounter(int totalTime){
		this.totalTime = totalTime;
		this.curTime = totalTime;
	}

	public int getCurTime(){
		return curTime;
	}
	public int getTotalTime(){
		return totalTime;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		time.setText(militariTime ());
		curTime=curTime-UNIT;
	    if (curTime<0){
	    	this.cancel();
	    	JOptionPane.showMessageDialog(null, "Count Down is ended!");	    	
	    }
	}
	public String militariTime (){
		int min = curTime/(UNIT*60);
		int sec = (curTime-(min*UNIT*60))/UNIT;
		return String.format("%02d:%02d\n",min,sec);
	}
	public JLabel getTimeLabel(){
		return time;
	}
	public void setSizeLabel(int size){
		time.setFont(new Font(time.getName(), Font.PLAIN,size));
	}
}
	
	
	

