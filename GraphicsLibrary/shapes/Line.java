package GraphicsLibrary.shapes;

import java.awt.Graphics2D;

import GraphicsLibrary.Drawable;
/**
 *@author Jason Barnaba
 *Line class, One of many drawable Objects.
 */
public class Line implements Drawable{
	private int x1,x2,y1,y2;
	//important parameters used to draw the Image in the draw method.
	
	/**
	 * Constructor method. Takes the given parameters and initializes the object.
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public Line(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	
	/**
	 * Draw method. 
	 * Tells Graphics2D Object g draw an image with given parameters
	 */
	@Override
	public void draw(Graphics2D g) {
		g.drawLine(x1, y1, x2, y2);
	}
	
	
}
