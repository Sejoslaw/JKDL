package test.sql;

import main.java.kd.jkdl.sql.api.ISQLDatabase;
import main.java.kd.jkdl.sql.api.ISQLTable;
import main.java.kd.jkdl.sql.core.SQLDriver;

/**
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class TestSQL2 
{
	// Local Database Example
	public static void main(String[] args) 
	{
		try
		{
			SQLDriver.useDriver(SQLDriver.DERBY_EMBEDDED);
			SQLDriver.setLocalDatabase("MyLocalDatabase1", true);
			ISQLDatabase db = SQLDriver.login("root", "");
			System.out.println(db.toString());
			ISQLTable table = db.createTable("Aaa", 
					new String[]{
							"Id", // Column Name 1
							"columnName2"}, // Column Name 2
					new String[]{
							"INTEGER NOT NULL", // Column Data 1
							"VARCHAR(255) NOT NULL"}, // Column Data 2
					"PRIMARY KEY(Id)");
			System.out.println(table.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}