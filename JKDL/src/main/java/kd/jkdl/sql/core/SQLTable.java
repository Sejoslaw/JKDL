package main.java.kd.jkdl.sql.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.kd.jkdl.sql.api.ISQLDatabase;
import main.java.kd.jkdl.sql.api.ISQLObject;
import main.java.kd.jkdl.sql.api.ISQLTable;
import main.java.kd.jkdl.sql.api.ISQLTableMetaData;

/**
 * SQL Table.
 *
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class SQLTable implements ISQLTable
{
	private final ISQLDatabase _database;
	private final ResultSet _resultSet;
	private final ISQLTableMetaData _tableMetaData;
	private final int _columnCount;
	private final int _rowCount;
	private final List<String> _columnNames;
	private final String _tableName;
    
	private List<ISQLObject> _objects;
    
	public SQLTable(ISQLDatabase database, ResultSet resultSet, String tableName) 
			throws SQLException
	{
		this._database = database;
		this._resultSet = resultSet;
		this._tableName = tableName;
		this._tableMetaData = new SQLTableMetaData(this._resultSet.getMetaData());
		this._columnCount = getColumnCount0();
		this._rowCount = getRowCount0();
		this._columnNames = getColumNames0();
	}
	
	@Deprecated
	public ResultSet getTableResultSet()
	{
		return _resultSet;
	}
	
	public ISQLTableMetaData getTableMetaData()
	{
		return _tableMetaData;
	}
	
	public String getTableName()
	{
		return _tableName;
	}
	
	public ISQLDatabase getDatabase()
	{
		return _database;
	}
	
	public int getColumnCount()
	{
		return _columnCount;
	}
    
	private int getColumnCount0() 
			throws SQLException
	{
		return _tableMetaData.getColumnCount();
	}
	
	public int getRowCount()
	{
		return _rowCount;
	}
    
	/**
	 * Returns the row number from the last row.
	 * 
	 * @return
	 * @throws SQLException 
	 */
	private int getRowCount0() 
			throws SQLException
	{
		_resultSet.last();
		return _resultSet.getRow();
	}
	
	public String getColumnName(int index) 
			throws SQLException
	{
		return _tableMetaData.getColumnName(index);
	}
    
	private List<String> getColumNames0() 
			throws SQLException
	{
		List<String> names = new ArrayList<>();
		for(int i = 1; i < getColumnCount() + 1; ++i)
		{
			String columnName = getColumnName(i);
			names.add(columnName);
		}
		return names;
	}
	
	public ISQLObject getObject(int rowNumber) 
			throws SQLException
	{
		_resultSet.absolute(rowNumber);
		Map<String, Object> variables = new HashMap<String, Object>();
		for(int i = 1; i <= _columnNames.size(); ++i)
		{
			variables.put(_columnNames.get(i), _resultSet.getObject(i)); // Column Name -> Object under that name in table
		}
		return new SQLObject(this, rowNumber, variables);
	}
	
	public List<ISQLObject> getObjects() 
			throws SQLException
	{
		if(_objects == null)
		{
			_objects = new ArrayList<ISQLObject>();
			for(int i = 1; i <= _rowCount; ++i)
			{
				_objects.add(getObject(i));
			}
		}
		return _objects;
	}
	
	public void updateValue(int rowNumber, String columnName, Object newValue) 
			throws SQLException
	{
		_resultSet.absolute(rowNumber);
		_resultSet.updateObject(columnName, newValue);
		_resultSet.updateRow();
	}
	
	public ISQLObject insertRow(Object... values) 
			throws SQLException
	{
		_resultSet.afterLast();
		for(int i = 0; i < values.length; ++i)
		{
			_resultSet.updateObject(i, values[i]);
		}
		_resultSet.insertRow();
		_resultSet.moveToCurrentRow();
		return getObject(_resultSet.getRow());
	}
	
	public void deleteRow(int rowNumber) 
			throws SQLException
	{
		_resultSet.absolute(rowNumber);
		_resultSet.deleteRow();
	}
    
	@Override
	public String toString()
	{
		return "Table: " + _tableName + 
				" [ Database = " + _database.getDatabaseName() + 
				", Columns = " + _columnCount + 
				", Rows = " + _rowCount + 
				" ]";
	}
}