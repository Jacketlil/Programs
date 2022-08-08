/*
 *Jacky Li
 *2022/2/1
 *Bullet class 
 */
package ShootingGame;

import java.awt.Graphics;
import java.awt.Image;
import java.io.InputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Bullet {

	//variables
	double x1, y1;
	
	double speedX, speedY;
	
	//bullet acceleration
	double v1per, v2per;
	
	static double width = 10;
	
	static double height = width;
	
	//Constructor
	String filename = "laser bullet.png";

	Image imgPlayerBullet = loadImage(filename);
	
	//constructor
	public Bullet () {
		
	}
	
	//player bullet generator
	public Bullet (double x1, double y1) {
		this.x1 = x1;
		this.y1 = y1;
		
		v1per = 10;
		v2per = 10;
	}
	
	//enemy bullet
	void enemyBullet (double x1, double y1) {
		this.x1 = x1;
		this.y1 = y1;
		
		v1per = 5;
		v2per = 5;
	}
	
	//enemy shooting
	void shooting() {
		x1 += speedX;
		y1 += speedY;
	}
	
	Image loadImage(String filename) {
		Image image = null;

		URL imageURL = this.getClass().getResource("/" + filename);

		InputStream inputStr = ShootingGame.class.getClassLoader().getResourceAsStream(filename);

		if (imageURL != null) {
			ImageIcon icon = new ImageIcon(imageURL);
			image = icon.getImage();
		} else {
			JOptionPane.showMessageDialog(null, "An image failed to load: " + filename, "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}

		return image;
	}
	
	//enemy bullets
	public void paintEnemyBulletImg(Graphics g) {
		g.fillOval((int)x1, (int)y1, (int)width, (int)height);
	}
	
	//player bullets
	public void paintPlayerBulletImg(Graphics g) {

		int imgW = imgPlayerBullet.getWidth(null);
		int imgH = imgPlayerBullet.getHeight(null);

		g.drawImage(imgPlayerBullet, (int) x1, (int) y1, (int) (x1 + width), (int) (y1 + height), 0, 0, imgW, imgH, null);
//		g.drawRect((int) x1, (int) y1, (int) width, (int) height);
	}
	
	
}
