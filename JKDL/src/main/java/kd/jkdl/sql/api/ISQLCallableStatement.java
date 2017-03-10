package main.java.kd.jkdl.sql.api;

import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 * Used to execute SQL stored procedures.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 * @see CallableStatement
 */
public interface ISQLCallableStatement extends ISQLPreparedStatement
{
	@Deprecated
	CallableStatement getStatement();
	
	/**
	 * @return Return type of this Table.
	 * @see ResultSet
	 */
	int getTableType();
	
	int getTableConcurrency();
}