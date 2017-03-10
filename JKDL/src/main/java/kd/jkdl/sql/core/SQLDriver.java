package main.java.kd.jkdl.sql.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import main.java.kd.jkdl.sql.api.ISQLDatabase;

/**
 * Class which stores all the drivers to different SQL Servers.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class SQLDriver
{
	private static final Map<String, String> _DB_URLS = new HashMap<String, String>();
    
	private static String _USING_DRIVER = "";
	private static String _DB_URL = "";
	private static String _DATABASE_NAME = "";
    
	/**
	 * MySQL JDBC Driver
	 */
	public static final String MYSQL = "com.mysql.jdbc.Driver";
	/**
	 * H2Database JDBC Driver
	 */
	public static final String H2DATABASE = "org.h2.Driver";
	/**
	 * Derby Embedded JDBC Driver
	 */
	public static final String DERBY_EMBEDDED = "org.apache.derby.jdbc.EmbeddedDriver";
    
	private SQLDriver()
	{
	}
    
	static
	{
		_DB_URLS.put(MYSQL, "jdbc:mysql");
		_DB_URLS.put(H2DATABASE, "jdbc:h2");
		_DB_URLS.put(DERBY_EMBEDDED, "jdbc:derby");
	}
    
	/**
	 * Register using driver.
	 * 
	 * @param driver
	 * @throws ClassNotFoundException 
	 * @see {@link SQLDriver#MYSQL},<br> {@link SQLDriver#H2DATABASE},<br> {@link SQLDriver#DERBY_EMBEDDED}
	 */
	public static void useDriver(String driver) 
			throws ClassNotFoundException
	{
		Class.forName(driver);
		_USING_DRIVER = driver;
	}
    
	/**
	 * Generates Connection String.<br>
	 * Sets the SQL Database.
	 * 
	 * @param ip
	 * @param port
	 * @param databaseName 
	 */
	public static void setDatabaseURL(String ip, String port, String databaseName)
	{
		_DB_URL = _DB_URLS.get(_USING_DRIVER) + "://" + ip + ":" + port + "/" + databaseName;
		_DATABASE_NAME = databaseName;
	}
	
	/**
	 * Generates Connection String.<br>
	 * Sets Driver to Derby Embedded.
	 * 
	 * @param databaseName
	 * @param create
	 */
	public static void setLocalDatabase(String databaseName, boolean create) 
	{
		_DB_URL = _DB_URLS.get(DERBY_EMBEDDED) + ":" + databaseName + ";create=" + create + ";use=" + databaseName;
		_DATABASE_NAME = databaseName;
	}
    
	/**
	 * Use this method to log into the SQL Database.
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException 
	 * @see SQLDatabase
	 */
	public static ISQLDatabase login(String username, String password) 
			throws SQLException
	{
		Connection conn = DriverManager.getConnection(_DB_URL, username, password);
		return new SQLDatabase(conn, _DATABASE_NAME);
	}
}