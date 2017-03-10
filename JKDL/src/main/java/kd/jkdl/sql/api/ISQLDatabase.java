package main.java.kd.jkdl.sql.api;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.Map;

/**
 * SQL Database.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public interface ISQLDatabase 
{
	/**
	 * @see Connection#rollback()
	 * @throws SQLException
	 */
	void rollback() throws SQLException;
	
	/**
	 * @see Connection#commit()
	 * @throws SQLException
	 */
	void commit() throws SQLException;
	
	/**
	 * @return Returns the name of this Database.
	 */
	String getDatabaseName();
	
	/**
	 * @return Returns the MetaData of this Database.
	 * 
	 * @see DatabaseMetaData
	 */
	@Deprecated
	DatabaseMetaData getDatabaseMetaData();
	
	/**
	 * Just in case that user may need something more.
	 * 
	 * @return Returns the {@link Connection} itself.
	 */
	@Deprecated
	Connection getConnection();
	
	/**
	 * Just in case that user may need something more.
	 * 
	 * @return Returns the {@link Statement} itself.
	 */
	@Deprecated
	public Statement getStatement();
	
	/**
	 * @return Returns the Database Product with Version.
	 * @throws SQLException
	 */
	String getDatabaseProductNameAndVersion() throws SQLException;
	
	/**
	 * @return Returns all Table names in this Database.
	 * @throws SQLException
	 */
	List<String> getTableNames() throws SQLException;
	
	/**
	 * @param tableName
	 * @return Returns the Map of column names with their types.
	 * @throws SQLException
	 * 
	 * @see Types
	 */
	Map<String, Integer> getTableTypes(String tableName) throws SQLException;
	
	/**
	 * Creates new Table in Database and returns created Table.
	 * 
	 * @param tableName name of the Table
	 * @param columnNames names for each column
	 * @param columnTypes types for each column
	 * @return created Table
	 * @throws SQLException 
	 * @see ISQLTable
	 */
	ISQLTable createTable(String tableName, String[] columnNames, String[] columnTypes, String additionalCommand) throws SQLException;
	
	/**
	 * Returns the Table from the given name.<br>
	 * Table is read-only.
	 * 
	 * @param tableName name of the Table
	 * @return
	 * @throws SQLException 
	 * @see ISQLTable
	 */
	ISQLTable getTable(String tableName) throws SQLException;
	
	/**
	 * Deletes the Table from the given game.
	 * 
	 * @param tableName
	 * @throws SQLException 
	 */
	void deleteTable(String tableName) throws SQLException;
	
	/**
	 * Returns the SQLTable as a custom Table from the given SQL command.
	 * 
	 * @param sqlCommand String representing user typed SQL command (can be any SQL Command)
	 * @param tableName This will be used as name for this Table
	 * @return
	 * @throws SQLException 
	 */
	ISQLTable getCustomTable(String sqlCommand, String tableName) throws SQLException;
	
	/**
	 * @param sqlCommand SQL Command, for instance -> "SELECT * FROM table1"
	 * @param tableName Name of the Table. It will be used as a main name for this Table.
	 * @return
	 * @throws SQLException
	 * @see ISQLPreparedStatement
	 */
	ISQLPreparedStatement createPreparedStatement(String sqlCommand, String tableName) throws SQLException;
	
	/**
	 * @param sqlCommand
	 * @param resultSetType
	 * @param resultSetConcurrency
	 * @param tableName
	 * @return Returns a {@link CallableStatement} wrapped into SQLCallableStatement
	 * @throws SQLException
	 */
	ISQLCallableStatement createCallableStatement(String sqlCommand, int resultSetType, int resultSetConcurrency, String tableName) throws SQLException;
	
	/**
	 * Closes the Statement.
	 * 
	 * @throws SQLException 
	 */
	void closeStatement() throws SQLException;
	
	/**
	 * @see Statement#executeUpdate(java.lang.String)
	 * 
	 * @param sqlCommand
	 * @return Returns the number of affected rows.
	 * @throws SQLException 
	 */
	int update(String sqlCommand) throws SQLException;
	
	/**
	 * @see Statement#execute(java.lang.String) 
	 * 
	 * @param sqlCommand
	 * @return
	 * @throws SQLException 
	 */
	boolean execute(String sqlCommand) throws SQLException;
}