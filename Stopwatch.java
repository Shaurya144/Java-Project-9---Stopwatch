import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class Stopwatch implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton StartButton = new JButton("START");
	JButton ResetButton = new JButton("RESET");
	JLabel TimeLabel = new JLabel();
	int ElapsedTime = 0;
	int Seconds =0;
	int Minutes =0;
	int Hours =0;
	boolean started = false;
	String SecondsString = String.format("%02d", Seconds);
	String MinutesString = String.format("%02d", Minutes);
	String HoursString = String.format("%02d", Hours);
	
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			ElapsedTime = ElapsedTime + 1000;
			Hours = (ElapsedTime / 3600000);
			Minutes = (ElapsedTime / 60000) % 60;
			Seconds = (ElapsedTime / 1000) % 60;
			SecondsString = String.format("%02d", Seconds);
			MinutesString = String.format("%02d", Minutes);
			HoursString = String.format("%02d", Hours);
			TimeLabel.setText(HoursString + ":" + MinutesString + ":" + SecondsString);
			
		}
		
	});
	
	
	
	Stopwatch(){
		
		TimeLabel.setText(HoursString + ":" + MinutesString + ":" + SecondsString);
		TimeLabel.setBounds(100,100,200,100);
		TimeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
		TimeLabel.setBorder(BorderFactory.createBevelBorder(1));
		TimeLabel.setOpaque(true);
		TimeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		StartButton.setBounds(100,200,100,50);
		StartButton.setFont(new Font("Ink Free",Font.PLAIN,20));
		StartButton.setFocusable(false);
		StartButton.addActionListener(this);
		
		ResetButton.setBounds(200,200,100,50);
		ResetButton.setFont(new Font("Ink Free",Font.PLAIN,20));
		ResetButton.setFocusable(false);
		ResetButton.addActionListener(this);
		
		frame.add(StartButton);
		frame.add(ResetButton);
		frame.add(TimeLabel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==StartButton) {
			
			if(started==false) {
				started=true;
				StartButton.setText("Stop");
				start();
			}
			else {
				started=false;
				StartButton.setText("Start");
				stop();
			}
			
		}
		if(e.getSource()==ResetButton) {
			started=false;
			StartButton.setText("Start");
			reset();
		}
		
	}
	
	
	void start() {
		timer.start();
	}
	
	
	void stop() {
		timer.stop();
	}
	
	void reset() {
		timer.stop();
		ElapsedTime=0;
		Seconds =0;
		Minutes=0;
		Hours=0;
		SecondsString = String.format("%02d", Seconds);
		MinutesString = String.format("%02d", Minutes);
		HoursString = String.format("%02d", Hours);
		TimeLabel.setText(HoursString + ":" + MinutesString + ":" + SecondsString);
	}

}
		
