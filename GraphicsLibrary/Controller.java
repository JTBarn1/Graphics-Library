package GraphicsLibrary;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Timer;

import GraphicsLibrary.listeners.*;
import GraphicsLibrary.shapes.*;


/**
 * @author Jason Barnaba
 *
 */
public class Controller {
	ArrayList<Drawable> shapes = new ArrayList<Drawable>();
	//List of all shapes that need to be drawn onto the screen
	// refreshed when Wipe method called.
	Window window;
	//The window object the extends the JFrame object that The GraphicsPanel and listeners rely on
	GraphicsPanel Panel;
	//The GraphicsPanel Object that the shapes are drawn onto 
	public int mouseX = 0, mouseY = 0;
	// X any Y coordinates returned by the mouseListener each time the mouse is pressed.
	// mousePressed is used for this because mouseClicked is not a reliable method
	public char keyTyped;
	// Character that is returned by the KeyListener when a key is pressed
	// Updated every key stroke
	
	
	/**
	 * The constructor class for the controller.
	 * Creates a new window with the width, height,title,resize, and FPS parameters
	 * Creates and overrides certain Listener classes
	 * @see #mouseClick() 
	 * @see #keyType()
	 * Starts a timer that allows for a variable refresh rate
	 * @see #update()
	 * 
	 * 
	 * @param width
	 * @param height
	 * @param title
	 * @param resize
	 * @param fps
	 */
	public Controller(int width,int height, String title, Boolean resize, double fps) {
		//Creating the Window Object
		window = new Window(width, height, title, resize);
		//Creating the Timer
		Timer timer = new Timer();
		//Creating the GraphicsPanel Object
		Panel = new GraphicsPanel();
		//Adding the GraphicsPanel to the window object
		window.add(Panel);
		
		
		// Creating the mouse listener Component
		/*
		 * Overriding the mousePressed method so methods inside the Controller
		 * class can be called. Important for allowing the user to override the methods
		 * used for interacting with the Key and Mouse listeners.
		 */
		Component Mouse = new Mouse() {				
			/**
			 *Every time the mouse is pressed, the parameters mouseX and mouseY are overwritten
			 *with the mouse's current x and y position.
			 *The method mouseClick is called, which will be overwritten by the user
			 */
			@Override
			public void mousePressed(MouseEvent arg0) {
				mouseX = arg0.getX();
				//Writing over mouseX
				mouseY = arg0.getY();
				//Writing over mouseY
				mouseClick();
				//Calling mouseClick
			}
		};
		window.addMouseListener((MouseListener)Mouse);
		//Adding the mouseListener to the window
		
		
		//Creating the Key listener Component
		/*
		* Overriding the KeyTyped method so methods inside the Controller
		* class can be called. Important for allowing the user to override the methods
		* used for interacting with the Key and Mouse listeners.
		*/
		Component Key = new Key() {
			/**
			 *Every time a key is pressed, the parameter keyTyped is overwritten with the current pressed key.
			 *The method keyType is called, which will be overwritten by the user
			 */
			@Override
			public void keyTyped(KeyEvent arg0) {
				keyTyped = arg0.getKeyChar();
				//Writing over keyTyped
				keyType();
				//calling the keyType Method
			}
		};
		window.addKeyListener((KeyListener) Key);
		//Adding the key listener to the window
		
		/*
		 * Scheduling the timer to the value of 
		 * 1 divided by the number of frames in a second times one thousand
		 * Giving us the value in milliseconds that should be in between each frame
		 * 
		 * Overriding the Run method so methods inside the Controller
		 * class can be called. Important for allowing the user to override the methods
		 * used for interacting with the Key and Mouse listeners.
		 */
		timer.schedule(new FrameTask(Panel) {
			/**
			 *Every frame, this method will be called.
			 *the update function will be called,The window Object will run its validate method,
			 *and the GraphicsPanel object will run its repaint method
			 *
			 *Running the Jpanel's repaint method instead of the Jframe's method is more efficient
			 *
			 */
			@Override
			public void run() {
					update();
					//Calls the update method
					window.validate();
					//Calls the validate method of the Window object
					p.repaint();
					//Calls the repaint method of the GraphicsPanel object
			}
		}, 0, (long) ((1/fps)*1000));
	}
	
	
	/*
	 * The update method, empty because it is meant to be overwritten.
	 * Runs once per frame
	 */
	public void update() {
	}
	
	
	/*
	 * The mouseClick method, empty because it is meant to be overwritten.
	 * Called every time the mouse is pressed, not clicked.
	 */
	public void mouseClick() {
	}
	
	
	/*
	 * The keyType method, empty because it is meant to be overwritten.
	 * Called every keystroke
	 * For detecting what key is pressed, the user should make a simple If check for the desired character.
	 * For example: if(keyTyped == 'a'){} would check if the key pressed was a lowercase a
	 * Note: chars can not be encased in double quotes, only single quotes.
	 */
	public void keyType() {
		
	}
	
	
	
