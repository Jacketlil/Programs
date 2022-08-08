package Drawing;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.*;
public class FirstDrawing {

	public static void main(String[] args) {
		new FirstDrawing();
	}

	int panW = 800, panH = 800;
	FirstDrawing(){
		//setup JFrame
		JFrame window = new JFrame("Drawing on JPanel");

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DrawingPanel panel = new DrawingPanel();
		window.add(panel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

	class DrawingPanel extends JPanel{

		DrawingPanel(){
			this.setPreferredSize(new Dimension(panW, panH));
			this.setBackground(Color.red);
		}
	
		@Override
		public void paintComponent (Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.yellow);
			g.fillRect(10, 10, 100, 100);
		}
	
	}
}