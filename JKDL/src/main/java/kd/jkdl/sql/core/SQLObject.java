package main.java.kd.jkdl.sql.core;

import java.sql.SQLException;
import java.util.Map;

import main.java.kd.jkdl.sql.api.ISQLObject;
import main.java.kd.jkdl.sql.api.ISQLTable;

/**
 * One Table row represented as Java Object.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class SQLObject implements ISQLObject
{
	private final ISQLTable _table;
	private final int _rowNumber;
	private final Map<String, Object> _variables;
    
	public SQLObject(ISQLTable table, int rowNumber, Map<String, Object> variables) 
			throws SQLException
	{
		this._table = table;
		this._rowNumber = rowNumber;
		this._variables = variables;
	}
	
	@Deprecated
	public Map<String, Object> getVariables()
	{
		return _variables;
	}
	
	public ISQLTable getTable()
	{
		return _table;
	}
	
	public int getRowNumber()
	{
		return _rowNumber;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getVariable(String columnName)
	{
		return (T) _variables.get(columnName);
	}
	
	public void updateVariable(String columnName, Object newValue) 
			throws SQLException
	{
		_table.updateValue(_rowNumber, columnName, newValue);
	}
    
	@Override
	public String toString()
	{
		return "SQLObject: [ Table = " + _table.getTableName() + 
				", Row Number = " + _rowNumber + 
				" ]";
	}
}