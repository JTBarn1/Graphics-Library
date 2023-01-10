package GraphicsLibrary.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
/**
 * 
 * @author Jason Barnaba
 *
 *
 *Key Class, Subclass of JComponent and uses the KeyListener interface.
 *KeyListener has 3 methods, only keyTyped is used for this program.
 */
public class Key extends JComponent implements KeyListener{

	/**
	 *Key pressed Method.
	 *Not used, but would check if a key was held down
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
	}
	/**
	 *Key Released Method.
	 *Not used, but would check if a key was Released.
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	/**
	 * Key typed method.
	 * Overwritten in Controller class. 
	 * Once key pressed and key released are called, this method calls.
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
