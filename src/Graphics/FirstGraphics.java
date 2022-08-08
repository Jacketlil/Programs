package Graphics;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class FirstGraphics {

	public static void main(String[] args) {
		new FirstGraphics (); //this will run the constructor
	}
	
	JFrame window;
	
	FirstGraphics(){
		window = new JFrame("I love Chicken");
		window.setSize(800,600);
		
		//closing the window should end the program
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.cyan);
		panel.add(new JLabel("Welcome!"));
		JButton btnl = new JButton("Okay");
		
		panel.add(btnl);
		
		window.add(panel);
	
		//the last thing you do (normally)
		window.setVisible(true);
		
		
	}
}
