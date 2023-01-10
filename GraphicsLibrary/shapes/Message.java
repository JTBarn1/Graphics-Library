package GraphicsLibrary.shapes;

import java.awt.Font;
import java.awt.Graphics2D;

import GraphicsLibrary.Drawable;
/**
 *@author Jason Barnaba
 *Message class, One of many drawable Objects.
 */
public class Message implements Drawable{
	private int x,y,size;
	private String message;
	//important parameters used to draw the Image in the draw method.
	
	
	/**
	 * Constructor method. Takes the given parameters and initializes the object.
	 * @param x
	 * @param y
	 * @param size
	 * @param string
	 */
	public Message(int x, int y, int size,String string) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.message =string;
	}
	
	
	/**
	 * Draw method. 
	 * Tells Graphics2D Object g draw an image with given parameters
	 */
	@Override
	public void draw(Graphics2D g) {
		Font a = new Font("Arial",15,size);
		g.setFont(a);
		g.drawString(message, x, y);
	}

	
}
