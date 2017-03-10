package test.xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import main.java.kd.jkdl.xml.JXML;

/**
 * Basic customer test.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class TestXML2 
{
	private static final File _file = new File("C:/Test/customer.xml");
	
	public static void main(String[] args) 
			throws IOException 
	{
		Customer customer = new Customer();
		customer.setAge(45);
		customer.setId(23);
		customer.setName("name");
		
		// Write to XML File
		JXML.writeObjectToXML(_file, customer);
		
		// Read from XML File
		List<Object> objects = JXML.readObjectFromXML(_file);
		for(Object o : objects)
		{
			System.out.println(o);
		}
	}
	
	//======================================== Example class
	
	@XmlRootElement
	public static class Customer
	{
		String name;
		int age;
		int id;
		
		public String getName() 
		{
			return name;
		}
		
		@XmlElement
		public void setName(String name) 
		{
			this.name = name;
		}
		
		public int getAge() 
		{
			return age;
		}
		
		@XmlElement
		public void setAge(int age) 
		{
			this.age = age;
		}
		
		public int getId() 
		{
			return id;
		}
		
		@XmlAttribute
		public void setId(int id) 
		{
			this.id = id;
		}
	}
}