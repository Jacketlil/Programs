/*
 * Jacky Li
 * 2021/11/30
 * This program generate a random map includes land, lake, and ocean blocks
 * MouseListener is imported where if a user clicks a empty block the program
 * will paint all surrounding empty blocks into lake or ocean blocks(if the blocks reach
 * the border of the map)
 */
package Game;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Starting class for MapContinent program

public class MapContinent
{
	public static void main(String[] args) {
		new MapContinent();
	}

	//constants	
	final static int GRID = 32; //size of grid/board
	final static int SQSIZE = 20; // size of each square in pixels
	final static int NUM_LAND = (GRID * GRID /2); //number of land tiles

	//terrain
	final static int EMPTY = 0;		//constant for empty tile. This is the terrain that needs to be a specific value (since arrays are initialized to zero)
	final static int LAND = 1;		//contant for land tile
	final static int LAKE = 33;		//this is just any number used for LAKE and OCEAN
	final static int OCEAN = 89;
	//colours: you can change these
	final static Color COLOURBACK = new Color(242,242,242);	
	final static Color COLOUREMPTY = new Color(222,222,222);
	final static Color COLOURLAND = new Color(100,200,100);
	final static Color COLOURLAKE = new Color(100,100,255);
	final static Color COLOUROCEAN = new Color(10,10,130);

	//global variables
	int[][] board = new int[GRID][GRID];

	MapContinent() {	//constructor
		initGame();
		createAndShowGUI();
	}

	//initialize the game
	void initGame() {		
		//clear board
		for (int i=0;i<GRID;i++) {
			for (int j=0;j<GRID;j++) {
				board[i][j]=EMPTY;
			}
		}

		//two methods to choice
		//makeRandomMap will generate same amount of empty space and land blocks in random orders
		//makeContinents will generate land in continents
		
		//makeRandomMap();
		makeContinents();	
	}

	//one of the method to generate continent lands
	//this method is used to generate random single land blocks using random numbers
	void makeContinents() {
		int i,j;
		i=j=0;
		board[i][j] = LAND;

		for(int row = 0; row < GRID ; row++) {
			for(int col = 0 ; col < GRID ; col++) {
				if((int)(Math.random()*100) > 90) { //using random number to decide whether the block is LAND block
					board[row][col] = LAND;
					continentLand(row, col);
				}
			}
		}
	}
	
	//the other part of the methods to generate continent lands
	//this method creates continents based on the existing blocks from makeContinents() method
	void continentLand(int x, int y) {
		if (board[x][y] == LAND) {
			// random number to decide whether the surrounding 4 blocks will be green
			int random = (int) (Math.random()*100); 
			
			//if the number is bigger than 60, then the 4 surrounding blocks will turn green
			//recursion to make the block back to this method to decide whether that block will generate its surrounding blocks
			if( x+1 < GRID && board[x+1][y] == EMPTY && random > 60) {
				board[x+1][y] = LAND;
				continentLand(x+1, y);
			}
			if( x-1 >= 0 && board[x-1][y] == EMPTY && random > 60) {
				board[x-1][y] = LAND;
				continentLand(x-1, y);
			}
			if( y+1 < GRID && board[x][y+1] == EMPTY && random > 60) {
				board[x][y+1] = LAND;
				continentLand(x, y+1);
			}
			if( y-1 >= 0  && board[x][y-1] == EMPTY && random > 60) {
				board[x][y-1] = LAND;
				continentLand(x, y-1);
			}
		}
	}
	
	//method to make random land blocks
	void makeRandomMap() {
		int i,j;
		i=j=0;
		board[i][j] = LAND;

		for(int row = 0; row < GRID ; row++) {
			for(int col = 0 ; col < GRID ; col++) {
				if((int)(Math.random()*100) > 50) { //using random number to generate random LAND blocks
					board[row][col] = LAND;
				}
			}
		}
	}

	
	//method to generate lake blocks
	void findLakes(int x, int y) {
		//call subroutine to colour in all contiguous lake squares

		//if a empty space is clicked, turned into lake
		if (board[x][y] == EMPTY) {
			board[x][y] = LAKE;
		}

		//color up all the empty spaces to COLOURLAKE
		//recursion to check each OCEAN blocks whether their surrounding block is EMPTY

		if( x+1 < GRID && board[x+1][y] == EMPTY) {
			board[x+1][y] = LAKE;
			findLakes(x+1, y);
		}
		if( x-1 >= 0 && board[x-1][y] == EMPTY) {
			board[x-1][y] = LAKE;
			findLakes(x-1, y);
		}
		if( y+1 < GRID && board[x][y+1] == EMPTY) {
			board[x][y+1] = LAKE;
			findLakes(x, y+1);
		}
		if( y-1 >= 0  && board[x][y-1] == EMPTY) {
			board[x][y-1] = LAKE;
			findLakes(x, y-1);
		}

		//if the board reaches the border, assign the array as an ocean block
		if(x == 0 || x == GRID-1 || y == 0 || y == GRID-1) {
			board[x][y] = OCEAN;
		}
		
		//put the array into findOcean method to generate ocean blocks
		findOcean(x,y);
		
	}

