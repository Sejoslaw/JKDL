package main.java.kd.jkdl.sql.api;

import java.sql.SQLException;
import java.util.Map;

/**
 * One Table row represented as Java Object.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public interface ISQLObject 
{
	/**
	 * Just in case that user may need something more.
	 * 
	 * @return Returns the variables {@link Map} itself.
	 */
	@Deprecated
	Map<String, Object> getVariables();
	
	/**
	 * @return Returns Table of this Object.
	 */
	ISQLTable getTable();
	
	/**
	 * @return Returns the row number of this Object in Table.
	 */
	int getRowNumber();
	
	/**
	 * @param columnName
	 * @return Returns the variable that is under the given column name.
	 */
	<T> T getVariable(String columnName);
	
	/**
	 * Will throw error if Table is read-only.
	 * 
	 * @param columnName
	 * @param newValue
	 * @throws SQLException 
	 */
	public void updateVariable(String columnName, Object newValue) throws SQLException;
}