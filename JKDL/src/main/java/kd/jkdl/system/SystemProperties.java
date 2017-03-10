package main.java.kd.jkdl.system;

/**
 * This class provide some basic information about current System.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class SystemProperties 
{
	/**
	 * @return Return system name.
	 */
	public String getOSName()
	{
		return System.getProperty("os.name");
	}
	
	/**
	 * @return Return system version.
	 */
	public String getOSVersion()
	{
		return System.getProperty("os.version");
	}
	
	/**
	 * @return Return system architecture.
	 */
	public String getOSArchitecture()
	{
		return System.getProperty("os.arch");
	}
	
	/**
	 * @return Return Java version. 
	 */
	public String getJavaVersion()
	{
		return System.getProperty("java.version");
	}
	
	/**
	 * @return Return Java class version. 
	 */
	public String getJavaClassVersion()
	{
		return System.getProperty("java.class.version");
	}
	
	/**
	 * @return Return Sun architecture data model. 
	 */
	public String getSunArchitectureDataModel()
	{
		return System.getProperty("sun.arch.data.model");
	}
	
	/**
	 * @return Return user country. 
	 */
	public String getUserCountry()
	{
		return System.getProperty("user.country");
	}
}