	//method to generate ocean blocks based on the lake blocks generated from findLakes() method
	void findOcean (int x, int y) {

		//the method will only activate if the block is OCEAN
		if ( board[x][y] == OCEAN) {

			//check surrounding blocks if they are LAKE block
			//recursion to check all LAKE blocks that touches the edge
			if( x+1 < GRID && board[x+1][y] == LAKE) {
				board[x+1][y] = OCEAN;
				findOcean(x+1, y);
			}
			if( x-1 >= 0 && board[x-1][y] == LAKE) {
				board[x-1][y] = OCEAN;
				findOcean(x-1, y);
			}
			if( y+1 < GRID && board[x][y+1] == LAKE) {
				board[x][y+1] = OCEAN;
				findOcean(x, y+1);
			}
			if( y-1 >= 0  && board[x][y-1] == LAKE) {
				board[x][y-1] = OCEAN;
				findOcean(x, y-1);
			}
		}
	}


	void createAndShowGUI() {
		DrawingPanel panel = new DrawingPanel();

		//JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Minesweeper Problem #1-4");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Container content = frame.getContentPane();
		// content.setLayout(new BorderLayout(2,2));	
		content.add(panel, BorderLayout.CENTER);		
		//frame.setSize(SCRSIZE, SCRSIZE); //may not be needed since my JPanel has a preferred size
		frame.setResizable(false);		
		frame.pack();
		frame.setLocationRelativeTo( null );
		frame.setVisible(true);

		//once the panel is visible, initialize the graphics. (Is this before paintComponent is run?)
		panel.initGraphics();

	}

	class DrawingPanel extends JPanel	//inner class
	{		
		int jpanW, jpanH;
		int blockX, blockY;		

		public DrawingPanel() {
			setBackground(COLOURBACK);
			//Because the panel size variables don't get initialized until the panel is displayed,
			//we can't do a lot of graphics initialization here in the constructor.
			this.setPreferredSize(new Dimension(GRID*SQSIZE,GRID*SQSIZE));
			MyMouseListener ml = new MyMouseListener();
			addMouseListener(ml);			
		}

		//** Called by createGUI()
		void initGraphics() {
			jpanW = this.getSize().width;		
			jpanH = this.getSize().height;	
			blockX = (int)((jpanW/GRID)+0.5);
			blockY = (int)((jpanH/GRID)+0.5);
			// System.out.println("init");
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			//Draw white grid
			g.setColor(Color.WHITE);
			for (int i=0;i<GRID;i++) {
				g.drawLine(blockX*i,0,blockX*i,jpanH);
				g.drawLine(0,blockY*i,jpanW,blockY*i);
			}

			for (int i=0;i<GRID;i++) {
				for (int j=0;j<GRID;j++) {
					colourRect(i,j,g);						
				}
			}			
		}

		void colourRect(int i, int j, Graphics g) {

			int terrain = board[i][j];

			if (terrain == EMPTY) {
				g.setColor(COLOUREMPTY);
				g.fillRect(blockX*i+1, blockY*j+1, blockX-2, blockY-2);
			}
			if (terrain == LAND) {
				g.setColor(COLOURLAND);
				g.fillRect(blockX*i+1, blockY*j+1, blockX-2, blockY-2);
			}			
			if (terrain == LAKE) {
				g.setColor(COLOURLAKE);
				g.fillRect(blockX*i+1, blockY*j+1, blockX-2, blockY-2);
			}
			if (terrain == OCEAN) {
				g.setColor(COLOUROCEAN);
				g.fillRect(blockX*i+1, blockY*j+1, blockX-2, blockY-2);
			}		
		}	

		class MyMouseListener extends MouseAdapter	{	//inner class inside DrawingPanel
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				//calculate which square you clicked on
				int i = (int)  x/blockX;
				int j = (int) y/blockY;	// blockY/y

				//allow the right mouse button to toggle/cycle the terrain
				if (e.getButton() != MouseEvent.BUTTON1) {
					switch (board[i][j]) {
					case LAND:
						board[i][j] = EMPTY;
						break;
					default:
						board[i][j] = LAND;
					}
					repaint();
					return;
				}

				findLakes(i,j);								
				repaint();
			}		
		} //end of MyMouseListener class

	} //end of DrawingPanel class

}