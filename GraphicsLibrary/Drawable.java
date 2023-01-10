package GraphicsLibrary;

import java.awt.Graphics2D;
/**
 * @author Jason Barnaba
 *
 *
 *Drawable interface.
 *Allows each shape object to run the draw method.
 */
public interface Drawable {
	public void draw(Graphics2D g);
	//Draw method. Takes the Graphics of the JFrame passed through the JPanel
}
