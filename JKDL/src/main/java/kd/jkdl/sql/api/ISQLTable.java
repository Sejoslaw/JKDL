package main.java.kd.jkdl.sql.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * SQL Table.
 *
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public interface ISQLTable 
{
	/**
	 * Just in case that user may need something more.
	 * 
	 * @return Returns the {@link ResultSet} itself.
	 */
	@Deprecated
	ResultSet getTableResultSet();
	
	/**
	 * @return Returns the Table MetaData.
	 */
	ISQLTableMetaData getTableMetaData();
	
	/**
	 * @return Returns the name of this Table.
	 */
	String getTableName();
	
	/**
	 * @return Returns the Database of this Table.
	 */
	ISQLDatabase getDatabase();
	
	/**
	 * @return Returns the number of columns in the current Table.
	 */
	int getColumnCount();
	
	/**
	 * @return Returns the number of rows in the current Table.
	 */
	int getRowCount();
	
	/**
	 * Returns the name of the column at the given index.
	 * 
	 * @param index Column indeks. Starts from 1
	 * @return 
	 * @throws SQLException 
	 */
	String getColumnName(int index) throws SQLException;
	
	/**
	 * Returns the SQLObject from the selected row.
	 * 
	 * @param rowNumber Starts from 1
	 * @return 
	 * @throws SQLException 
	 * @see ISQLObject
	 */
	ISQLObject getObject(int rowNumber) throws SQLException;
	
	/**
	 * Returns the list of all SQLObjects in this Table.<br>
	 * Will count all SQLObjects at first use.
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<ISQLObject> getObjects() throws SQLException;
	
	/**
	 * Updates the values at the giver row number.<br>
	 * Will throw error if Table is read-only.
	 * 
	 * @param rowNumber
	 * @param columnName
	 * @param newValue
	 * @throws SQLException 
	 */
	void updateValue(int rowNumber, String columnName, Object newValue) throws SQLException;
	
	/**
	 * Inserts the row with the given values.
	 * Will throw error if Table is read-only.
	 * 
	 * @param values
	 * @return Returns the new SQLObject with the inserted row.
	 * @throws SQLException 
	 */
	ISQLObject insertRow(Object... values) throws SQLException;
	
	/**
	 * Deletes the row by given row number.
	 * Will throw error if Table is read-only.
	 * 
	 * @param rowNumber
	 * @throws SQLException 
	 */
	void deleteRow(int rowNumber) throws SQLException;
}