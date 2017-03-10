package test.serialization;

import java.io.File;
import java.io.IOException;

import main.java.kd.jkdl.serialization.serialization.JavaSerialization;

/**
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class Test1 
{
	public static void main(String[] args)
	{
		File file = new File("C:\\Users\\k_dobrzynski\\Desktop\\ser.bin");
		JavaSerialization js = new JavaSerialization();
		js.addObject("asd", new Integer(70));
		js.addObject("1", 1);
		js.addObject("2.0", 2.0);
		js.addObject("asd", "asd");
		js.addObject("js", new JavaSerialization());
		js.addObject("js2", new JavaSerialization());
		try 
		{
			js.serialize(file);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		JavaSerialization js2 = new JavaSerialization();
		try 
		{
			js2.deserialize(file);
			System.out.println(js2.get("2.0"));
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}