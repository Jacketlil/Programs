import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ObjectLoadingIconNoLaser implements ActionListener, KeyListener {

	final static int N = 5;

	//new and improved object-oriented code
	ArrayList<Dot> dotList = new ArrayList<>(); //dots
	ArrayList<Laser> laserList = new ArrayList<>(); //lasers

	int diameter = 18;
	double rotationRadius = (diameter/2)*5.5;
	int laserLength = 40;


	JFrame window;
	DrawingPanel panel;
	int panW = 600;
	int panH = panW;


	double laserMovement = 0;

	Color colours[] = new Color []{
			Color.decode("#ff6161"), //new color
			Color.decode("#ffb359"), //new color
			Color.decode("#fbff6a"), //new color
			Color.decode("#8bff73"), //new color
			Color.decode("#4fefff"), //new color
			Color.decode("#5494ff"), //new color
			Color.decode("#7b66ff"), //new color
			Color.decode("#ff93ff"), //new color
	};

	Color dotColour;
	Color backgroundColour = new Color(35,35,35,85);
	Timer timer;


	public static void main (String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ObjectLoadingIconNoLaser();
			}
		});
	}



	public void generateStuff() {

		//initalize dots
		for (int i = 0; i < N; i++) {
			Dot d = new Dot(0,diameter,0,0);
			dotList.add(d);
		}


		//initalize lasers
		for (int i = 0; i < N*N; i++) {
			Laser a = new Laser(laserLength,0,0,0,0,0);
			laserList.add(a);
		}


		dotColour = colours[(int)(Math.random()*colours.length)];



		//calculate angles
		int i = 0;
		for (Dot d : dotList) {
			d.angle = 360 - (360/N *i);
			//System.out.println(d.angle);
			i++;
		}


		//calculate xx and yy
		for (Dot d : dotList) {
			d.xx = panW/2 + rotationRadius*Math.sin(Math.toRadians(d.angle)) - (diameter/2);
			d.yy = panH/2 - rotationRadius*Math.cos(Math.toRadians(d.angle)) - (diameter/2);
		}

		i = 0;
		for (Laser a : laserList) {

			//			a.laserXX1 = dotList.get(i).xx;
			//			a.laserXX2 = dotList.get(i).xx;
			//			a.laserYY1 = dotList.get(i).yy;
			//			a.laserYY2 = dotList.get(i).yy;
			//a.laserYY1 = 500;
			//a.laserYY1 = dotList.get(i).yy;

			i++;
			if (i == N) {
				i = 0;
			}
		}

		for (Dot d : dotList) {
			//System.out.println(dotList.get(0).yy);
		}


	}


	ObjectLoadingIconNoLaser() {

		window = new JFrame("Loading Icon");
		panel = new DrawingPanel();
		window.add(panel);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//window.setResizable(false);
		window.addKeyListener(this);






		generateStuff();

		//timer
		timer = new Timer (15, this);
		timer.start();


		window.pack();

		//window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setVisible(true);

	}

	class DrawingPanel extends JPanel {

		DrawingPanel() {
			this.setPreferredSize(new Dimension(panW,panH));
			//this.setBackground(Color.decode("#2E2E2E"));
			this.setBackground(backgroundColour);
		}


		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			Graphics2D g2 = (Graphics2D) g;

			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON); //antialiasing



			//draw lines

			g2.setColor(Color.white);
			for (Dot d : dotList) {
				for (Dot e : dotList) {

					g2.drawLine((int)d.xx +(d.diameter/2), (int)d.yy+(d.diameter/2), (int)e.xx+(d.diameter/2), (int)e.yy+(d.diameter/2));

				}
			}


			//draw dot outlines

			for (Dot d : dotList) {
				g2.fill(new Ellipse2D.Double(d.xx-2, d.yy-2, d.diameter+4, d.diameter+4));
			}



			//lasers!

			g2.setColor(dotColour);
			g2.setStroke(new BasicStroke(6));


			if (dotList.get(0).angle <= 167) {
				for (Laser a: laserList) {

					g2.drawLine((int) a.laserXX1, 
							(int) a.laserYY1, 
							(int) a.laserXX2, 
							(int) a.laserYY2);



				}

			}
			//draw dots

			g2.setColor(dotColour);
			for (Dot d : dotList) {
				g2.fill(new Ellipse2D.Double(d.xx, d.yy, d.diameter, d.diameter));
			}




			//add numbers on top of each dot
			//for debugging purposes
