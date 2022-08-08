/*
 * Jacky Li
 * 2021/11/16
 *  This program creates a loading icon consists of 12 rectangles, 6 rectangles are consider as one set
 *  2 sets of rectangles create a visual effect in which the first set of rectangles moves up, down, 
 *  right, left, while the other set moves upper and lower right, upper and lower left.
 *  After two sets finishing moving, they will start rotating where one set rotates in clockwise and 
 *  the other rotates in counter-clockwise. Additional lines will appear within them. After rotating 2
 *  circles, all rectangles move back to its original position and repeat the previous process.
 */
package LoadingIcon;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LoadingIcon implements KeyListener{

	public static void main(String[] args) { 
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new LoadingIcon(); 
			}
		});
	}

	//variables
	//Window stuff
	/** constant for size of JFrame */
	static final int SIZE = 500;
	/** drawing panel object that does all graphics */
	DrawingPanel mainPanel = new DrawingPanel();

	//Timer stuff
	Timer timer;
	private int t_speed = 6; //speed of timer repeats (ms)
	int t_pause = 1000;  //initial delay (ms)
	int time;       //just to display elapsed time. This should be compared with System.currentTimeMillis()

	//Size of the rectangles and related variables
	int AMOUNT = 10;

	//Rectangles coordinates stuff
	Rect rect[] = new Rect[AMOUNT];
	Rect rect1[] = new Rect[AMOUNT];

	double squareW = SIZE / 5.0;
	double squarex1 = (SIZE-squareW)/2.5;
	double squarey1 = (SIZE-squareW)/2.5;

	//Lines stuff
	Line line[] = new Line[AMOUNT];
	Line line1[] = new Line[AMOUNT];
	Line line2[] = new Line[AMOUNT];

	boolean lineAppear = false;

	//Angles declaration
	double angle[] = new double[AMOUNT];

	//Loading text coordinates and the dots behind
	String load = new String ("Loading");
	int dots = 0;
	int loadx1 = (int)(squarex1 + squareW/3);
	int loady1 = (int)(squarey1+2.5*squareW);

	//Color stuff
	int red = (int)(Math.random()*255+1);
	int green = (int)(Math.random()*255+1);
	int blue = (int)(Math.random()*255+1);

	int red1 = (int)(Math.random()*255+1);
	int green1 = (int)(Math.random()*255+1);
	int blue1 = (int)(Math.random()*255+1);

	int trans[] = new int[AMOUNT];

	//constructor
	LoadingIcon() {

		//all window stuff
		JFrame window = new JFrame("Loading Icon");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(SIZE,SIZE);

		//there have to be at least 4 rectangles to move up and down
		if(AMOUNT < 4) {
			AMOUNT = 4;
		}

		//declare variables values
		for (int x = 0; x<AMOUNT ; x++) {
			rect[x] = new Rect(squarex1, squarey1, squareW, squareW);
			rect1[x] = new Rect(squarex1, squarey1, squareW, squareW);
			line[x] = new Line(squarex1+squareW-20, squarey1+squareW-20, squarex1, squarey1);
			line1[x] = new Line(squarex1, squarey1+squareW, squarex1+squareW, squarey1);
			line2[x] = new Line(squarex1, squarey1, squarex1+squareW, squarey1+squareW);
			angle[x] = Math.toRadians(0.00);
			trans[x] = 127;
		}

		window.setLocationRelativeTo(null);
		window.addKeyListener(this);
		window.add(mainPanel);
		window.setVisible(true);

		//all timer stuff (start after window is shown)
		timer = new Timer(t_speed, new TimerAL());
		timer.setInitialDelay(t_pause);
		timer.start();
		timer.setInitialDelay(0); //if we don't do this, then restarting the timer is delayed
	}

	//methods of moving rectangles horizontally and vertically
	void movingRec() {

		//before the rectangles moving to half of their width
		//4 squares separately move up, down, left, and right

		if(time < squareW/2) {
			//first rectangle group move up, down, left, and right
			rect[0].y1++;
			rect[1].y1--;
			rect[2].x1++;
			rect[3].x1--;

			//second group move up right, up left, down right, and down left
			rect1[0].y1++;
			rect1[0].x1++;
			rect1[1].y1--;
			rect1[1].x1--;
			rect1[2].y1++;
			rect1[2].x1--;
			rect1[3].y1--;
			rect1[3].x1++;
		}

		//move all squares to its original position
		else if (time > squareW/2 && time < squareW) {
			rect[0].y1--;
			rect[1].y1++;
			rect[2].x1--;
			rect[3].x1++;

			rect1[0].y1--;
			rect1[0].x1--;
			rect1[1].y1++;
			rect1[1].x1++;
			rect1[2].y1--;
			rect1[2].x1++;
			rect1[3].y1++;
			rect1[3].x1--;
		}
	}

	//method of rotating the rectangles
	void rotatingRec() {

		//degree variable to match angle(radian) in degrees
		double degree[] = new double [AMOUNT];
		
		//additional lines should appear as the rectangles start rotating
		lineAppear = true;

		for (int i = 0 ; i < AMOUNT ; i++) {

			//transfer radians to degree to measure the exact angle
			degree[i] = Math.toDegrees(angle[i]);
			
			//to assign the moment for each rectangle to rotate
			if(time > squareW + 20 + i*(90.0/AMOUNT)) {

				//start by moving 4 degrees per unit time(as time++)
				//before the first rectangle reaches 540 degrees
				if(degree[0]<540) {
					angle[i] = angle[i] + Math.toRadians(4.0);
				}

				//after the first rectangle reaches 540 degrees, slow down the speed
				//and when each rectangles finish two full circles, stop adding angles
				if (degree[0]>540 && degree[i]<720) {
					angle[i] = angle[i] + Math.toRadians(1.0);
				}
			}
		}
	}

	//method of reseting the value
	void reset() {

		//when all the squares return to its original position, reset all values
		time = 0;
		lineAppear = false;
		for(int i = 0 ; i<AMOUNT ; i++) {
			angle[i] = Math.toRadians(0.00);
			trans[i] = 127;
		}
		red = (int)(Math.random()*255+1);
		green = (int)(Math.random()*255+1);
		blue = (int)(Math.random()*255+1);

		red1 = (int)(Math.random()*255+1);
		green1 = (int)(Math.random()*255+1);
		blue1 = (int)(Math.random()*255+1);		
	}

	//method of controlling the rate of the loading dots
	void loadingDots() {

		//change the rate of the dots within the loading text
		//every 20 units per time a dot show up
		//once the number of dots is greater than 4, reset the number to 0
		if(time%20==0) {
			if(dots<3) {
				load = load + ".";
				dots++;
			}
			else {
				load = "Loading";
				dots = 0;
			}
		}
	}


	/********************************************/
	/*  Inner class for Timer's ActionListener  */
	/********************************************/
	private class TimerAL implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			time++;

			//rate of dots appearing
			loadingDots();

			//moving rectangles vertically and horizontally
			movingRec();

			//20 units per time after the rectangles finishing moving, they start rotating
			if(time > squareW+20) {
				rotatingRec();
			}

			//when all the squares return to its original position, reset all values
			if(time> squareW + 335 +(360-360/AMOUNT)) {
				reset();
			}

			mainPanel.repaint();
		}
	}


	private class DrawingPanel extends JPanel {

		//constructor
		DrawingPanel() {
			//background color here
			this.setBackground(Color.black);
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); //clears the screen and repaints it

			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			//big for-loop to draw all rectangles and lines
			//also making lines dissapear 
			for (int i = 0; i<AMOUNT ; i++) {
				g2.setStroke(new BasicStroke(4));

				//rect[] group color
				g2.setColor(new Color(red,green,blue,127)); 

				//rotating rect[] group, counter-clockwise
				g2.rotate(-angle[i], squarex1+squareW-squareW/4, squarey1+squareW-squareW/4);
				rect[i].paint(g);
				g2.rotate(angle[i], squarex1+squareW-squareW/4, squarey1+squareW-squareW/4);

				//rect1[] group color
				g2.setColor(new Color(red1,green1,blue1,127));

				//rotating rect1[] group, clockwise
				g2.rotate(angle[i], squarex1+squareW-squareW/4, squarey1+squareW-squareW/4);
				rect1[i].paint(g);
				g2.rotate(-angle[i], squarex1+squareW-squareW/4, squarey1+squareW-squareW/4);

				//if the rectangles start to rotate, extra lines will appear within the rectangles
				if (lineAppear) {

					/*lines in rect[] group*/
					//line[] group
					g2.setColor(new Color(red,green,blue,trans[i])); //match rect[] color

					g2.rotate(-angle[i], squarex1+squareW-squareW/4, squarey1+squareW-squareW/4);
					line[i].paint(g);
					g2.rotate(angle[i], squarex1+squareW-squareW/4, squarey1+squareW-squareW/4);

					/*lines in rect1[] group*/
					//line1[] group in rect1[]
					g2.setColor(new Color(red1,green1,blue1,trans[i])); //match rect1[] group

					g2.rotate(angle[i], squarex1+squareW-squareW/4, squarey1+squareW-squareW/4);
					line1[i].paint(g);
					g2.rotate(-angle[i], squarex1+squareW-squareW/4, squarey1+squareW-squareW/4);

					//line2[] group in rect1[]
					g2.rotate(angle[i], squarex1+squareW-squareW/4, squarey1+squareW-squareW/4);
					line2[i].paint(g);
					g2.rotate(-angle[i], squarex1+squareW-squareW/4, squarey1+squareW-squareW/4);
				}


				/*if one rectangle is back to its original position(2 full circles), the corresponding line disappear*/

				//check for each angles in degree
				double check = Math.toDegrees(angle[i]);

				//if the angle reaches two full circles
				//make the line disappear by making the transparency equal to 0
				if(check>720) {
					trans[i] = 0;
				}

			}//end of the big for-loop
			

			//print the loading text
			g.setColor(Color.white);
			g.setFont(new Font ("TimesRoman", Font.BOLD, 24));
			g.drawString(load, loadx1, loady1);

			g2.dispose(); //only dispose of graphics objects that you have created
		}
	}

	//event listener for keyListener where a key is pressed to stop and start the timer
	@Override
	public void keyPressed(KeyEvent e) {
		//Press any key to pause timer
		if (timer.isRunning()) {
			timer.stop();
		} else {
			timer.restart();
		}
	}

	@Override
	public void keyReleased (KeyEvent e) {}
	@Override
	public void keyTyped    (KeyEvent e) {}

}