package GraphicsLibrary.shapes;

import java.awt.Color;
import java.awt.Graphics2D;

import GraphicsLibrary.Drawable;
/**
 *@author Jason Barnaba
 *Polygon class, One of many drawable shapes.
 */
public class Polygon implements Drawable {
	int[] xcoords;
	//array of Integer needed to draw polygon
	int[] ycoords;
	//array of Integer needed to draw polygon
	private boolean isFull;
	private Color color;
	private int sides;
	//important parameters used to draw the shape in the draw method.
	
	/**
	 * Constructor 1. Used for non filled objects. Takes the given parameters and initializes the object.
	 * Sets isFull to false and sets the color to black. 
	 * Generates the array of integers needed for a polygon by running a math equation to find all vertices of a polygon 
	 * @param centerX
	 * @param centerY
	 * @param radius
	 * @param numPoints
	 */
	public Polygon(double centerX, double centerY, double radius, int numPoints) {
		xcoords = new int[numPoints+1];
		ycoords = new int[numPoints+1];
		double angle = 2 * Math.PI / numPoints;
		//gets the angle of each side
		
		
		/*
		 *Goes around the polygon, getting all vertices
		 */
		for (int i = 0; i < numPoints; i++)
		{
		    double x = centerX + radius * Math.sin(i * angle);
		    xcoords[i] = ((int) (x));
		    double y = centerY + radius * Math.cos(i * angle);
		    ycoords[i] = ((int) (y));
		}
		xcoords[numPoints] = xcoords[0];
		ycoords[numPoints] = ycoords[0];
		this.isFull = false;
		this.color = Color.BLACK;
		this.sides = numPoints;
	}
	
	/**
	 * Constructor 2. Used for filled objects. Takes the given parameters and initializes the object.
	 * Sets isFull to True and sets the color to the desired color.
	 * Generates the array of integers needed for a polygon by running a math equation to find all vertices of a polygon 
	 * @param centerX
	 * @param centerY
	 * @param radius
	 * @param numPoints
	 * @param color
	 */
	public Polygon(double centerX, double centerY, double radius, int numPoints, Color color) {
		xcoords = new int[numPoints+1];
		ycoords = new int[numPoints+1];
		double angle = 2 * Math.PI / numPoints;
		//gets the angle of each side 
		
		
		/*
		 *Goes around the polygon, getting all vertices
		 */
		for (int i = 0; i < numPoints; i++)
		{
		    double x = centerX + radius * Math.sin(i * angle);
		    xcoords[i] = ((int) (x));
		    double y = centerY + radius * Math.cos(i * angle);
		    ycoords[i] = ((int) (y));
		}
		xcoords[numPoints] = xcoords[0];
		ycoords[numPoints] = ycoords[0];
		this.isFull = true;
		this.color = color;
		this.sides = numPoints;
	}
	
	
	/**
	 * Draw method. 
	 * Tells Graphics2D Object g to set the color, and depending whether isFull is true or false,
	 * it calls a draw or fill method.
	 */
	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		if(isFull) g.fillPolygon(xcoords, ycoords, sides);
		else g.drawPolygon(xcoords, ycoords, sides);
	}	
}
