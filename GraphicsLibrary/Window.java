package GraphicsLibrary;


import javax.swing.JFrame;

/**
 * @author Jason Barnaba
 * 
 * 
 *Window object, subclass of JFrame
 *JPanel draws to this JFrame
 *Mouse and KeyListener get their inputs from this JFrame
 */
public class Window extends JFrame{
	/**
	 * Constructor class used to set JFrame's parameters.
	 * @param width
	 * @param height
	 * @param title
	 * @param resizable
	 */
	public Window(int width, int height, String title, boolean resizable) {
		this.setSize(width, height);
		//Calls setSize method, which Sets screen width and height.
		this.setTitle(title);
		//Calls setTitle method, which changes the title of the window.
		this.setResizable(resizable);
		//Calls the setResizeable method, which decides whether or not you can resize the window.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Allows for exit of window without errors in console.
	}
}
