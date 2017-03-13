package main.java.kd.jkdl.datetime;

import java.util.concurrent.TimeUnit;

/**
 * Some static time periods.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 * 
 * @see TimeUnit
 */
public enum TimePeriod
{
	MILLISECOND(1, "Millisecond"),	// MILLISECOND
	SECOND(1000, "Second"),			// MILLISECOND * 1000
	MINUTE(60000, "Minute"),		// SECOND * 60
	HOUR(3600000, "Hour"),			// MINUTE * 60
	DAY(86400000, "Day"),			// HOUR * 24
	WEEK(604800000, "Week");		// DAY * 7
	
	/**
	 * How many milliseconds this period of time is.
	 */
	private int _milliseconds;
	/**
	 * Time period name.
	 */
	private String _periodName;
	
	TimePeriod(int milliseconds, String periodName)
	{
		this._milliseconds = milliseconds;
		this._periodName = periodName;
	}
	
	/**
	 * @return Return the number of milliseconds in this time period.
	 */
	public int toMilliseconds()
	{
		return this._milliseconds;
	}
	
	/**
	 * @return Return the name of this time period.
	 */
	public String getPeriodName()
	{
		return this._periodName;
	}
}