package test.sql;

import main.java.kd.jkdl.sql.api.ISQLDatabase;
import main.java.kd.jkdl.sql.api.ISQLObject;
import main.java.kd.jkdl.sql.api.ISQLTable;
import main.java.kd.jkdl.sql.core.SQLDriver;

/**
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class TestSQL1 
{
    public static void main(String[] args) 
    {
        try
        {
            SQLDriver.useDriver(SQLDriver.MYSQL);
            SQLDriver.setDatabaseURL("localhost", "3306", "generatoryaplikacji");
            ISQLDatabase db = SQLDriver.login("root", "");
            System.out.println(db.toString());
            ISQLTable aaaTable = db.getTable("aaa");
            System.out.println(aaaTable.toString());
//            SQLTable aaaTable = db.createTable("aaa", 
//                                                new String[]{"columnName1"}, 
//                                                new String[]{"INT(10)"}, "");
            ISQLObject first = aaaTable.getObject(1);
            System.out.println(first.toString());
            int x = first.<Integer>getVariable("columnName1");
            System.out.println("columnName1 = " + x);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
