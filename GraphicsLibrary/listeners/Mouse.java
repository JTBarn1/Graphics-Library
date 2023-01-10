package GraphicsLibrary.listeners;

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;

import javax.swing.JComponent;




/**
 * @author Jason Barnaba
 *
 *Mouse Class, Subclass of JComponent and uses the MouseListener interface.
 *MouseListener has 3 methods, only mousePressed is used for this program.
 */
public class Mouse extends JComponent implements MouseListener {
		/**
		 * Mouse clicked method, unused but called after both 
		 * mousePressed and mouseReleased are called.
		 */
	    @Override
	    public void mouseClicked(MouseEvent arg0) {
	    }
	    
	    /**
	     * MouseEntered method. Unused, but detects when the mouse enters the JFrame.
	     */
		@Override
		public void mouseEntered(MouseEvent arg0) {
		}
		
		/**
	     * MouseExited method. Unused, but detects when the mouse exits the JFrame.
	     */
		@Override
		public void mouseExited(MouseEvent arg0) {
		}
		
		/**
		 * mousePressed method. Overwritten in the Controller class
		 * Better explanation there
		 */
		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		/**
	     * MouseReleased method. Unused, but detects when the mouse is released.
	     */
		@Override
		public void mouseReleased(MouseEvent arg0) {
		}

	}

