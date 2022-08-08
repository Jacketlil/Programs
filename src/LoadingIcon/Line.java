/*
 * Jacky Li
 * 2021/11/16
 * Line object class
 */
package LoadingIcon;
import java.awt.Graphics;

public class Line {
	
	//private variables
	private double x1, x2, y1, y2;

	public Line (double x1, double y1, double x2, double y2){
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;

	}


	//method to print out the line
	public void paint(Graphics g) {
		g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
	}

}