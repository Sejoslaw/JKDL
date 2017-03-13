package main.java.kd.jkdl.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Some static methods for easy time checking.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class DateTime 
{
	private DateTime()
	{
	}
	
	/**
	 * @return Returns current time in form of -> "HH.mm.ss"
	 */
	public static String getCurrentTime()
	{
		return getDateTime("HH.mm.ss");
	}
	
	/**
	 * @return Returns current day in form of -> "yyyy.MM.dd"
	 */
	public static String getCurrentDay()
	{
		return getDateTime("yyyy.MM.dd");
	}
	
	/**
	 * @return Returns the default current DateTime (Now) in form of -> "yyyy.MM.dd-HH.mm.ss"
	 */
	public static String getDateTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	/**
	 * @param format DateTime format. For default use -> "yyyy.MM.dd-HH.mm.ss" OR method without arguments.
	 * 
	 * @return Returns Now in the given form.
	 */
	public static String getDateTime(String format)
	{
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		return dateFormat.format(date);
	}
}