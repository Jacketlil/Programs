package Graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Event1 {

	public static void main(String[] args) {
		new Event1();
	}
	
	JFrame window;
	JPanel panel;
	
	Event1(){
		window = new JFrame ("Event Demo");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set up JPanel
		panel = new JPanel();
		JButton button = new JButton("Yes");
		panel.add(button);
		button.addActionListener(new MyAL()); //step 1 and 3
		button.addActionListener(new OtherAL());
		
		
		window.add(panel);
		
		window.setVisible(true);
	}
	
	//inner class
	//step2 "Implements../" means "use the interface..."
	class MyAL implements ActionListener{
		int numClicks = 0;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//change background color
			panel.setBackground(Color.red);
			
			numClicks++;
		}
	}
	class OtherAL implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			window.setTitle(":)");
		}
	}

}