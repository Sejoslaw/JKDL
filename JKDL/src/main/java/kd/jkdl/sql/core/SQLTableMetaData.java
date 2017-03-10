package main.java.kd.jkdl.sql.core;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import main.java.kd.jkdl.sql.api.ISQLTable;
import main.java.kd.jkdl.sql.api.ISQLTableMetaData;

/**
 * An object that can be used to get information about the types
 * and properties of the columns in a SQLTable.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 * @see ISQLTable
 */
public class SQLTableMetaData implements ISQLTableMetaData
{
	private final ResultSetMetaData _rsMetaData;
	
	public SQLTableMetaData(ResultSetMetaData metaData) 
	{
		this._rsMetaData = metaData;
	}
	
	public int getColumnCount() 
			throws SQLException
	{
		return _rsMetaData.getColumnCount();
	}
	
	public String getColumnName(int index) 
			throws SQLException
	{
		return _rsMetaData.getColumnName(index);
	}
	
	/**
	 * Just in case that user may need something more.
	 * 
	 * @return Returns the {@link ResultSetMetaData} itself.
	 */
	@Deprecated
	public ResultSetMetaData getMetaData()
	{
		return _rsMetaData;
	}
}