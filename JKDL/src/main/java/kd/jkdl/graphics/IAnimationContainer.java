package main.java.kd.jkdl.graphics;

/**
 * This interface describes basic container in which animation occurres.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public interface IAnimationContainer
{
	/**
	 * Updates the Animation.
	 */
	void update();
	
	/**
	 * Repaints the Animation.
	 */
	void repaint();
	
	/**
	 * @return Returns delay between each Animation frame.
	 */
	int getDelay();
}