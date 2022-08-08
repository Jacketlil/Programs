package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BorderLayoutExample {

	public static void main(String[] args) {
		new BorderLayoutExample();

	}
	
	BorderLayoutExample(){
		JFrame window = new JFrame ("Border Layout Example");
		window.setSize(900, 700);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelW = new JPanel();
		panelW.setBackground(Color.blue);
		panelW.add(new JLabel("West Panel"));
		window.add(panelW, BorderLayout.WEST);
		
		JPanel panelE = new JPanel();
		panelE.setBackground(Color.red);
		panelE.add(new JLabel("East Panel"));
		window.add(panelE, BorderLayout.EAST);
		
		JPanel panelN = new JPanel();
		panelN.setBackground(Color.yellow);
		panelN.add(new JLabel("North Panel"));
		window.add(panelN, BorderLayout.NORTH);
		
		JPanel panelS = new JPanel();
		panelS.setBackground(Color.green);
		panelS.add(new JLabel("South Panel"));
		window.add(panelS, BorderLayout.SOUTH);
		
		JPanel panelC = new JPanel();
		panelC.setBackground(Color.orange);
		panelC.setLayout(new GridLayout(3,2,2,3));
		
		for (int i = 0; i < 6; i++) {
			panelC.add(new JButton ("Button" + i));
		}
		window.add(panelC, BorderLayout.CENTER);
		
		
		window.setVisible(true);
		}
}
