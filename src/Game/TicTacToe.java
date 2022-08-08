/*
 * Jacky Li
 * 2021/11/15
 */
package Game;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/***********************************************
 This is the skeleton for a TicTacToe game using Swing.

 Look over this and see if you have any questions so far.

 We're going to start with just the graphics part.
 But we're also going to store the data. The data will be stored as a grid 
 or 2D array of integers. 

 For TicTacToe, it make sense to have empty = 0, and then X and O be +/- 1
 We'll see why later.
 */

public class TicTacToe {

	//CONSTANTS
	final static int GRID = 3;		//size of board & grid
	/*** you can set this to any size, but the winning only works for the top 3x3 corner ***/


	final static Color COLOURGRID = new Color(140, 140,140);	
	final static Color COLOURBACK = new Color(240, 240, 240);

	final static int XX = 1;
	final static int OO = -1;
	final static int EMPTY = 0;

	//GLOBAL VARIABLES
	boolean turnX = true;
	int loci, locj;
	int[][] board = new int [GRID][GRID];
	JFrame frame;

	
	//boolean noGameWinner to check whether there is already a winner produced
	boolean noGameWinner = true;

	public static void main(String[] args) {
		new TicTacToe();
	}

	TicTacToe() {	
		initGame();		
		createAndShowGUI();
	}

	//This will reset the board if you want to play again.
	//It will be called from the method that checks if you win. If the game is over, reset and then play again
	void initGame() {		
		//TBA		
	}

	void createAndShowGUI() {
		frame = new JFrame("TicTacToe");			
		Container content = frame.getContentPane();
		content.setBackground(Color.BLUE);
		content.setLayout(new BorderLayout(2,2));

		//setup top label & panel						


		//make main panel
		DrawingPanel gridPanel = new DrawingPanel();
		content.add(gridPanel, BorderLayout.CENTER);

		//finish setting up the frame
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize(500, 450);		
		frame.setLocationRelativeTo(null);  //must be AFTER setSize		
		frame.setVisible(true);

		//Once the panel is visible, initialize the graphics. 
		//*** This is no longer needed here since it's at the beginning of paintComponent()
		//gridPanel.initGraphics();

	}

	void printBoard() {
		for(int row=0; row<GRID; row++) {
			for(int col=0; col<GRID; col++){
				System.out.printf("%3d", board[row][col]);
			}
			System.out.println();
		}
		//System.out.println("=========="); //print out dividing line of the correct length
		for (int i = 0; i < GRID*3 +2; i++) System.out.print("=");System.out.println();		
	}

	private class DrawingPanel extends JPanel implements MouseListener{

		//instance variables
		int jpanW, jpanH;	//size of JPanel
		int boxW, boxH;	//size of each square		

		//** Because the panel size variables don't get initialized until the panel is displayed,
		//** we can't do a lot of graphics initialization here in the constructor.
		DrawingPanel() {
			this.addMouseListener(this);
			setBackground(COLOURBACK);
		}

		//** WAS called by createAndShowGUI(), now from paintComponent()
		void initGraphics() {
			jpanW = this.getSize().width;		
			jpanH = this.getSize().height;	

			boxW = jpanW/GRID;
			boxH = jpanH/GRID;
		}

		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g); //needed for background colour to paint
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			initGraphics(); //needed if the window is resized.

			for (int i = 0 ; i<GRID ; i++) {
				g2.drawLine(0, i*boxH, jpanW, i*boxH);
				g2.drawLine(i*boxW, jpanW, i*boxW, 0);
			}
			g.setColor(COLOURGRID);			



			//TODO draw all X and Os
			g2.setStroke(new BasicStroke(4));

			//Check every square in board[][] and draw an X or O there.
			for (int r = 0; r<GRID ; r++) {
				for(int c = 0; c<GRID ; c++) {
					if(board[r][c]==XX) {
						g2.drawLine(c*boxW+10, r*boxH+10, (c+1)*boxW-10, (r+1)*boxH-10);
						g2.drawLine(c*boxW+10, (r+1)*boxH-10, (c+1)*boxW-10, r*boxH+10);
					}

					if(board[r][c] == OO) {
						g2.drawOval(c*boxW+10, r*boxH+10, boxW-20, boxH-20);
					}
				}
			}

			//Try and resize the window while playing. Everything works. 
			g.setColor(Color.RED);
			g2.setStroke(new BasicStroke(2));


		}

		//******************* MouseListener methods *****************//
		@Override
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			boolean filled = true;


			//calculate which square you clicked on
			loci = x/boxW;
			locj = y/boxH;

			//TODO display mouse coords and grid square in title.
			//how to check if click right mouse button


			//button3 restart the game
			if (e.getButton() == MouseEvent.BUTTON3) {
				for (int p = 0; p<GRID; p++) {
					for(int l = 0; l<GRID; l++) {
						board[p][l]=0;
					}
				}
				noGameWinner = true;
				turnX = true;
				frame.setTitle("TicTacToe");
				this.repaint();
				printBoard();
				return;
			}

			//make sure whether the game is restarted
		

			//change turn if statement (if x turn)
			if (turnX) { 
				//make sure the xo don't change if there are more than one clicks
				if(noGameWinner) {
					if(board[locj][loci]!=EMPTY) {
						board[locj][loci] += 0;
					}
					//TODO change turn
					else {
						board[locj][loci] = XX;
						turnX = !turnX;
					}
				}
			}

			//if o turns
			else {
				//make sure the xo don't change if there are more than one clicks
				if(noGameWinner) {
					if(board[locj][loci]!=EMPTY) {
						board[locj][loci] += 0;
					}
					//change turns
					else {
						board[locj][loci] = OO;
						turnX = !turnX;
					}
				}
			}

			//TODO check for the winner
			for(int i = 0 ; i<GRID; i++) {
				//x wins
				if(board[i][0]+board[i][1]+board[i][2]==3 || //check horizontally
						board[0][i]+board[1][i]+board[2][i]==3 || //check vertically
						board[0][0]+board[1][1]+board[2][2]==3 || //check diagonal
						board[2][0]+board[1][1]+board[0][2]==3) { 
					//if there is already a winner, no changes in the result
					frame.setTitle("X wins");
					noGameWinner = false;

				}
				//o wins
				if(board[i][0]+board[i][1]+board[i][2]==-3 || // check horizontally
						board[0][i]+board[1][i]+board[2][i]==-3 ||  //check vertically
						board[0][0]+board[1][1]+board[2][2]==-3 || //check diagonal
						board[2][0]+board[1][1]+board[0][2]==-3) {
					//if there is already a winner, no changes in the result
					frame.setTitle("O wins");
					noGameWinner = false;

				}
			}

			//TODO Check if the square is empty
			for (int p = 0; p<GRID; p++) {
				for(int l = 0; l<GRID; l++) {
					//if statement to check whether every array has a value
					if(board[p][l]==0) {
						filled = false;
					}
				}
			}

			//TODO check for tie
			//if it is already filled and no winner existed, result is tie
			if(filled) {
				//if there is already a winner, no changes in the result
					frame.setTitle("Tie");
			}


			//TODO update board




			this.repaint();
			printBoard();
		}	

		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}

	} //end of DrawingPanel class

}