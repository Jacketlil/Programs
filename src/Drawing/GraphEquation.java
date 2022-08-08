package Drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Drawing.FirstDrawing.DrawingPanel;

public class GraphEquation {

	
	int panW = 500, panH = 500;
	double xmin = -5.0;
	double xmax = 5.0;
	double ymin = -5.0;
	double ymax = 5.0;
	
	double xstep = (xmax-xmin)/panW;
	
	public static void main(String[] args) {
		new GraphEquation();
	}
	
	GraphEquation(){
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
			this.setBackground(Color.white);
		}
	
		@Override
		public void paintComponent (Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.black);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
			
			int px = (int)((-xmin)/(xmax-xmin) *panW);
			g.drawLine(px, 0,px, panH);
			
			int py = (int)((-ymin)/(ymax-ymin)*panH);
			g.drawLine(0, py, panW, py);
		
		for(double x =xmin; x<xmax; x+=xstep) {
			double y = x*x*x;
			g.setColor (Color.black);
			plotPt(x,y,g);
			
			y = Math.sin(x);
			g.setColor (Color.red);
			plotPt(x,y,g);
		}
		
		
	
		}
	}
		void plotPt(double x, double y, Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			int px = (int)((x-xmin)/(xmax-xmin) *panW);
			int py = (int)((y-ymin)/(ymax-ymin)*panH);
			
//			py = panH - py;
			g2.setStroke(new BasicStroke(4));
			g.drawLine(px, py, px, py);
		}
}