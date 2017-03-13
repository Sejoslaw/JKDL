package main.java.kd.jkdl.graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.Timer;

/**
 * TODO: Add support for Java build-in Graphics API.<br>
 * <br>
 * This class contains various methods to operate on Java Graphics API.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class JKDLGraphics 
{
	private JKDLGraphics()
	{
	}
	
	/**
	 * @param threadName Name for this Animation Thread
	 * @param ac Container in which Animation occurres.
	 * 
	 * @return Returns an already started Animation Thread.
	 */
	public static Thread startNewAnimation(String threadName, IAnimationContainer ac)
	{
		String name = threadName == null ? "AnimationThread-" + System.currentTimeMillis() : threadName;
		Thread animationThread = new Thread(name)
		{
			public void run() 
			{
				while(true)
				{
					ac.update();
					ac.repaint();
					try
					{
						Thread.sleep(ac.getDelay());
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		};
		animationThread.start();
		return animationThread;
	}
	
	/**
	 * Used mainly in animations.
	 * 
	 * @param timerDelay Delay after which Timer will update.
	 * @param task Task which Timer should perform every update.
	 * 
	 * @return Returns new preconfigured and already started Timer.
	 */
	public static Timer startNewTimer(int timerDelay, ActionListener task)
	{
		Timer timer = new Timer(timerDelay, task);
		timer.start();
		return timer;
	}
	
	/**
	 * @return Returns the maximum bounds for centered Windows.
	 */
	public static Rectangle getMaximumWindowBounds()
	{
		return getGraphicsEnvironment().getMaximumWindowBounds();
	}
	
	/**
	 * @return Returns an array containing a one-point size instance of all fonts
	 * available in this GraphicsEnvironment.
	 * 
	 * @see Font
	 */
	public static Font[] getAllFonts()
	{
		return getGraphicsEnvironment().getAllFonts();
	}
	
	/**
	 * @return Returns the GraphicsDevice that represents the default screen device.
	 * 
	 * @see GraphicsDevice
	 */
	public static GraphicsDevice getDefaultScreenDevice()
	{
		return getGraphicsEnvironment().getDefaultScreenDevice();
	}
	
	/**
	 * @return Returns an array containing all the GraphicsDevice objects that represent screen devices.
	 * 
	 * @see GraphicsDevice
	 */
	public static GraphicsDevice[] getScreenDevices()
	{
		return getGraphicsEnvironment().getScreenDevices();
	}
	
	/**
	 * @return Returns the local GraphicsEnvironment.
	 * 
	 * @see GraphicsEnvironment
	 */
	public static GraphicsEnvironment getGraphicsEnvironment()
	{
		return GraphicsEnvironment.getLocalGraphicsEnvironment();
	}
	
	/**
	 * @return Returns Color which was picked in ColorChooser.
	 * 
	 * @see JColorChooser#showDialog(Component, String, Color)
	 */
	public static Color showColorChooser(Component component, String title, Color initialColor)
	{
		return JColorChooser.showDialog(component, title, initialColor);
	}
	
	/**
	 * @return Returns this graphics context's current font.
	 */
	public static Font getFont(Graphics g)
	{
		return g.getFont();
	}
	
	/**
	 * @return Returns the font metrics of this graphics context's current font.
	 */
	public static FontMetrics getFontMetrics(Graphics g)
	{
		return g.getFontMetrics();
	}
	
	/**
	 * @return Returns the bounding rectangle of the current clipping area, or NULL if no clip is set.
	 */
	public static Rectangle getClipBounds(Graphics g)
	{
		return g.getClipBounds();
	}
	
	/**
	 * @return Returns a Shape object representing the current clipping area, or NULL if no clip is set.
	 */
	public static Shape getClip(Graphics g)
	{
		return g.getClip();
	}
	
	/**
	 * @return Returns Graphics from Component.
	 * 
	 * @see Component
	 * @see Graphics
	 */
	public static Graphics getGraphics(Component comp)
	{
		return comp.getGraphics();
	}
	
	/**
	 * @return Returns new JColorChooser.
	 * 
	 * @see JColorChooser
	 */
	public static JColorChooser newColorChooser()
	{
		return new JColorChooser();
	}
}