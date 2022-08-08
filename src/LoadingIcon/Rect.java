/*
 * Jacky Li
 * 2021/11/16
 * Rectangle object class
 */
package LoadingIcon;
import java.awt.Graphics;


public class Rect {
	
	//private variables
	private double x2, y2;
	
	//these variables cannot be declared as private
	//since they will be changed when it comes to move rectangles horizontally and vertically
	double x1, y1;

	public Rect (double x1, double y1, double x2, double y2){
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;

	}

	//method to paint the rectangle on the graphics context
	public void paint(Graphics g) {
		g.drawRect((int)x1, (int)y1, (int)x2, (int)y2);
	}

}