package main.java.kd.jkdl.sql.core;

import java.sql.CallableStatement;
import java.sql.SQLException;

import main.java.kd.jkdl.sql.api.ISQLCallableStatement;
import main.java.kd.jkdl.sql.api.ISQLDatabase;

/**
 * Used to execute SQL stored procedures.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 * @see CallableStatement
 */
public class SQLCallableStatement extends SQLPreparedStatement implements ISQLCallableStatement
{
	private final CallableStatement cs;
	private final int _resultSetType;
	private final int _resultSetConcurrency;
	
	public SQLCallableStatement(ISQLDatabase database, CallableStatement cs, String sqlCommand, 
			int resultSetType, int resultSetConcurrency, String tableName) 
					throws SQLException 
	{
		super(database, cs, sqlCommand, tableName);
		this.cs = cs;
		this._resultSetType = resultSetType;
		this._resultSetConcurrency = resultSetConcurrency;
	}
	
	@Deprecated
	public CallableStatement getStatement()
	{
		return cs;
	}
	
	public int getTableType()
	{
		return _resultSetType;
	}
	
	public int getTableConcurrency()
	{
		return _resultSetConcurrency;
	}
}