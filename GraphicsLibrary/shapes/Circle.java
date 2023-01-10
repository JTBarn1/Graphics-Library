package GraphicsLibrary.shapes;

import java.awt.Color;
import java.awt.Graphics2D;

import GraphicsLibrary.Drawable;
/**
 * 
 * @author Jason Barnaba
 *Circle class, One of many drawable shapes.
 */
public class Circle implements Drawable {
	private int x,y,length;
	private boolean isFull;
	private Color color;
	//important parameters used to draw the shape in the draw method.
	
	
	/**
	 * Constructor 1. Used for non filled objects. Takes the given parameters and initializes the object.
	 * Sets isFull to false and sets the color to black. 
	 * @param x
	 * @param y
	 * @param radius
	 */
	public Circle(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.length = radius;
		this.isFull = false;
		this.color = Color.BLACK;
	}
	/**
	 * Constructor 2. Used for filled objects. Takes the given parameters and initializes the object.
	 * Sets isFull to True and sets the color to the desired color.
	 * @param x
	 * @param y
	 * @param radius
	 * @param color
	 */
	public Circle(int x, int y, int radius, Color color) {
		this.x = x;
		this.y = y;
		this.length = radius;
		this.isFull = true;
		this.color = color;
	}
	
	
	/**
	 * Draw method. 
	 * Tells Graphics2D Object g to set the color, and depending whether isFull is true or false,
	 * it calls a draw or fill method.
	 */
	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		if(isFull)g.fillOval(x, y, length, length);
		else g.drawOval(x, y, length, length);
	}
}
