package FInalProject_Game;

import java.awt.Graphics;

class Obstacle {

	double x1, y1;
	
	double width = 30;
	
	double height;
	
	double upyEnd, lowyStart;
	
	private double gap = 200;
	
	int random = (int)(Math.random()*(Game.PANH-gap-25)+25);
	
	public Obstacle (double x1, double y1){
		this.x1 = x1;
		this.y1 = y1;
	}
	
	public void paint(Graphics g) {
		if(x1+width<0) {
			x1=Game.PANW;
			random = (int)(Math.random()*170+20);
		}
		height = random;
		
		upyEnd = random;
		lowyStart = gap + random;
		g.fillRect((int)x1, (int)y1, (int)width, random);
		g.fillRect((int)x1, (int)y1 + random + (int)gap , (int)width, Game.PANH-(int)gap -  random);
		
	}
}
