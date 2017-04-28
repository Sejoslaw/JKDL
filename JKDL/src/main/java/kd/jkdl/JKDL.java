package main.java.kd.jkdl;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class JKDL 
{
	/**
	 * Current version of JKDL - Last build time.
	 */
	public static final String VERSION = "2017.04.28-13.31.47";	
	public static final Logger LOGGER = Logger.getLogger("JKDL");
	
	/**
	 * Add log using JKDL logger.
	 */
	public static void log(Level level, String message)
	{
		LOGGER.log(level, message);
	}
}
