package GraphicsLibrary.shapes;

import java.awt.Color;
import java.awt.Graphics2D;

import GraphicsLibrary.Drawable;
/**
 *@author Jason Barnaba
 *Triangle class, One of many drawable shapes.
 */
public class Triangle implements Drawable{
	int[] x = new int[3];
	//array of Integer needed to draw polygon
	int[] y = new int[3];
	//array of Integer needed to draw polygon
	Color color;
	Boolean filled;
	//important parameters used to draw the shape in the draw method.
	
	/**
	 * Constructor 1. Used for non filled objects. Takes the given parameters and initializes the object.
	 * Sets isFull to false and sets the color to black. 
	 * @param x1
	 * @param x2
	 * @param x3
	 * @param y1
	 * @param y2
	 * @param y3
	 */
	public Triangle(int x1, int x2, int x3, int y1, int y2, int y3) {
		x[0] = x1;
		x[1] = x2;
		x[2] = x3;
		y[0] = y1;
		y[1] = y2;
		y[2] = y3;
		this.color = Color.BLACK;
		filled = false;
	}
	
	/**
	 * Constructor 2. Used for filled objects. Takes the given parameters and initializes the object.
	 * Sets isFull to True and sets the color to the desired color.
	 * @param x1
	 * @param x2
	 * @param x3
	 * @param y1
	 * @param y2
	 * @param y3
	 * @param color
	 */
	public Triangle(int x1, int x2, int x3, int y1, int y2, int y3,Color color) {
		x[0] = x1;
		x[1] = x2;
		x[2] = x3;
		y[0] = y1;
		y[1] = y2;
		y[2] = y3;
		this.color = color;
		filled = true;
	}
	
	/**
	 * Draw method. 
	 * Tells Graphics2D Object g to set the color, and depending whether isFull is true or false,
	 * it calls a draw or fill method.
	 */
	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		if(filled) g.fillPolygon(x, y, 3);
		else g.drawPolygon(x, y, 3);
	}
	
}
