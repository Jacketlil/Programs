package Image;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class DrawAndScaleImage extends JFrame{

	public static void main(String[] args) {
		new DrawAndScaleImage();
	}

	//This could be a BufferedImage
	BufferedImage imgFish;

	DrawAndScaleImage(){	

		this.setTitle("Drawing images");
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		JPanel grpanel = new GrPanel();
		grpanel.setBackground(new Color(20,50,100));

		String filename =  "fish.jpeg"; //this is in a resource folder		
		imgFish = loadImage(filename);

		this.add(grpanel,BorderLayout.CENTER);
		this.setVisible(true);
	}


	private class GrPanel extends JPanel {
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.WHITE);
			if (imgFish == null) return;

			//it turns out that the fish image is 204x204
			int fishW = imgFish.getWidth(null);	
			int fishH = imgFish.getHeight(null);							

			//g.drawImage(imgFish, 0,0, null); //this would draw the fish at the top, left corner

			//Draw the fish at the right middle of the screen, normal size:
			g.drawImage(imgFish, 380, 50, fishW, fishH, null);
			g.drawString("Original image", 400, 45);
			g.drawString(String.format("Size is %sx%s",fishW,fishH), 400,70+fishH);

			//Flip the fish sideways:
			//if (image != null) g.drawImage(image, 100, 0, 0, 100,this); //does not work to flip the image

			//Only use the left half of the fish for the image
			//and flip it horizontally, and space it 15px from the top corner 	
			int spc = 15;
			g.drawImage(imgFish, 100+spc, 0+spc, 0+spc, 100+spc, //destination: (100,0), to (0,100). ie. x goes from 100 to 0 (so it's flipped right to left)
					0, 0, fishW/2,fishH, null); 

			//Middle two fish. ABout half normal size. 
			//(1) upright				
			g.drawImage(imgFish, 200, 100, 300, 200,    0, 0, fishW, fishH, null); //y goes from 100 to 200 (half the size of the original)
			//(2) flipped vertically
			g.drawImage(imgFish, 200, 300, 300, 200,    0, 0, fishW, fishH, null); //y goes from 300 to 200 (half size and upside down)

		}
	}

	BufferedImage loadImage(String filename) {

		BufferedImage image = null;
		
		/* ********************************************************************************
		 *  If it's not in the resource folder use one of our other methods like this one:
		 
		image = new ImageIcon(filename).getImage();
		//System.out.println(image.getClass());
		if (image.getWidth(null) == -1) {
			image = null;
			JOptionPane.showMessageDialog(null, "An image failed to load: " + fn , "ERROR", JOptionPane.ERROR_MESSAGE);
		}	
		 
		//or this one
		try {
			image = ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null, "An image failed to load: " + fn , "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		******************************************************************************** */
		
		// Requires a / at the beginning of the filename
		URL imageURL = this.getClass().getResource("/" + filename); 

		// Filename must be relative (no / at beginning) 
		InputStream inputStr = DrawAndScaleImage.class.getClassLoader().getResourceAsStream(filename);

		//Method 1. URL using ImageIcon
		if (imageURL != null) {
			ImageIcon icon = new ImageIcon(imageURL);
			BufferedImage bim = new BufferedImage( icon.getIconWidth(), icon.getIconHeight(),  BufferedImage.TYPE_INT_ARGB);
			Graphics g = bim.createGraphics();
			icon.paintIcon(null, g, 0,0); // paint the Icon to the BufferedImage.
			g.dispose();
			image = bim;
		} else {
			JOptionPane.showMessageDialog(null, "An image failed to load: " + filename , "ERROR", JOptionPane.ERROR_MESSAGE);
		}

/*
		//2. URL using ImageIO.read 
		//Sadly the try-catch won't prevent the program from crashing with IllegalArgumentException:
		if (imageURL != null) {
			try {
				image = ImageIO.read(imageURL);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "An image failed to load: " + filename , "ERROR", JOptionPane.ERROR_MESSAGE);
		}

		//Method 3. InputStream using ImageIO.read
		if (imageURL != null) {
			try {
				image = ImageIO.read(inputStr);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "An image failed to load: " + filename , "ERROR", JOptionPane.ERROR_MESSAGE);
		}

*/
		return  image;
	}

}
