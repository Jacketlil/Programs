package FInalProject_Game;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener{

	public static void main(String[] args) {
		new Game();
	}

	static final int PANW = 500;
	static final int PANH = 300;

	DrawingPanel panelGame = new DrawingPanel();

	Bird bird = new Bird(30, 150, 40, 40);

	Obstacle obsta[] = new Obstacle[5];

	boolean shapeChange = false;

	boolean gameOver = false;

	int score = 0;
	
	int passedGaps = 0;
	
	Timer timer;

	JFrame frame;
	
	Game(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Flappy Bird");
		frame.add(panelGame,BorderLayout.CENTER);
		frame.addKeyListener(this);



		for (int i = 0 ; i < obsta.length ; i++) {
			obsta[i] = new Obstacle(PANW + 100*i, 0);
		}


		frame.setLocationRelativeTo(null);
		frame.setSize(PANW, PANH);
		frame.pack();
		frame.setVisible(true);


		timer = new Timer(10, new TimerAL());
		//		timer.start();

	}


	private class TimerAL implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			if(!gameOver) {
				birdDrop();
				obstaMove();
			}
			
//			countScores();
			
			panelGame.repaint();
		}
	}

	class DrawingPanel extends JPanel{
		DrawingPanel() {
			this.setBackground(Color.white);
			this.setPreferredSize(new Dimension(PANW, PANH));
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			g.setColor(Color.black);
			bird.paint(g);
			//			g.drawLine(0,0,PANW,PANH);
			for(int i = 0 ; i < obsta.length ; i++) {
				obsta[i].paint(g);
			}

			endGame();

		}

	}

//	void countScores() {
//		for ( int i = 0 ; i < obsta.length ; i++) {
//			if(bird.x > obsta[i].x1 + obsta[i].width) {
//				score++;
//			}
////		}
//		
//		
//	}
	void endGame() {
		if(bird.y + bird.height > PANH) {
			timer.stop();
			frame.setTitle("Game Over" + " " + score);
			gameOver = true;
		}
		for(int i = 0 ; i < obsta.length ; i++) {
			if(bird.x+bird.width >= obsta[i].x1 && bird.y <= obsta[i].height 
					&& bird.x <= obsta[i].x1+obsta[i].width) {
				timer.stop();
				frame.setTitle("Game Over" + " " + score);
				gameOver = true;
			}


			if(bird.x+bird.width >= obsta[i].x1 && bird.y+bird.height >= obsta[i].lowyStart
					&& bird.x <= obsta[i].x1+obsta[i].width) {
				timer.stop();
				frame.setTitle("Game Over" + " " + score);
				gameOver = true;
			}

		}
	}

	void birdDrop() {
		bird.vyDrop += 0.25;

		bird.y += bird.vyDrop;
		if(shapeChange && bird.vyDrop > -1) {
			bird.height *= 2;
			shapeChange = !shapeChange;
		}
	}

	void birdArise() {
		if(!shapeChange) {
			bird.height = bird.height / 2;
		}
		shapeChange= true;
		bird.vyDrop = -4;

	}

	void obstaMove() {


		for(int i = 0 ; i < obsta.length ; i++) {
			obsta[i].x1--;
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == 'w' && timer.isRunning()) {
			timer.stop();
		}
		else {
			timer.restart();
		}

		if(e.getKeyChar() == ' ') {
			timer.start();
		}

		if (!gameOver) {
		birdArise();
		}
		
		panelGame.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}




}
