package GraphicsLibrary;

import java.util.TimerTask;
/**
 * @author JTB
 * FrameTask Object, subclass of timerTask object.
 * Called every frame
 */
public class FrameTask extends TimerTask{
	GraphicsPanel p;
	//creating empty graphicsPanel
	
	/**
	 * Constructor class, passes The active GraphicsPanel object onto the variable p
	 * @param panel
	 */
	public FrameTask(GraphicsPanel panel) {
		this.p = panel;
		//Setting p as the active panel
		
	}
	
	/**
	 * Run method, overwritten in Controller class. 
	 * Better explanation there.
	 */
	@Override
	public void run() {
	}
}
