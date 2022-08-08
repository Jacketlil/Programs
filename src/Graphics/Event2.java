package Graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Event2 implements ActionListener{

	public static void main(String[] args) {
		new Event2();
	}

	//global variables
	JFrame window;
	JPanel panel;
	JButton button;
	int numClicks = 0;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Exit")){
			window.dispose();
			//System.exit(0);
		}

		if (e.getSource() == button) {
			panel.setBackground(Color.red);
			numClicks++;
			window.setTitle(numClicks + " Clicks");
		}
		//change background color


	}
	Event2(){
		window = new JFrame ("Event Demo");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//set up JPanel
		panel = new JPanel();
		button = new JButton("Yes");

		JButton btnExit = new JButton("Exit \u2996");
		btnExit.setActionCommand("Exit");
		btnExit.addActionListener(this);


		button.addActionListener(this); //step 1 and 3

		panel.add(button);
		panel.add(btnExit);
		window.add(panel);

		window.setVisible(true);
	}
}