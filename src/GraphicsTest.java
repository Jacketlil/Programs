import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JButton;


public class GraphicsTest implements ActionListener{

	public static void main(String[] args) {
		new GraphicsTest();
	}

	static final int PANW = 300;
	static final int PANH = 100;

	DrawingPanel panelBall = new DrawingPanel();
	Ball ball = new Ball (30,30,40,40);

	JPanel panelButtons= new JPanel();
	JButton reverseBtn = new JButton("Reverse");
	JButton pauseResumeBtn = new JButton("Pause");

	Timer timer;


	class Ball {
		//only add this line in if you do NOT extend Rectangle
		int x, y, width, height;
		int vx = 3;

		Ball(int x, int y, int w, int h) {
			this.x = x;
			this.y = y;
			width=w;
			height = h;
		}
	}


	GraphicsTest(){
		//setup Jframe
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	

		panelBall.setBackground(Color.black);

		frame.setTitle("Moving Ball");
		frame.add(panelBall, BorderLayout.NORTH);

		reverseBtn.addActionListener(new MyAL());
		pauseResumeBtn.addActionListener(new MyAL());

		panelButtons.add(pauseResumeBtn);
		panelButtons.add(reverseBtn);

		panelButtons.setBackground(Color.white);

		frame.add(panelButtons, BorderLayout.SOUTH);

		frame.pack(); //let panel set the size
		frame.setLocationRelativeTo(null);  
		frame.setVisible(true);

		timer = new Timer(10,this);
		timer.start();
	}


	class DrawingPanel extends JPanel {
		DrawingPanel() {
			this.setPreferredSize(new Dimension (PANW, PANH));
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			g.setColor(Color.white);
			g.fillOval(ball.x, ball.y, ball.width, ball.height);
		}
	}

	void ballMove() {
		ball.x += ball.vx;

		if (ball.vx > 0 && ball.x > PANW ) {
			ball.x = -ball.width;
		}

		if(ball.vx < 0 && ball.x+ball.width < 0 ) {
			ball.x = PANW;
		}
	}

	//Timer ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		ballMove();
		panelBall.repaint();
	}

	//buttons actionListener
	class MyAL implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Reverse")){
				ball.vx = -ball.vx;
			}

			if(e.getActionCommand().equals("Pause")) {
				timer.stop();
				pauseResumeBtn.setText("Resume");
			}

			if(e.getActionCommand().equals("Resume")) {
				timer.restart();
				pauseResumeBtn.setText("Pause");
			}
		}
	}

}