//									g2.setColor(Color.black);
//									for (int j = 0; j < N; j++) {
//										g2.drawString(""+(j+1), (int)xx[j]+7, (int)yy[j]+13);
//									}
//									
//									int i = 0;
//									for (Dot d : dotList) {
//										g2.drawString(""+(i+1), (int)(d.xx + 7), (int)(d.yy + 13));
//										i++;
//									}

		}

	}


	@Override
	public void actionPerformed(ActionEvent e) {

		dotMovement();
		shootLasers();
		changeColour();

		//System.out.println(dotList.get(2).yy);
		panel.repaint();

	}

	public void dotMovement() {

		//decrease angle (starting from 360 degrees)

		for (int i = 0; i < N; i++) {
			//angle[i]--;
		}

		for (Dot d : dotList) {
			d.angle--;
		}

		//update dot positions

		int k = 0;
		//		for (int j = 0; j < N-1; j++) {
		//
		//
		//			//alternate function transformations so that some are stretched horizonally and some vertically
		//			if (j%2 == 0) {
		//				xx[j] -= 2*Math.cos(Math.toRadians(angle[j]));
		//				yy[j] -= Math.sin(Math.toRadians(angle[j]));
		//			}
		//			else {
		//				xx[j] -= Math.cos(Math.toRadians(angle[j]));
		//				yy[j] -= 2*Math.sin(Math.toRadians(angle[j]));
		//			}
		//			k++;
		//		}
		//
		//		//make last one normal (for cooler effect)
		//		xx[N-1] -= 2*Math.cos(Math.toRadians(angle[N-1]));
		//		yy[N-1] -= 2*Math.sin(Math.toRadians(angle[N-1]));		



		k = 0;
		for (Dot d : dotList) {

			if (k != N-1) {
				if (k%2 == 0) {
					d.xx -= 2*Math.cos(Math.toRadians(d.angle));
					d.yy -= Math.sin(Math.toRadians(d.angle));
				}
				else {
					d.xx -= Math.cos(Math.toRadians(d.angle));
					d.yy -= 2*Math.sin(Math.toRadians(d.angle));
				}
			}
			k++;
		}

		//make last one normal (for cooler effect)
		dotList.get(N-1).xx -= 2*Math.cos(Math.toRadians(dotList.get(N-1).angle));
		dotList.get(N-1).yy -= 2*Math.sin(Math.toRadians(dotList.get(N-1).angle));	



		//reset angles after a full rotation has taken place 
		//(makes math for other things easier)

		int i = 0;
		for (Dot d : dotList) {
			if (dotList.get(N-1).angle <= 360 - (360/N *(N-1)) - 360 ) {
				d.angle = 360 - (360/N *i);
			}
			i++;
		}




	}

	public void shootLasers() {

		//move lasers
		laserMovement += 5;

		//reset laserMovement to 0 every time it hits 167 degrees
		//this is so they can fire again every rotation
		if (dotList.get(0).angle%167 == 0) {
			laserMovement = 0;
		}





		//new and improved lasers (oh boy)

		//movement
		for (Laser a : laserList) {
			a.laserSpeed += 4;
		}

		if (dotList.get(0).angle%167 == 0) {
			for (Laser a : laserList) {
				a.laserSpeed = 0;
			}
		}

		int i = 0;
		int j = 0;
		if (dotList.get(0).angle<= 167) { //so lasers dont move at beginning of loop

			for (Laser a : laserList) {

				double slope;
				if (i == j)	 {
					slope = 0; //if i == j, that means that the program will try to calculate the slope between a dot and itself
					//in this case, the slope calculation will try to divide by zero, which produces NaN and messes up the math
					//if we don't account for this, the math down below will spit out 0 for both the x and y positions of the laser, resulting in it popping up at the top left corner of the screen
				}
				else {
					slope =  (dotList.get(j).yy - dotList.get(i).yy) / (dotList.get(j).xx - dotList.get(i).xx);

				}

				/**bottom left quadrant**/
				if (dotList.get(j).yy - dotList.get(i).yy <= 0 && dotList.get(j).xx - dotList.get(i).xx >= 0) {

					a.laserXX1 = dotList.get(i).xx + Math.abs((a.length)*Math.cos(Math.atan(slope))) + (diameter/2) + Math.abs(laserMovement*Math.cos(Math.atan(slope)));
					a.laserXX2 = dotList.get(i).xx + Math.abs(laserMovement*Math.cos(Math.atan(slope))) + (diameter/2);


					a.laserYY1 = dotList.get(i).yy - Math.abs((a.length)*Math.sin(Math.atan(slope))) + (diameter/2) - Math.abs(laserMovement*Math.sin(Math.atan(slope)));
					a.laserYY2 = dotList.get(i).yy - Math.abs(laserMovement*Math.sin(Math.atan(slope))) + (diameter/2);


				}

				/**bottom right quadrant**/
				if (dotList.get(j).yy - dotList.get(i).yy <= 0 && dotList.get(j).xx - dotList.get(i).xx <= 0) {

					a.laserXX1 = dotList.get(i).xx - Math.abs((a.length)*Math.cos(Math.atan(slope))) + (diameter/2) - Math.abs(laserMovement*Math.cos(Math.atan(slope)));
					a.laserXX2 = dotList.get(i).xx - Math.abs(laserMovement*Math.cos(Math.atan(slope))) + (diameter/2);


					a.laserYY1 = dotList.get(i).yy - Math.abs((a.length)*Math.sin(Math.atan(slope))) + (diameter/2) - laserMovement*Math.sin(Math.atan(slope));
					a.laserYY2 = dotList.get(i).yy - Math.abs(laserMovement*Math.sin(Math.atan(slope))) + (diameter/2);

				}

				/**top left quadrant**/
				if (dotList.get(j).yy - dotList.get(i).yy >= 0 && dotList.get(j).xx - dotList.get(i).xx >= 0) {

					a.laserXX1 = dotList.get(i).xx + Math.abs((a.length)*Math.cos(Math.atan(slope))) + (diameter/2) + Math.abs(laserMovement*Math.cos(Math.atan(slope)));
					a.laserXX2 = dotList.get(i).xx + Math.abs(laserMovement*Math.cos(Math.atan(slope))) + (diameter/2);


					a.laserYY1 = dotList.get(i).yy + Math.abs((a.length)*Math.sin(Math.atan(slope))) + (diameter/2) + Math.abs(laserMovement*Math.sin(Math.atan(slope)));
					a.laserYY2 = dotList.get(i).yy + Math.abs(laserMovement*Math.sin(Math.atan(slope))) + (diameter/2);

				}

				/**top right quadrant**/
				if (dotList.get(j).yy - dotList.get(i).yy >= 0 && dotList.get(j).xx - dotList.get(i).xx <= 0) {


					a.laserXX1 = dotList.get(i).xx - Math.abs((a.length)*Math.cos(Math.atan(slope))) + (diameter/2) - Math.abs(laserMovement*Math.cos(Math.atan(slope)));
					a.laserXX2 = dotList.get(i).xx - Math.abs(laserMovement*Math.cos(Math.atan(slope))) + (diameter/2);


					a.laserYY1 = dotList.get(i).yy + Math.abs((a.length)*Math.sin(Math.atan(slope))) + (diameter/2) + Math.abs(laserMovement*Math.sin(Math.atan(slope)));
					a.laserYY2 = dotList.get(i).yy + Math.abs(laserMovement*Math.sin(Math.atan(slope))) + (diameter/2);

				}

				//when slope between two dots is 0, that means it really just represents the slope between a line and itself
				//to avoid trig quirks (since cos0 = 1), just manually set the laser position to under its respective dot
				//otherwise the laser still gets drawn horizontally
				if (slope == 0) {
					a.laserXX1 = dotList.get(i).xx +(diameter/2);
					a.laserXX2 = dotList.get(i).xx + (diameter/2);
					a.laserYY1 = dotList.get(i).yy + (diameter/2);
					a.laserYY2 = dotList.get(i).yy + (diameter/2);
				}




				//System.out.println(a.laserXX1);

				j++;
				if (j == N) {
					i++;
					j = 0;
				}
			}


		}


	}

	public void changeColour() {

		//change colour every rotation
		Color temp;
		if (dotList.get(0).angle%360 == 0) {

			temp = dotColour;

			while (temp.equals(dotColour)) {
				dotColour = colours[(int)(Math.random()*colours.length)];
			}

		}


	}


	@Override
	public void keyPressed(KeyEvent e) {
		if (timer.isRunning()) {
			timer.stop();
		}
		else {
			timer.start();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
}

class Dot {
	double angle;
	int diameter;
	double xx;
	double yy;

	Dot(double angle, int diameter, double xx, double yy) {
		this.angle = angle;
		this.diameter = diameter;
		this.xx = xx;
		this.yy = yy;
	}
}

class Laser {
	double length;
	double laserSpeed;
	double laserXX1;
	double laserYY1;
	double laserXX2;
	double laserYY2;

	Laser(double length, double laserSpeed, double laserXX1, double laserYY1, double laserXX2, double laserYY2) {
		this.length = length;
		this.laserSpeed = laserSpeed;
		this.laserXX1 = laserXX1;
		this.laserYY1 = laserYY1;
		this.laserXX2 = laserXX2;
		this.laserYY2 = laserYY2;
	}
}
