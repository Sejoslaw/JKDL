package main.java.kd.jkdl.sql.api;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * An object that can be used to get information about the types
 * and properties of the columns in a ISQLTable.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 * @see ISQLTable
 */
public interface ISQLTableMetaData 
{
	/**
	 * @return Returns the number of columns in the Table.
	 * @throws SQLException
	 */
	int getColumnCount() throws SQLException;
	
	/**
	 * @param index Column index. Starts from 1
	 * @return Returns the name of the column at the given index.
	 * @throws SQLException
	 */
	String getColumnName(int index) throws SQLException;
	
	/**
	 * Just in case that user may need something more.
	 * 
	 * @return Returns the {@link ResultSetMetaData} itself.
	 */
	@Deprecated
	ResultSetMetaData getMetaData();
}