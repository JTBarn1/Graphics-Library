package GraphicsLibrary.shapes;

import java.awt.Color;
import java.awt.Graphics2D;

import GraphicsLibrary.Drawable;
/**
 * @author Jason Barnaba
 *Rectangle class, One of many drawable shapes.
 */
public class Rectangle implements Drawable {
	private int x,y,length,width;
	private boolean isFull;
	private Color color;
	//important parameters used to draw the shape in the draw method.
	
	
	/**
	 * Constructor 1. Used for non filled objects. Takes the given parameters and initializes the object.
	 * Sets isFull to false and sets the color to black. 
	 * @param x
	 * @param y
	 * @param length
	 * @param width
	 */
	public Rectangle(int x, int y, int length, int width) {
		this.x = x;
		this.y = y;
		this.isFull = false;
		this.color = Color.black;
		this.length = length;
		this.width = width;
	}
	
	
	/**
	 * Constructor 2. Used for filled objects. Takes the given parameters and initializes the object.
	 * Sets isFull to True and sets the color to the desired color.
	 * @param x
	 * @param y
	 * @param length
	 * @param width
	 * @param color
	 */
	public Rectangle(int x, int y, int length,int width, Color color) {
		this.x = x;
		this.y = y;
		this.length = length;
		this.width = width;
		isFull = true;
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
		if(isFull)g.fillRect(x,y,length,width);
		else g.drawRect(x,y,length,width);
	}
}