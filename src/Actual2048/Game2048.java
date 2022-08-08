//package Actual2048;
//
//import java.awt.Container;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Color;
//
//import java.awt.RenderingHints;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.BasicStroke;
//import java.awt.BorderLayout;
//
//
//public class Game2048 implements KeyListener{
//
//
//	//constants
//	final static int GRID = 4;
//
//	int[] [] board = new int [GRID][GRID];
//	JFrame frame = new JFrame("2048");
//
//	DrawingPanel gridPanel = new DrawingPanel();
//
//	boolean dispose = false;
//
//	public static void main(String[] args) {
//		new Game2048();
//	}
//
//	Game2048(){
//		createAndShowGUI();
//	}
//
//
//	void createAndShowGUI() {
//		Container content = frame.getContentPane();
//		content.setLayout(new BorderLayout(2,2));
//
//
//		content.add(gridPanel, BorderLayout.CENTER);
//
//
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(500,500);
//		frame.setLocationRelativeTo(null);
//		frame.addKeyListener(this);
//		frame.setVisible(true);
//
//	}
//
//
//	private class DrawingPanel extends JPanel{
//
//		Graphics g;
//		//instance variables
//		int jpanW, jpanH;	//size of JPanel
//		int boxW, boxH;	//size of each square
//
//		int loci, locj;
//
//
//		DrawingPanel(){
//
//		}
//
//
//		void initGraphics() {
//			jpanW = this.getSize().width;		
//			jpanH = this.getSize().height;	
//
//			boxW = jpanW/GRID;
//			boxH = jpanH/GRID;
//		}
//
//		void generateBoxes() {
//			int loci = (int)(Math.random()*4);
//			int locj = (int)(Math.random()*4);
//
//			while(board[loci][locj]!=0) {
//				loci = (int)(Math.random()*4);
//				locj = (int)(Math.random()*4);
//			}
//
//
//			board[loci][locj] = 2;
//			frame.setTitle(loci + " " + locj);
//
//		}
//
//		//		void printValues(Graphics g) {
//		//			for (int r = 0; r<GRID ; r++) {
//		//				for(int c = 0; c<GRID ; c++) {
//		//					if(board[r][c]!=0) {
//		//						g.setFont(new Font ("TimesRoman", Font.BOLD, 24));
//		//						g.drawString(""+board[r][c], r*boxW+boxW/2, c*boxH+boxH/2);
//		//					}
//		//				}
//		//			}
//		//		}
//
//		@Override
//		public void paintComponent(Graphics g){
//			super.paintComponent(g); //needed for background colour to paint
//			Graphics2D g2 = (Graphics2D) g;
//			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//			g.setColor(Color.BLACK);
//			g2.setStroke(new BasicStroke(4));
//			initGraphics();
//
//
//			for (int i = 0 ; i<GRID ; i++) {
//				g2.drawLine(0, i*boxH, jpanW, i*boxH);
//				g2.drawLine(i*boxW, jpanW, i*boxW, 0);
//			}
//
//
//
//			g.setColor(Color.red);
//			g2.setStroke(new BasicStroke(1));
//
//			//			generateBoxes(g);
//
//			board[2][2] = 2;
//
//
//			for (int r = 0; r<GRID ; r++) {
//				for(int c = 0; c<GRID ; c++) {
//					if(board[r][c]!=0) {
//						g2.setFont(new Font ("TimesRoman", Font.BOLD, 24));
//						if(dispose) {
//							g2.dispose();
//							dispose = false;
//						}
//						g2.drawString(""+board[r][c], r*boxW+boxW/2, c*boxH+boxH/2);
//					}
//				}
//
//			}
//
//
//		}
//
//
//
//	}
//
//
//	@Override
//	public void keyTyped(KeyEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void keyPressed(KeyEvent e) {
//		if(e.getKeyCode() == KeyEvent.VK_UP) {
//			for (int r = 0; r<GRID ; r++) {
//				for(int c = 0; c<GRID ; c++) {
//					int i = c;
//					if(board[r][c]!=0 && i-1 >=0 && board[r][i-1]==0) {
//						board[r][i-1] = board[r][i];
//						board[r][i] = 0;
//					}
//				}
//			}
//
//			dispose = true;
//			gridPanel.repaint();
//
//		}
//
//
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//}
