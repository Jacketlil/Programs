package Graphics;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class FlowLayout1 {

	public static void main(String[] args) {
		new FlowLayout1(); //this will run the constructor
	}
	
	JFrame window;
	
	FlowLayout1(){
		window = new JFrame("Flow Layout");
		window.setSize(400,300);
		
		//closing the window should end the program
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.cyan);
		
		//JPanel default to FlowLayout
		for ( int i = 0; i < 10 ; i++) {
		panel.add(new JButton("HELLO"));
		}
		
		
		window.add(panel);
	
		//the last thing you do (normally)
		window.setVisible(true);
		
		
	}
}
