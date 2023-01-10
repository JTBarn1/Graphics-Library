package GraphicsLibrary;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;




/**
 * @author Jason Barnaba
 *
 *
 *GraphicsPanel object, subclass of JPanel. 
 *Handles drawing all of the drawable objects in the arrayList shapes.
 */
public class GraphicsPanel extends JPanel{
	ArrayList<Drawable> shapes = new ArrayList<Drawable>();
	//Initializes an empty ArrayList of Objects with the Drawable interface
	
	
	
	/**
	 *Override of the paintComponent method, used to draw the shapes to the
	 *screen's graphics
	 *Runs a for each loop for the ArrayList and runs each of their draw methods.
	 *@param g2
	 */
	@Override
	protected void paintComponent(Graphics g2) {
		super.paintComponent(g2);
		//calling the superclass paintComponent method
		Graphics2D g = (Graphics2D)g2;
		/* Turning the superclass Graphics g into its subclass Graphics2D.
		 * Probably not needed since floating points aren't passed into the draw methods.
		 */
		
			
			for(Drawable shape: shapes) {
			//For each loop
				 shape.draw(g);
				 //Calling the Draw method
			}
		}
	
	
	/**
	 * UpdateShapes method. 
	 * Updates the shapes ArrayList with the Controller's arrayList
	 * @param shapes
	 */
	public void updateShapes(ArrayList<Drawable> shapes) {
		this.shapes = shapes;
		//Updating the list
		}
}
