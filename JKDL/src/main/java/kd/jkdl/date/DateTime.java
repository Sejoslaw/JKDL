package main.java.kd.jkdl.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Convenient methods connected with Data.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class DateTime 
{
	private DateTime()
	{
	}
	
	/**
	 * @return Return current Date and Time in form of -> yyyy/MM/dd
	 */
	public static String getDate()
	{
		return getDate("yyyy/MM/dd");
	}
	
	/**
	 * @return Return current Date and Time in form of -> yyyy/MM/dd HH:mm:ss
	 */
	public static String getNow()
	{
		return getDate("yyyy/MM/dd HH:mm:ss");
	}
	
	/**
	 * @return Return given Date format in form of String.
	 */
	public static String getDate(String format)
	{
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		return dateFormat.format(date);
	}
}