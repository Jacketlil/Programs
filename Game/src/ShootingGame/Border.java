/*
 * Jacky Li
 * 2022/2/1
 * Border class
 */
package ShootingGame;

import java.awt.Graphics;
import java.awt.Image;
import java.io.InputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Border {

	//variables
	static double x1,  y1;
	
	static double width, height;
	
	//string name to find the image
	String filename = "image0.jpg";
	
	Image imgBackground = loadImage(filename);
	
	//constructor
	public Border (double x, double y, double x2, double y2) {
		x1 = x;
		y1 = y;
		width = x2;
		height = y2;
	}
	
	//load image method
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
	
	//paint method
	public void paint(Graphics g) {
		
		int imgW = imgBackground.getWidth(null);
		int imgH = imgBackground.getHeight(null);
		
		g.drawImage(imgBackground, (int)x1, (int)y1, (int)(x1+width), (int)(y1+height),   
					0, 0, imgW, imgH, null);
		g.drawRect((int)x1, (int)y1, (int)width, (int)height);
	}
	
}
