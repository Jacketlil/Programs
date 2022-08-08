/*
 * Jacky, Bassem
 * 2022/2/1
 * Obstacle class
 */
package ShootingGame;

import java.awt.Graphics;
import java.awt.Image;
import java.io.InputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Obstacle {
	//variables
	double x, y, width, height;    
    
	String obstacle1Filename = "Obstacle1.jpg";
	
	String obstacle2Filename = "Obstacle2.jpg";
	
	String obstacle3Filename = "Obstacle3.jpg";
	
	Image imgObstacle1 = loadImage(obstacle1Filename);
	
	Image imgObstacle2 = loadImage(obstacle2Filename);
	
	Image imgObstacle3 = loadImage(obstacle3Filename);
	
    // constructor
    public Obstacle (double x, double y , double width, double height){
    	this.x = x;
    	this.y = y;
    	this.width = width;
    	this.height = height;
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
	public void paintImg(Graphics g, int n) {
		
		Image img;
		if(n==0) {
			img = imgObstacle1;
		}
		else if(n==1){
			img = imgObstacle2;
		}
		else {
			img = imgObstacle3;
		}
		
		int imgW = img.getWidth(null);
		int imgH = img.getHeight(null);
		
		g.drawImage(img, (int)x, (int)y, (int)(x+width), (int)(y+height),   
					0, 0, imgW, imgH, null);
		g.drawRect((int)x, (int)y, (int)width, (int)height);
	}
	
}