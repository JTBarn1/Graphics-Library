package GraphicsLibrary.shapes;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import GraphicsLibrary.Drawable;
/**
 *@author Jason Barnaba
 *Picture class, One of many drawable shapes.
 */
public class Picture implements Drawable{
	private int x,y,width,height;
	private Image image;
	//important parameters used to draw the Image in the draw method.
	
	
	/**
	 * Constructor method. Takes the given parameters and initializes the object.
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param image
	 */
	public Picture(int x, int y,int width, int height, Image image) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
	}
	
	
	/**
	 * Draw method. 
	 * Tells Graphics2D Object g draw an image with given parameters
	 */
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(image, x, y, width, height, null);
	}

}
