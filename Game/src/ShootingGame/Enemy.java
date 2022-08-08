/*
 * Jacky Li
 * 2022/2/1
 * Enemy class
 */
package ShootingGame;

import java.awt.Graphics;
import java.awt.Image;
import java.io.InputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Enemy {

	//variables
	double x1, y1;

	static double width = 60;

	static double height = 60;

	double speedX, speedY;

	//acceleration rate
	double v1per=2;
	
	double v2per=2;

	//String variables to find the image
	String standFilename = "enemy trooper.gif";
	
	String walkFilename = "enemy trooper_walk.gif";

	Image imgStandSoilder = loadImage(standFilename);

	Image imgWalkSoilder = loadImage(walkFilename);

	double centerX, centerY;

	boolean printWalkImage = false;

	//constructor
	public Enemy() {

	}

	//Enemy declare
	void EnemyDeclare (double Xrange, double Yrange, double x, double y) {
		x1 = (double)(Math.random()*Xrange+x-width);
		y1 = (double)(Math.random()*Yrange+y-height);

		//while loop to see if the random numbers are generated in unavailable range
		//unavailable range includes out of border, generated within the obstacles
		while (x1 > Border.x1 + Border.width - 2*width && x1 < Border.x1 + 2*width) {
			x1 = (double)(Math.random()*Xrange-Math.abs(x)-width);
		}

		while (y1 > Border.y1 + Border.height - 2*height && y1 < Border.y1 + 2*height) {
			y1 = (double)(Math.random()*Yrange-Math.abs(y)-height);
		}

		for(int i = 0 ; i < ShootingGame.obstacles.size() ; i++) {
			Obstacle o = ShootingGame.obstacles.get(i);

			while(x1 + width <= o.x + o.width && x1 >= o.x && y1 + height <= o.height + o.height && y1 >= o.y) {
				x1 = (double)(Math.random()*Xrange-Math.abs(x)-width);
				y1 = (double)(Math.random()*Yrange-Math.abs(y)-height);
			}
		}
	}

	//find the center x coordinate
	void getCenterX(){
		centerX = x1 + width/2;
	}

	//find the center y coordinate
	void getCenterY() {
		centerY = y1 + height/2;
	}

	//load image
	Image loadImage(String filename) {
		Image image = null;

		URL imageURL = this.getClass().getResource("/" + filename); 

		InputStream inputStr = ShootingGame.class.getClassLoader().getResourceAsStream(filename);

		if (imageURL != null) {
			ImageIcon icon = new ImageIcon(imageURL);				
			image = icon.getImage();
		} else {
			JOptionPane.showMessageDialog(null, "An image failed to load: " + filename , "ERROR", JOptionPane.ERROR_MESSAGE);
		}

		return image;

	}

	//paint image
	public void paintImg(Graphics g) {

		int imgStandW = imgStandSoilder.getWidth(null);
		int imgStandH = imgStandSoilder.getHeight(null);
		int imgWalkW = imgWalkSoilder.getWidth(null);
		int imgWalkH = imgWalkSoilder.getHeight(null);

		if(ShootingGame.time%10==0) {
			printWalkImage = !printWalkImage;
		}

		if(printWalkImage) {
			g.drawImage(imgWalkSoilder, (int)x1, (int)y1, (int)(x1+width), (int)(y1+height),   
					0, 0, imgWalkW, imgWalkH, null);
		}
		else {
			g.drawImage(imgStandSoilder, (int)x1, (int)y1, (int)(x1+width), (int)(y1+height),   
					0, 0, imgStandW, imgStandH, null);
		}
	}

}
