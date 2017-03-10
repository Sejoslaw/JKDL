package main.java.kd.jkdl.sql.core;

import java.sql.ParameterMetaData;
import java.sql.SQLException;

import main.java.kd.jkdl.sql.api.ISQLParameterMetaData;

/**
 * An object that can be used to get information about the types
 * and properties for each parameter.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 * @see ParameterMetaData
 */
public class SQLParameterMetaData implements ISQLParameterMetaData
{
	private final ParameterMetaData _paramMetaData;
	
	public SQLParameterMetaData(ParameterMetaData parameterMetaData) 
	{
		this._paramMetaData = parameterMetaData;
	}
	
	public int getParameterCount() 
			throws SQLException
	{
		return _paramMetaData.getParameterCount();
	}
	
	public int getParameterType(int param) 
			throws SQLException
	{
		return _paramMetaData.getParameterType(param);
	}
	
	public String getParameterTypeName(int param) 
			throws SQLException
	{
		return _paramMetaData.getParameterTypeName(param);
	}
	
	@Deprecated
	public ParameterMetaData getMetaData()
	{
		return _paramMetaData;
	}
}