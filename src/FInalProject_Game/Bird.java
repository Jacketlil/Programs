package FInalProject_Game;

import java.awt.Graphics;

class Bird {

	int x, y, width, height;
	double vyDrop = 1;
	
	Bird(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		width = w;
		height = h;
	}
	
	public void paint(Graphics g) {
		g.fillOval(x, y, width, height);
	}
}
