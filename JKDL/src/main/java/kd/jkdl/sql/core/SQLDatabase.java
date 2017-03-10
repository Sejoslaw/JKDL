package main.java.kd.jkdl.sql.core;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.kd.jkdl.sql.api.ISQLCallableStatement;
import main.java.kd.jkdl.sql.api.ISQLDatabase;
import main.java.kd.jkdl.sql.api.ISQLPreparedStatement;
import main.java.kd.jkdl.sql.api.ISQLTable;

/**
 * SQL Database.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class SQLDatabase implements ISQLDatabase
{
	private final Connection _connection;
	private final Statement _statement;
	private final String _databaseName;
	private final DatabaseMetaData _databaseMetaData;
    
	public SQLDatabase(Connection conn, String databaseName) 
			throws SQLException
	{
		this._connection = conn;
		this._statement = this._connection.createStatement();
		this._databaseName = databaseName;
		this._databaseMetaData = this._connection.getMetaData();
	}
    
	public void rollback() 
			throws SQLException
	{
		_connection.rollback();
	}
    
	public void commit() 
			throws SQLException
	{
		_connection.commit();
	}
    
	public String getDatabaseName()
	{
		return _databaseName;
	}
	
	@Deprecated
	public DatabaseMetaData getDatabaseMetaData()
	{
		return _databaseMetaData;
	}
	
	@Deprecated
	public Connection getConnection()
	{
		return _connection;
	}
	
	@Deprecated
	public Statement getStatement()
	{
		return _statement;
	}
	
	public String getDatabaseProductNameAndVersion() 
			throws SQLException
	{
		String productName = _databaseMetaData.getDatabaseProductName();
		String productVersion = _databaseMetaData.getDatabaseProductVersion();
		return "Product: " + productName + " version: " + productVersion;
	}
	
	public List<String> getTableNames() 
			throws SQLException
	{
		List<String> names = new ArrayList<>();
		ResultSet rs = _databaseMetaData.getTables(null, null, null, null);
		while(rs.next())
		{
			names.add(rs.getString(3));
		}
		return names;
	}
	
	public Map<String, Integer> getTableTypes(String tableName) 
			throws SQLException
	{
		Map<String, Integer> map = new HashMap<>();
		ResultSet rs = _databaseMetaData.getColumns(null, null, tableName, null);
		while(rs.next())
		{
			String columnName = rs.getString(4);
			int columnType = rs.getInt(5);
			map.put(columnName, columnType);
		}
		return map;
	}
	
	public ISQLTable createTable(String tableName, String[] columnNames, String[] columnTypes, 
			String additionalCommand)
			throws SQLException
	{
		if(columnNames.length != columnTypes.length)
		{
			throw new SQLException("ColumnNames size (" + columnNames.length + 
					") is different from ColumnTypes size (" + columnTypes.length + ").");
		}
		String sqlCommand = "CREATE TABLE " + tableName + " (";
		for(int i = 0; i < columnNames.length; ++i)
		{
			sqlCommand += columnNames[i] + " " + columnTypes[i];
			if(i + 1 < columnNames.length)
			{
				sqlCommand += ", ";
			}
		}
		sqlCommand += " ";
		sqlCommand += additionalCommand;
		sqlCommand += ")";
		_statement.executeUpdate(sqlCommand);
		return getTable(tableName);
	}
	
	public ISQLTable getTable(String tableName)
			throws SQLException
	{
		ResultSet rs = _statement.executeQuery("SELECT * FROM " + tableName);
		return new SQLTable(this, rs, tableName);
	}
	
	public void deleteTable(String tableName)
			throws SQLException
	{
		_statement.execute("DROP TABLE " + tableName);
	}
	
	public ISQLTable getCustomTable(String sqlCommand, String tableName) 
			throws SQLException
	{
		if(sqlCommand.toLowerCase().contains("delete"))
		{
			throw new SQLException("For deleting Please use deleteTable method.");
		}
		if(sqlCommand.toLowerCase().contains("create table"))
		{
			throw new SQLException("For creating new Table Please use createTable method.");
		}
		ResultSet rs = _statement.executeQuery(sqlCommand);
		return new SQLTable(this, rs, tableName);
	}
	
	public ISQLPreparedStatement createPreparedStatement(String sqlCommand, String tableName)
			throws SQLException
	{
		PreparedStatement ps = _connection.prepareStatement(sqlCommand);
		return new SQLPreparedStatement(this, ps, sqlCommand, tableName);
	}
	
	public ISQLCallableStatement createCallableStatement(String sqlCommand, 
			int resultSetType, int resultSetConcurrency, String tableName) 
					throws SQLException
	{
		CallableStatement cs = _connection.prepareCall(sqlCommand, resultSetType, resultSetConcurrency);
		return new SQLCallableStatement(this, cs, sqlCommand, resultSetType, resultSetConcurrency, tableName);
	}
	
	public void closeStatement() 
			throws SQLException
	{
		_statement.close();
	}
	
	public int update(String sqlCommand) 
			throws SQLException
	{
		return _statement.executeUpdate(sqlCommand);
	}
	
	public boolean execute(String sqlCommand) 
			throws SQLException
	{
		return _statement.execute(sqlCommand);
	}
    
	@Override
	public String toString()
	{
		try 
		{
			return "Database: " + _databaseName + "[ " + getDatabaseProductNameAndVersion() + " ]";
		} 
		catch(SQLException e) 
		{
			return "Database: " + _databaseName;
		}
	}
}