	/**
	 * The wipe method
	 * This method is used to remove all elements of the Arraylist shapes.
	 * This also writes over the GraphicsObject Panel with a new GraphicsObject. 
	 * Removes and adds the OgrphicsPanel from the Window Object
	 */
	public void wipe() {
		clearLists();
		//Calls clearLists.
		window.remove(Panel);
		//removes the Jpanel panel from the Jframe Window
		Panel = new GraphicsPanel();
		//Instantiating the new panel
		window.add(Panel);	
		//Adding it back to the window
	}
	
	
	/**
	 * clearLists method
	 * Writes over The ArrayList Shapes
	 */
	public void clearLists() {
		shapes = new ArrayList<Drawable>();
		//Writes over The ArrayList Shapes
	}
	
	
	/**
	 * changeVisibility method
	 * Changes the JFrame Window's visibility with the boolean b
	 * @param b
	 */
	public void ChangeVisibility(boolean b) {
		window.setVisible(b);
		//calls the setVisibility method with the boolean b
	}
	
	
	/**
	 * Draws Square object with given parameters
	 * @param x
	 * @param y
	 * @param length
	 */
	public void drawSquare(int x, int y, int length) {
		Square newSquare = new Square(x,y,length);
		//instantiates new Square object
		shapes.add(newSquare);
		//Adds to the ArrayList
		Panel.updateShapes(shapes);	
		//Updates the Panel's list of shapes
	}
	
	
	/**
	 * Draws Square object with given parameters
	 * @param x
	 * @param y
	 * @param length
	 * @param color
	 */
	public void drawfilledSquare(int x, int y, int length,Color color) {
		Square newSquare = new Square(x,y,length,color);
		//instantiates new Square object
		shapes.add(newSquare);
		//Adds to the ArrayList
		Panel.updateShapes(shapes);	
		//Updates the Panel's list of shapes
	}
	
	
	/**
	 * Draws Rectangle object with given parameters
	 * @param x
	 * @param y
	 * @param length
	 * @param width
	 */
	public void drawRectangle(int x, int y, int length, int width) {
		Rectangle newRect = new Rectangle(x,y,length,width);
		//instantiates new Rectangle object
		shapes.add(newRect);
		//Adds to the ArrayList
		Panel.updateShapes(shapes);
		//Updates the Panel's list of shapes
	}
	
	
	/**
	 * Draws Rectangle object with given parameters
	 * @param x
	 * @param y
	 * @param length
	 * @param width
	 * @param color
	 */
	public void drawfilledRectangle(int x, int y, int length,int width,Color color) {
		Rectangle newRect = new Rectangle(x,y,length,width,color);
		//instantiates new Rectangle object
		shapes.add(newRect);
		//Adds to the ArrayList
		Panel.updateShapes(shapes);
		//Updates the Panel's list of shapes
	}
	
	
	/**
	 * Draws Circle object with given parameters
	 * @param x
	 * @param y
	 * @param radius
	 */
	public void drawCircle(int x, int y, int radius) {
		Circle newCircle = new Circle(x,y,radius);
		//instantiates new Circle object
		shapes.add(newCircle);
		//Adds to the ArrayList
		Panel.updateShapes(shapes);
		//Updates the Panel's list of shapes
	}
	
	
	/**
	 * Draws Circle object with given parameters
	 * @param x
	 * @param y
	 * @param radius
	 * @param color
	 */
	public void drawFilledCircle(int x, int y, int radius, Color color) {
		Circle newCircle = new Circle(x,y,radius,color);
		//instantiates new Circle object
		shapes.add(newCircle);
		//Adds to the ArrayList
		Panel.updateShapes(shapes);
		//Updates the Panel's list of shapes
	}
	
	
	/**
	 * Draws Oval object with given parameters
	 * @param x
	 * @param y
	 * @param length
	 * @param width
	 */
	public void drawOval(int x, int y, int length, int width) {
		Oval newOval = new Oval(x,y,length,width);
		//instantiates new Oval object
		shapes.add(newOval);
		//Adds to the ArrayList
		Panel.updateShapes(shapes);
		//Updates the Panel's list of shapes
	}
	
	
	/**
	 * Draws Oval object with given parameters
	 * @param x
	 * @param y
	 * @param length
	 * @param width
	 * @param color
	 */
	public void drawFilledOval(int x, int y, int length, int width, Color color) {
		Oval newOval = new Oval(x,y,length,width,color);
		//instantiates new Oval object
		shapes.add(newOval);
		//Adds to the ArrayList
		Panel.updateShapes(shapes);
		//Updates the Panel's list of shapes
	}
	
	
	/**
	 * Draws Triangle object with given parameters
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 */
	public void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		Triangle newTriangle = new Triangle(x1,x2,x3,y1,y2,y3);
		//instantiates new Triangle object
		shapes.add(newTriangle);
		//Adds to the ArrayList
		Panel.updateShapes(shapes);
		//Updates the Panel's list of shapes
	}
	
	
	/**
	 * Draws Triangle object with given parameters
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 * @param color
	 */
	public void drawFilledtriangle(int x1, int y1, int x2, int y2, int x3, int y3,Color color) {
		Triangle newTriangle = new Triangle(x1,x2,x3,y1,y2,y3,color);
		//instantiates new Triangle object
		shapes.add(newTriangle);
		//Adds to the ArrayList
		Panel.updateShapes(shapes);
		//Updates the Panel's list of shapes
	}
	
	
	/**
	 * Draws Polygon object with given parameters
	 * @param x
	 * @param y
	 * @param radius
	 * @param numSides
	 */
	public void drawPolygon(int x, int y, int radius, int numSides) {
		Polygon newPoly = new Polygon(x,y,radius,numSides);
		//instantiates new Polygon object
		shapes.add(newPoly);
		//Adds to the ArrayList
		Panel.updateShapes(shapes);
		//Updates the Panel's list of shapes
	}
	
	
	/**
	 * Draws Polygon object with given parameters
	 * @param x
	 * @param y
	 * @param radius
	 * @param numSides
	 * @param color
	 */
	public void drawFilledPolygon(int x, int y, int radius, int numSides, Color color) {
		Polygon newPoly = new Polygon(x,y,radius,numSides,color);
		//instantiates new Polygon object
		shapes.add(newPoly);
		//Adds to the ArrayList
		Panel.updateShapes(shapes);
		//Updates the Panel's list of shapes
	}
	/**
	 * Draws Message object with given parameters
	 * @param x
	 * @param y
	 * @param size
	 * @param message
	 */
	public void drawString(int x, int y,int size, String message) {
		Message newMessage = new Message(x,y,size,message);
		//instantiates new Message object
		shapes.add(newMessage);
		//Adds to the ArrayList
		Panel.updateShapes(shapes);
		//Updates the Panel's list of shapes
	}
	
	
	/**
	 * Draws Line object with given parameters
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		Line newline = new Line(x1,y1,x2,y2);
		//instantiates new Line object
		shapes.add(newline);
		//Adds to the ArrayList
		Panel.updateShapes(shapes);
		//Updates the Panel's list of shapes
	}
	
	
	/**
	 * Draws Picture object with given parameters
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param img
	 */
	public void drawImage(int x,int y, int width, int height, Image img) {
		Picture pict = new Picture(x,y,width,height,img);
		//instantiates new Picture object
		shapes.add(pict);
		//Adds to the ArrayList
		Panel.updateShapes(shapes);
		//Updates the Panel's list of shapes
	}
}

