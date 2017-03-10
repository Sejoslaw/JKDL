package main.java.kd.jkdl.sql.api;

import java.sql.ParameterMetaData;
import java.sql.SQLException;

/**
 * An object that can be used to get information about the types
 * and properties for each parameter.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 * @see ParameterMetaData
 */
public interface ISQLParameterMetaData 
{
	/**
	 * @return Returns the number of parameters.
	 * @throws SQLException
	 * @see {@link ParameterMetaData#getParameterCount()}
	 */
	int getParameterCount() throws SQLException;
	
	/**
	 * @param param Parameter. Starts with 1
	 * @return Returns the type of the parameter.
	 * @throws SQLException
	 * @see {@link ParameterMetaData#getParameterType(int)}
	 */
	int getParameterType(int param) throws SQLException;
	
	/**
	 * @param param
	 * @return Retrieves the designated parameter's database-specific type name.
	 * @throws SQLException
	 * @see {@link ParameterMetaData#getParameterTypeName(int)}
	 */
	String getParameterTypeName(int param) throws SQLException;
	
	/**
	 * Just in case that user may need something more.
	 * 
	 * @return Returns the {@link ParameterMetaData} itself.
	 */
	@Deprecated
	ParameterMetaData getMetaData();
}